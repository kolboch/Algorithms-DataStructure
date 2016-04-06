package testPackage;

import lists.*;
import sortAlgorithms.BubbleSort;
import sortedCases.SortExtent;

public class TestBubble {
	public static void main(String[]args){
		long timeStart = System.currentTimeMillis();
		try{
		BubbleSort testBubble = new BubbleSort(new CarComparatorYear());
		CarFactory cf = new CarFactory(2016, 1900, 400, 100, 4, 100);
		ArrayList array = new ArrayList(cf.generate(SortExtent.SORTED));
		
		ArrayList array2 = new ArrayList(testBubble.sort(array));
		
		//array2.printAll();
		
		
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		System.out.println("TimeElapsed: " +  (System.currentTimeMillis() - timeStart));
	}
}