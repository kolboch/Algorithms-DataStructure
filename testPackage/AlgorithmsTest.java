package testPackage;

import lists.ArrayList;
import lists.Car;
import lists.CarComparatorYear;
import lists.CarFactory;
import lists.List;
import sortAlgorithms.BubbleSort;
import sortAlgorithms.InsertSort;
import sortAlgorithms.SelectSort;
import sortAlgorithms.ShellSort;
import sortedCases.SortExtent;

public class AlgorithmsTest {
	
	private static final CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 100);
	private static final ArrayList array = new ArrayList(cf.generate(SortExtent.RANDOM));
	
	
	public static void main(String[]args){
		
		AlgorithmsTest at = new AlgorithmsTest();
		
		at.testBubbleSort(at.copyOfArray(array));
		
		at.testInsertSort(at.copyOfArray(array));
		
		at.testShellSort(array);
		
		at.testSelectSort(array);
	}
	/*
	private ArrayList copyTest(ArrayList array){
		ArrayList copy = new ArrayList();
		
		for(int i = 0; i < array.size() ; i++){
			copy.add(array.get(i));
		}
		
		return copy;
	}
	*/
	private ArrayList copyOfArray(ArrayList array){
		
		Object[]copyArray = new Object[array.size()];
		for(int i = 0; i < copyArray.length; i++){
			copyArray[i] = new Car((Car)array.get(i));
		}
		ArrayList copy = new ArrayList(copyArray);
		return copy;
	}
	
	private void testBubbleSort(ArrayList inArray){
		
		long timeStart = System.currentTimeMillis();
		try{
		
		printHeader("BubbleSort");
		
		ArrayList arrayCopy = copyOfArray(inArray); //test
		
		BubbleSort testBubble = new BubbleSort(new CarComparatorYear());
		
		ArrayList arrayBubble = new ArrayList(testBubble.sort(arrayCopy)); //test of copyTest
		
		// arrayBubble.printAll();
		
		
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		printResultTime("BubbleSort", timeStart);
		System.out.println();
	}
	
	private void printResultTime(String nameAlgorithm, long startTime){
		System.out.println("For "+ nameAlgorithm +" TimeElapsed: " +  (System.currentTimeMillis() - startTime));
	}
	
	private void testInsertSort(ArrayList inArray){
		
		long timeStart = System.currentTimeMillis();
		
		try{
		 
		printHeader("InsertSort");
		
		 InsertSort testInsert = new InsertSort(new CarComparatorYear());
		 ArrayList copy = copyOfArray(inArray);
		 
		ArrayList insertArray = new ArrayList(testInsert.sort(copy));
		
		 
		
		// insertArray.printAll();
		
		 
		
		 }catch(IllegalArgumentException e){
		  	e.printStackTrace();
		 }
		
		printResultTime("InsertSort", timeStart);
		System.out.println();
	}
	
	private void testSelectSort(ArrayList array){
		long timeStart = System.currentTimeMillis();
		
		try{
		 
		printHeader("SelectSort");
		 ArrayList copyArray = copyOfArray(array);
		 SelectSort testSelect = new SelectSort(new CarComparatorYear());
		 ArrayList arraySelect = new ArrayList(testSelect.sort(copyArray));
		
		 // arrayInsert.printAll();
		
		
		 }catch(IllegalArgumentException e){
		  	e.printStackTrace();
		 }
		
		printResultTime("SelectSort", timeStart);
		System.out.println();
	}
	
	private void testShellSort(ArrayList array){
		long timeStart = System.currentTimeMillis();
		try{
		
		printHeader("ShellSort");
			
		ShellSort testShell = new ShellSort(new CarComparatorYear());
		ArrayList copyArray = copyOfArray(array);
		ArrayList arrayShell = new ArrayList(testShell.sort(copyArray));
		
		// arrayBubble.printAll();
		
		
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		printResultTime("ShellSort", timeStart);
		System.out.println();
		
	}
	
	private static void printHeader(String header){
		int i = 0;
		/* 
		while(i > 0){
			System.out.print('=');
			i--;
		}
		*/
		System.out.println();
		System.out.printf("%20s%n", header);
		
		while(i < 40){
			System.out.print('=');
			i++;
		}
		System.out.println();
	}
}
