package tree;

public class Node {
  
   Node leftChild;
   Node rightChild;
   Object value;
  
  public Node(Object value){
	  
	  this.value = value;
	  leftChild = null;
	  rightChild = null;
	  
  }
  
  public Object getValue(){
	  return value;
  }
  
  public void setLeftChild(Object value){
	  leftChild = new Node(value);
  }
  
  public void setRightChild(Object value){
	  rightChild = new Node(value);
  }
  
  public void setValue(Object value){
	  this.value = value;
  }
  
  public Node getLeftChild(){
	  return leftChild;
  }
  
  public Node getRightChild(){
	  return rightChild;
  }
  
  public Object getRightChildValue(){
	  return rightChild.value;
  }
  
  public Object getLeftChildValue(){
	  return leftChild.value;
  }
}
