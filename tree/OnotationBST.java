package tree;

import java.util.Random;

import lists.Car;
import lists.CarComparatorYear;
import lists.CarFactory;

// in this class we will test cases for balanced binary tree and non balanced and how many compares would it take
public class OnotationBST {

	public static void main(String[]args){
		
		BinarySearchTree bst = new BinarySearchTree(new CarComparatorYear());
		int testCases = 6400;
		CarFactory cf = new CarFactory(5000, 0, 400, 100, 4, testCases);
		Car[]arrayOfCars = (Car[])cf.generate();
		
		for(int i = 0; i < arrayOfCars.length; i++){
			try{
			bst.insert(arrayOfCars[i]);
			}
			catch(DuplicateItemException e){
				e.printStackTrace();
			}
		}
		
		bst.DSWalgorithm();
		
		Random r = new Random();
		
		int sumOfComparisions = 0;
		int j = 50; // number of testCases
		int divide = j;
		
		while(--j > 0){
			
			Car toFind = arrayOfCars[r.nextInt(testCases)];
			sumOfComparisions += bst.contains(toFind);
			
		
		}
		
		System.out.println("Average comparisions before result: " + (sumOfComparisions / divide));
		
	}
	
	
	
}
