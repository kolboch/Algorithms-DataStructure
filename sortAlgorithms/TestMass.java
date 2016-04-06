package sortAlgorithms;

import lists.ArrayList;
import lists.Car;
import lists.CarComparatorYear;
import lists.CarFactory;
import sortedCases.SortExtent;

public class TestMass {
	
	public static void main(String[]args){
		
		long sum =0;
		int i = 100;
		for(int k = i ; k>0; k--){
		CarComparatorYear comp = new CarComparatorYear();
		CarFactory cf = new CarFactory(2100,1900,150,100,4,10000);
		Object[]testCases1 = cf.generate(SortExtent.RANDOM);
		Car[]testCases = (Car[])testCases1;
		ArrayList array = new ArrayList(testCases);
		long timeStart;
		HeapSort heap = new HeapSort(comp);
		timeStart = System.currentTimeMillis();
		heap.sort(array);
		sum += (System.currentTimeMillis() - timeStart);
		}
		long averageTime = sum / i ;
		System.out.println("Average time for algorithm: " + averageTime);
		
	}
	
	private static Car[] copyArray(Car[]toCopy){
		Car[]copied = new Car[toCopy.length];
		int i = 0;
		for(Car c : toCopy){
			Car copy = new Car(c);
			copied[i++] = copy;
		}
		return copied;
	}
}
