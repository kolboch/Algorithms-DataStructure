package testPackage;

import lists.*;
import sortAlgorithms.SelectSort;
import sortedCases.SortExtent;

public class TestSelectSort{
	public static void main(String[]args){
		
		long timeStart = System.currentTimeMillis();
		
		try{
			 SelectSort testInsert = new SelectSort(new CarComparatorYear());
			 CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 10000);
			 ArrayList array = new ArrayList(cf.generate(SortExtent.RANDOM));
			 
			 ArrayList array2 = new ArrayList(testInsert.sort(array));
			
			 //array2.printAll();
			
			
			 }catch(IllegalArgumentException e){
			  	e.printStackTrace();
			 }
		
			System.out.println("TimeElapsed: " +  (System.currentTimeMillis() - timeStart));
		
		 }
	
}