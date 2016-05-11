package avltree;

import lists.Car;
import lists.CarComparatorYear;
import tree.TreePrinter;

public class Test {
	
	public static void main(String[]args){
		
		Car car1 = new Car(1900, 200, 4);
		Car car2 = new Car(1902, 200, 4);
		Car car3 = new Car(1903, 200, 4);
		Car car4 = new Car(1904, 200, 4);
		Car car5 = new Car(1905, 200, 4);
		Car car6 = new Car(1906, 200, 4);
		Car car7 = new Car(1907, 200, 4);
		Car car8 = new Car(1908, 200, 4);
		Car car9 = new Car(1909, 200, 4);
		
		AVL tree = new AVL(new CarComparatorYear());
		
			tree.insert(car1);
			tree.insert(car2);
			tree.insert(car3);
			tree.insert(car4);
			tree.insert(car5);
			tree.insert(car6);
			tree.insert(car7);
			tree.insert(car8);
			tree.insert(car9);
			
		
		BTreePrinter.printNode(tree.root);
		
	}
}


