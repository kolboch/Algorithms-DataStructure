package sortAlgorithms;

import java.util.Comparator;

import lists.ArrayList;
import lists.CarComparatorYear;
import lists.CarFactory;
import lists.List;

public class QuickSort implements ListSorter{

	private final Comparator comparator;
	
	public QuickSort(Comparator comparator){
		this.comparator = comparator;
	}
	
	@Override
	public List sort(List list) {
		quickSort(list, 0, list.size() - 1);
		return list;
	}

	private int splitIndex(List list, int leftBorder, int rightBorder){
		
		Object value = list.get(rightBorder);
		int pivot = leftBorder - 1;
		
		while(leftBorder <= rightBorder)	{
			
			if(comparator.compare(list.get(leftBorder), value) <= 0){
				
				swap(list, ++pivot, leftBorder);
				
			}
			
			++leftBorder;
			
		}
		if(pivot < rightBorder){
			return pivot;
		}
		else{
			return rightBorder - 1;
		}
	}
	
	public void quickSort(List list, int startIndex, int lastIndex){
		
		if(lastIndex > startIndex){
			
			int splitIndex = splitIndex(list, startIndex, lastIndex);
			
			quickSort(list, startIndex, splitIndex);
			
			quickSort(list, splitIndex + 1, lastIndex);
			
		}
		
	}
	
	private void swap(List list, int firstIndex, int secondIndex){
		
		if(firstIndex != secondIndex){
			
			Object temp = list.get(firstIndex);
			list.set(firstIndex, list.get(secondIndex));
			list.set(secondIndex, temp);
		
		}
	}
	
	public static void main(String[]args){
		
		QuickSort qs = new QuickSort(new CarComparatorYear());
		
		CarFactory cf = new CarFactory(1900,1800,20,10,4,10);
		Object[]array = cf.generate();
		ArrayList array2 = new ArrayList(array);
		array2.printAll();
		System.out.println();
		ArrayList sorted = (ArrayList)qs.sort(array2);
		sorted.printAll();
		
	}
	
}
