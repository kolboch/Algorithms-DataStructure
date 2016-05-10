package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree {
	
  public Node root;
	
  private Comparator comp;
	
  public BinarySearchTree(Comparator comp){
	  
	  this.comp = comp;
	  
  }
  
  public int contains(Object x){ // changed boolean to int to test number of comparisions
	  
	 // Node t = search(x);
	  return search(x);
	  /*
	  if(t != null){
	   
		  return true;
	  }
	  else{
		  return false;
	  }
	  */
  }
      
  private int search(Object value) { // changed Node to int for testing
      int compareCounter = 1; // added for testing
	  Node node = root;
      int compareResult = 0;
      
      while (node != null &&(compareResult = comp.compare(value, node.value))!=0){
    	  
    	  if(compareResult < 0){
    		  node = node.leftChild;
    	  }
    	  else{
    		  node = node.rightChild;
    	  }
    	  compareCounter++;
      }
      return compareCounter; //changed from node to compareCounter
  }

  
  public void insert(Object value) throws DuplicateItemException{
     
	  root= insert(value,root);
     
  }
      
  private Node insert(Object value, Node t) throws DuplicateItemException{
        
	  if(t== null){
		  
		  t=new Node(value);
		  
	  }
      else{ 
         
    	  int compareResult = comp.compare(value, t.value);
              
    	  if(compareResult < 0){
    		
    		  t.leftChild = insert(value, t.leftChild);
    		  
    		  
    	  }
          else if(compareResult > 0){
        	  
        	  t.rightChild = insert(value, t.rightChild);
        	  
          }
          else{
        	  throw new DuplicateItemException(value.toString());
          }
     }       
      
	 return t;
  }

  
  
  public void delete(Object value){
	
	  root = delete(value, root);
	  
  }
  
  private Node delete(Object value, Node t){
	  
	  if(t==null){
		  throw new NoSuchElementException(value.toString());
	  }
      else{
    	  int compareResult = comp.compare(value,t.value);
            
    	  if(compareResult < 0){
    		  
    		  t.leftChild = delete(value,t.leftChild);
    		  
    	  }
    	  else if(compareResult > 0){
    		  
    		  t.rightChild = delete(value,t.rightChild);
    		  
    	  }
          else if(t.leftChild != null && t.rightChild != null){
          
    		  t.rightChild = detachMinimalNode(t.rightChild ,t);
    		  
    	  }
          else{
        	  if(t.leftChild != null){
        		  t = t.leftChild;
        	  }
        	  else{
        		  t = t.rightChild;
        	  }
    	 }
      }           
      return t;
 }
  
  private Node detachMinimalNode(Node t, Node toDelete){
	 
	  if(t.getLeftChild() != null){
		 
		  t.leftChild = detachMinimalNode(t.leftChild, toDelete);
		 
	  }
	  else{
		  Object value = t.getValue();
		  toDelete.setValue(value);
		  t = t.rightChild;
	  }
	  return t;
  }
  
  public void clear(){
	  root = null;
  }
  
  public int heightOfTree(){
	  return getHeight(root, 0) - 1;
  }
  
  private int getHeight(Node root, int level){
	  level++;
	  int height = level;
	  
	  if(root != null){
		  if(root.leftChild != null){
			  height = getHeight(root.leftChild, level);
		  }
		  if(root.rightChild != null){
			  height = getHeight(root.rightChild, level);
		  }
		  
	  }
	  
	  return height;
  }
  
  public void levelOrderPrint(){
	  levelPrintTree(root);
  }
  
  private void levelPrintTree(Node root){
	  
	  if( root == null){ return;
	  }
	  
	  Queue<Node> q1 = new LinkedList<Node>();
	  Queue<Node> q2 = new LinkedList<Node>();
	  
	  q1.add(root);
	  
	  while(!q1.isEmpty() || !q2.isEmpty()){
		  
		  while(!q1.isEmpty()){
			  
			  Node current = q1.poll();
			  if(current.leftChild != null){ q2.add(current.leftChild);
			  }
			  if(current.rightChild != null){ q2.add(current.rightChild);
			  }
			  System.out.print(current.value.toString() + " ");
			  
		  }
		  
		  System.out.println();
		  
		  while(!q2.isEmpty()){
			  
			  Node current = q2.poll();
			  if(current.leftChild != null){ q1.add(current.leftChild);
			  }
			  if(current.rightChild != null){ q1.add(current.rightChild);
			  }
			  System.out.print(current.value.toString() + " ");
		  }
		  
		  System.out.println();
		  
	  }
	  
  }
  
  
  
  public void preOrder(){ // Visit Left Right
	  preOrder(root);
  }
  
  private void preOrder(Node root){
	  
	  if(root != null){
		  System.out.print(root.value + " ");
		  preOrder(root.leftChild);
		  preOrder(root.rightChild);
	  }
	  else{ return;}
  }
  
  public void postOrder(){ // Left Right Visit
	  postOrder(root);
  }
  private void postOrder(Node root){
	  
	  if(root == null){
		  return;
	  }
	  postOrder(root.leftChild);
	  postOrder(root.rightChild);
	  System.out.print(root.value.toString() + " ");
	  
  }
  
  public void printInOrder(){ // Left Visit Right
	 
	  printInOrder(root);
	  
  }
  
  private void printInOrder(Node t){
	if(t != null){
	  
	  if(t.leftChild != null){
		  printInOrder(t.leftChild);
		  System.out.print(t.value.toString() + " ");
		  printInOrder(t.rightChild);
	  }
	  else{
		  System.out.print(t.value.toString() + " ");
		  printInOrder(t.rightChild);
	  }
	}
  }
  
  public boolean isEmpty(){
	  return root == null;
  }
  
  public void DSWalgorithm(){
	  
	  DSWalgorithm(root);
	  
  }
  
  private void DSWalgorithm(Node root){
	  if(root != null){
		  createRightLinked();
		  createBalancedBST();
	  }
  }
  
  private void createRightLinked(){
	  
	  Node grandParent = null;
	  Node parent = root;
	  Node leftChild;
	  
	  while(parent != null){
		  
		  leftChild = parent.leftChild;
		  
		  if(leftChild != null){
			  
			  grandParent = rotateRight(grandParent, parent, leftChild);
			  parent = leftChild;
		  
		  }
		  else{
			  
			  grandParent = parent;
			  parent = parent.rightChild;
			  
		  }
		  
	  }
	  
	  
  }
  
  private Node rotateRight(Node grandParent, Node parent, Node leftChild){
	  
	  if(grandParent != null){
		  
		  grandParent.rightChild = leftChild;
		  
	  }
	  else{
		  
		  root = leftChild;
		  
	  }
	  
	  parent.leftChild = leftChild.rightChild;
	  
	  leftChild.rightChild = parent;
	  
	  return grandParent;
  }
  
  private void createBalancedBST(){
	  
	  int n = 0;
	  
	  for(Node tmp = root; tmp != null; tmp = tmp.rightChild){
		
		  n++;
		  
      }
	  int m = greatestPowerOf2LessThanN( n + 1) - 1;
	  makeRotations(n - m);
	  
	  while(m > 1){
		  makeRotations(m /= 2);
	  }
  }
  
  private int greatestPowerOf2LessThanN(int n){
	  int x = mostSignificantBit(n);
	  return (int)Math.pow(2, x);
  }
  
  public int mostSignificantBit(int n ){
	  
	  int index = 0;
	  while(1 < n){
		  n /= 2;
		  index++;
	  }
	  return index;
	  
  }
  
  public void makeRotations(int bound){
  
	  Node grandParent = null;
	  Node parent = root;
	  Node child = root.rightChild;
	  
	  for( ; bound > 0; bound--){
		  
		  try{
			  
			  if( child != null){
				  
				  rotateLeft(grandParent, parent, child);
				  grandParent = child;
				  
				  parent = grandParent.rightChild;
				  
				  child = parent.rightChild;
				  
			  }
			  else{
				  break;
			  }
			  
		  }
		  catch (NullPointerException e){
			  e.printStackTrace();
		  }
		  
		}
  }
  
  private void rotateLeft(Node grandParent, Node parent, Node rightChild){
	  
	  if(grandParent != null){
		  grandParent.rightChild = rightChild;
	  }
	  else{
		  root = rightChild;
	  }
	  parent.rightChild = rightChild.leftChild;
	  
	  rightChild.leftChild = parent;
	  
  }
  
}
