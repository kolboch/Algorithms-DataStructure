package avltree;

public class Node {
	
	Object value;
	int balance;
    Node leftChild;
    Node rightChild;
    static final int LEFT_HIGHER = 1;
    static final int BALANCED = 2;
    static final int RIGHT_HIGHER = 3;
    
    public Node(Object x){
    	value=x;
    	balance = BALANCED;
    	leftChild = rightChild = null;
    }
    
    public String writeBalance(){
    	return balance == 1 ? "LeftHeavy" : balance == 2 ? "Balanced" : "RightHeavy";
    }
}
