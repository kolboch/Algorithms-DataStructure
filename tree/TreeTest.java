package tree;

import lists.Car;
import lists.CarComparatorYear;

public class TreeTest {
	
	public static void main(String[]args){
		
		Car car1 = new Car(1900, 200, 4);
		Car car2 = new Car(1902, 200, 4);
		Car car3 = new Car(1901, 200, 4);
		Car car4 = new Car(1945, 200, 4);
		Car car5 = new Car(1911, 200, 4);
		Car car6 = new Car(1998, 200, 4);
		Car car7 = new Car(1997, 200, 4);
		Car car8 = new Car(1996, 200, 4);
		Car car9 = new Car(1700, 200, 4);
		Car car10 = new Car(1701, 200, 4);
		Car car11 = new Car(1699, 200, 4);
		Car car12 = new Car(1702, 200, 4);
		Car car13 = new Car(1905, 210, 4);
		
		BinarySearchTree tree = new BinarySearchTree(new CarComparatorYear());
		
		try{
			tree.insert(car1);
			tree.insert(car2);
			tree.insert(car3);
			tree.insert(car4);
			tree.insert(car5);
			tree.insert(car6);
			tree.insert(car7);
			tree.insert(car8);
			tree.insert(car9);
			tree.insert(car10);
			tree.insert(car11);
			tree.insert(car12);
			tree.insert(car13);
		}
		catch(DuplicateItemException e){
			e.printStackTrace();
		}
		
		// System.out.println(tree.heightOfTree());
		
		
		System.out.println("Levelorder: ");
		tree.levelOrderPrint();
		
		System.out.println("Preorder: ");
		tree.preOrder();
		
		System.out.println("\nInorder: ");
		tree.printInOrder();
		
		System.out.println("\nPostOrder: ");
		tree.postOrder();
		
		System.out.println("");
		BTreePrinter.printNode(tree.root);
		
		tree.DSWalgorithm();
		
		System.out.println();
		BTreePrinter.printNode(tree.root);
		
	}
}
