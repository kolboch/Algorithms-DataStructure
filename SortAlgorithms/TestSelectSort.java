package SortAlgorithms;

import lists.*;

public class TestSelectSort{
	public static void main(String[]args){
		try{
			 SelectSort testInsert = new SelectSort(new CarComparatorYear());
			 CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 7);
			 ArrayList array = new ArrayList(cf.produceCars());
			 
			 ArrayList array2 = new ArrayList(testInsert.sort(array));
			
			 array2.printAll();
			
			
			 }catch(IllegalArgumentException e){
			  	e.printStackTrace();
			 }
		  }
	
}