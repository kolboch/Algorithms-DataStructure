package sortAlgorithms;

import lists.*;

public class TestShellSort {

	public static void main(String[]args){
		
		try{
			 ShellSort testInsert = new ShellSort(new CarComparatorYear());
			 CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 40);
			 ArrayList array = new ArrayList(cf.produceCars());
			 
			 ArrayList array2 = new ArrayList(testInsert.sort(array));
			
			 array2.printAll();
			
			
		}
		catch(IllegalArgumentException e){
			  	e.printStackTrace();
		}
		
		
	}
}
