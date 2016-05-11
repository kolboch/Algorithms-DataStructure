package avltree;

import java.util.Comparator;

public class AVL {
    
	private final Comparator comparator;
    public Node root;
    
    static boolean heightChanged = false;
	
    static final int LEFT_HIGHER = 1;
    static final int BALANCED = 2;
    static final int RIGHT_HIGHER = 3; 
    
    public AVL(Comparator comparator){
    	this.comparator = comparator;
    	this.root = null;
    }
    
    public Object find(Object x){
    	Node t = search(x);
    	if( t != null){
    		return t.value;
    	}
    	return null;
    }
        
    private Node search(Object value){
        Node node = root;
        int cmp=0;
        while (node != null &&(cmp = comparator.compare(value, node.value))!=0){
        	if(cmp < 0){
        		node = node.leftChild;
        	}
        	else{
        		node = node.rightChild;
        	}
        }
         return node;
    }
    
    public void insert(Object x){
    	this.root = insert(x, root);
    }
      
    protected Node insert(Object x, Node t) {
    	  if(t == null){
    		  t = new Node(x);
    		  heightChanged = true;
    	  }
    	  else
    	  {
    		  int cmp = comparator.compare(x,t.value);
	    	  if(cmp < 0){
	    		 
	    		  t.leftChild = insert(x,t.leftChild);
	    		  if(heightChanged){
	    			  t = insertBalanceLeft(t);
	    		  }
	    		  
	    	  }
	    	  else if(cmp > 0){
	    		  
	    		  t.rightChild = insert(x,t.rightChild);
	    		  if(heightChanged){
	    			  t = insertBalanceRight(t);
	    		  }
	    		  
	    	  }
	    	  else{
	    		  throw new DuplicateItemException(x.toString());
	    	  }
    	  }       
    	 
    	  return t;
    }
    
    Node insertBalanceLeft(Node node){
    	switch (node.balance){
    		case RIGHT_HIGHER:
    			node.balance = BALANCED;
    			heightChanged=false;
    			break;
    			
    		case BALANCED:
    			node.balance = LEFT_HIGHER;
    			break;
    			
    		case LEFT_HIGHER:
    			if(node.leftChild.balance==LEFT_HIGHER){
    				node.balance=BALANCED;
    				node = rotateRight(node);
    			}
                else{
                	node=rotateLeftRight(node);
                	if(node.balance == RIGHT_HIGHER){
                		node.leftChild.balance = LEFT_HIGHER;
                		node.rightChild.balance = BALANCED;
                	}
                	else if(node.balance == LEFT_HIGHER){
                		node.leftChild.balance = BALANCED;
                		node.rightChild.balance = RIGHT_HIGHER;
                	}
                	else{
                		node.leftChild.balance = BALANCED;
                    	node.rightChild.balance = BALANCED;
                	}
                	
                }
    			node.balance = BALANCED;
    			heightChanged = false;
    			
         }
      return node;   
      }

     Node insertBalanceRight(Node node){
    	 switch (node.balance){
    	 	case LEFT_HIGHER:
    	 		node.balance = BALANCED;
    	 		heightChanged = false;
    	 		break;
    	 		
            case BALANCED:
            	node.balance = RIGHT_HIGHER;
            	break;
            	
            case RIGHT_HIGHER: 
            	if(node.rightChild.balance == RIGHT_HIGHER){
            		node = rotateLeft(node);
            		node.balance = BALANCED;
            	}
                else{
                	node = rotateRightLeft(node);
                	if(node.balance == RIGHT_HIGHER){
                		node.leftChild.balance = LEFT_HIGHER;
                		node.rightChild.balance = BALANCED;
                	}
                	else if(node.balance == LEFT_HIGHER){
                		node.leftChild.balance = BALANCED;
                		node.rightChild.balance = RIGHT_HIGHER;
                	}
                	else{
                		node.leftChild.balance = BALANCED;
                    	node.rightChild.balance = BALANCED;
                	}
                }
            	
            	node.balance = BALANCED;
            	heightChanged = false;
    	 }
       return node;     
     }


   Node rotateRight(Node t){
	   Node t1=t.leftChild;
	   t.leftChild = t1.rightChild;
	   t1.rightChild = t;
	   return t1;
   }

   Node rotateLeft(Node t){
	   Node t1 = t.rightChild;
	   t.rightChild = t1.leftChild;
	   t1.leftChild = t;
	   return t1;
   }

  Node rotateLeftRight(Node t){
	  t.leftChild = rotateLeft(t.leftChild);
	  return rotateRight(t);
  }

  Node rotateRightLeft(Node t){
	  t.rightChild = rotateRight(t.rightChild);
	  return rotateLeft(t);
  }   
    
  public void delete(Object x){
	  root=delete(x,root);
  }
    
  protected Node delete(Object x, Node t){
      if(t==null){
    	  throw new ItemNotFoundException(x.toString());
      }
      else{
    	  	int cmp = comparator.compare(x,t.value);
            if(cmp<0){
            	 t.leftChild = delete(x,t.leftChild);
            	 if(heightChanged){
            		 t = deleteBalanceLeft(t);
            	 }
            }  
            else if(cmp>0){
            	 t.rightChild = delete(x,t.rightChild);
            	 if(heightChanged){
            		 t = deleteBalanceRight(t);
            	 }
            }
            else if(t.leftChild != null && t.rightChild != null){
            	 t.rightChild = detachMinimal(t.rightChild,t); 
            	 if(heightChanged){
            		 t = deleteBalanceRight(t);
            	 }
            }  
            else{
            	 heightChanged = true;
            	 t = (t.leftChild != null) ? t.leftChild : t.rightChild;
            }
      }           
      return t;
    }  
     
  	//zast¹pienie elementu jego nastêpnikiem i usuniêcie nastêpnika
	protected Node detachMinimal(Node t, Node del){
      if(t.leftChild != null){
    	  t.leftChild = detachMinimal(t.leftChild, del);
          if(heightChanged){
        	  t = deleteBalanceLeft(t);
          }
      } 
      else{
    	  del.value=t.value;
    	  heightChanged=true;
    	  t = t.rightChild;
      }
      return t;
    }  
 
  // Wywazanie wezla gdy skrocone zostalo lewe poddrzewo

     Node deleteBalanceLeft(Node t){
    	 switch (t.balance){
    	 	case LEFT_HIGHER:
    	 		t.balance = BALANCED;
    	 		break;
    	 	case BALANCED:
    	 		t.balance = RIGHT_HIGHER;
    	 		heightChanged = false;
    	 		break;
    	 	case RIGHT_HIGHER:
    	 		if(t.rightChild.balance==LEFT_HIGHER){
    	 				t = rotateRightLeft(t);
                        t.leftChild.balance = t.balance == RIGHT_HIGHER ? LEFT_HIGHER : BALANCED;
                        t.rightChild.balance = t.balance == LEFT_HIGHER ? RIGHT_HIGHER : BALANCED;
                        t.balance=BALANCED;
                }
    	 		else{
    	 			t=rotateLeft(t);
    	 			if(t.balance==BALANCED){
    	 				t.leftChild.balance = RIGHT_HIGHER;
    	 				t.balance = LEFT_HIGHER;
    	 				heightChanged = false;
    	 			}
    	 			else{
    	 				t.leftChild.balance = BALANCED;
    	 				t.balance = BALANCED;
    	 			}
    	 		}
         }
       return t;  
      }

// Prawe poddrzewo uleglo skroceniu
     Node deleteBalanceRight(Node t){
    	 switch (t.balance){
    	 	case RIGHT_HIGHER :
    	 		t.balance = BALANCED;
    	 		break;
    	 	case BALANCED :
    	 		t.balance = LEFT_HIGHER;
    	 		heightChanged = false;
    	 		break;
    	 	case LEFT_HIGHER :
    	 		if(t.leftChild.balance == RIGHT_HIGHER){
    	 			t=rotateLeftRight(t);
                    t.rightChild.balance = t.balance == LEFT_HIGHER ? RIGHT_HIGHER  : BALANCED;
                    t.leftChild.balance = t.balance == RIGHT_HIGHER ? LEFT_HIGHER : BALANCED;
                    t.balance = BALANCED;
                       }
    	 		else{
    	 			t=rotateRight(t);
    	 			if(t.balance==BALANCED){
    	 				t.rightChild.balance = LEFT_HIGHER;
    	 				t.balance = RIGHT_HIGHER;
    	 				heightChanged = false;
    	 			}
    	 			else{
    	 				t.rightChild.balance = BALANCED;
    	 				t.balance=BALANCED;
    	 			}
    	 		}
           }
       return t;    
      }  
    
//prosty wydruk struktury drzewa      
    public String toString(){
    	return toString(root,0);}
     
    private String toString(Node t,int pos) {   
    String result="";
    String spaces="                                                                                                                                                                                                     ";
    if(t!=null) result=result+toString(t.rightChild,pos+4)+spaces.substring(0,pos)+String.format("%s/%s",t.value,t.writeBalance())+toString(t.leftChild,pos+4);
    else result=result+String.format("%n");
    return result;
    }

//wydruk nie wymagaj¹cy ³amania karku przy czytaniu
	int max(int x, int y)
	{ return x > y ? x : y; }

	int height(Node t)
	{ return t == null ? 0 : max(height(t.leftChild), height(t.rightChild)) + 1; }
      
   public String printTree()
    { class QueueElement
        { Node el ; 
          int level; 
          int pos; 
          int delta;
          QueueElement(Node e, int lev, int p,int del)
          {el=e; level=lev; pos=p; delta=del; }
        };
  QueueElement[] q= new QueueElement[200];
  String result="";
  int last=0;
  int pos0=1;
  for(int i=0;i<height(root);i++)
    pos0 *= 2;
  pos0=pos0*3;  
  if(root!=null)
  { q[0]=new QueueElement(root,0,pos0,pos0);
    for(int i =0; i<=last; i++)
		{ if (q[i].el.leftChild != null )
		     q[++last]=new QueueElement( q[i].el.leftChild,q[i].level+1,q[i].pos-q[i].delta/2,q[i].delta/2);
		  if (q[i].el.rightChild!=null)
		     q[++last]=new QueueElement( q[i].el.rightChild,q[i].level+1,q[i].pos+q[i].delta/2,q[i].delta/2);
		}

    result=result+spaces(pos0-3)+String.format(" %2s/%s ",q[0].el.value,q[0].el.writeBalance());
 	for (int i=1; i<=last;i++)
	  if( q[i-1].level < q[i].level)
	       result=result+String.format("%n")+spaces(q[i].pos-3)+String.format(" %2s/%s ",q[i].el.value,q[i].el.writeBalance());  
	  else result=result+spaces(q[i].pos-q[i-1].pos-6)+String.format(" %2s/%s ",q[i].el.value,q[i].el.writeBalance());
    result=result+String.format("%n%n");
  }
  return result;
}
    private String spaces(int n)
     { String res="";
       for (int i=0;i<n;i++)
           res+=" ";
       return res;
      }  
      
    public class DuplicateItemException extends RuntimeException {
        public DuplicateItemException(String message)
        { super(message); }
    } 
    
    public class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message)
        { super(message); }
    }
    
}
