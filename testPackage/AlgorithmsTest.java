package testPackage;

import lists.ArrayList;
import lists.CarComparatorYear;
import lists.CarFactory;
import sortAlgorithms.BubbleSort;
import sortAlgorithms.InsertSort;
import sortAlgorithms.SelectSort;
import sortAlgorithms.ShellSort;
import sortedCases.SortExtent;

public class AlgorithmsTest {
	
	private CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 100);
	private ArrayList array = new ArrayList(cf.generate(SortExtent.RANDOM));
	private long timeStart;
	
	public static void main(String[]args){
		
		AlgorithmsTest at = new AlgorithmsTest();
		
		at.testBubbleSort();
		
		at.testInsertSort();
		
		at.testSelectSort();
		
		at.testShellSort();	
	}
	
	private void testBubbleSort(){
		timeStart = System.currentTimeMillis();
		try{
		
		printHeader("BubbleSort");
			
		BubbleSort testBubble = new BubbleSort(new CarComparatorYear());
		
		ArrayList arrayBubble = new ArrayList(testBubble.sort(array));
		
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
	
	private void testInsertSort(){
		timeStart = System.currentTimeMillis();
		
		try{
		 
		printHeader("InsertSort");
		 
		 InsertSort testInsert = new InsertSort(new CarComparatorYear());
		 ArrayList arrayInsert = new ArrayList(testInsert.sort(array));
		
		 // arrayInsert.printAll();
		
		
		 }catch(IllegalArgumentException e){
		  	e.printStackTrace();
		 }
		
		printResultTime("InsertSort", timeStart);
		System.out.println();
	}
	
	private void testSelectSort(){
		timeStart = System.currentTimeMillis();
		
		try{
		 
		printHeader("SelectSort");
		 
		 SelectSort testSelect = new SelectSort(new CarComparatorYear());
		 ArrayList arraySelect = new ArrayList(testSelect.sort(array));
		
		 // arrayInsert.printAll();
		
		
		 }catch(IllegalArgumentException e){
		  	e.printStackTrace();
		 }
		
		printResultTime("SelectSort", timeStart);
		System.out.println();
	}
	
	private void testShellSort(){
		timeStart = System.currentTimeMillis();
		try{
		
		printHeader("ShellSort");
			
		ShellSort testShell = new ShellSort(new CarComparatorYear());
		
		ArrayList arrayShell = new ArrayList(testShell.sort(array));
		
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
