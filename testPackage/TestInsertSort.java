package testPackage;

import lists.*;
import sortAlgorithms.InsertSort;
import sortedCases.SortExtent;

public class TestInsertSort {
	public static void main(String[]args){
	
		long timeStart = System.currentTimeMillis();
		
		try{
		 InsertSort testInsert = new InsertSort(new CarComparatorYear());
		 CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 10);
		 ArrayList array = new ArrayList(cf.generate(SortExtent.RANDOM));
		 System.out.println("Przed sortowaniem");
		 array.printAll();
		 System.out.println();
		 
		 ArrayList array2 = new ArrayList(testInsert.sort(array));
		
		 System.out.println("Po sortowaniu");
		 array2.printAll();
		
		
		 }catch(IllegalArgumentException e){
		  	e.printStackTrace();
		 }
		
		System.out.println("TimeElapsed: " +  (System.currentTimeMillis() - timeStart));
	  }
}
