package sortAlgorithms;

import java.util.Comparator;

import iterators.Iterator;
import lists.ArrayList;
import lists.CarComparatorYear;
import lists.CarFactory;
import lists.List;

public class MergeSort implements ListSorter {
	
	private final Comparator comparator;
	
	public MergeSort(Comparator comparator){
		this.comparator = comparator;
	}

	@Override
	public List sort(List list) {
		return mergeSort(list, 0, list.size() - 1);
	}
	
	private List mergeSort(List list, int startIndex, int endIndex){
		//case if someone wants to get sorted one element
		if(startIndex == endIndex){
			List resultList = new ArrayList();
			resultList.add(list.get(startIndex));
			return resultList;
		}
		
		int splitIndex = startIndex + (endIndex - startIndex) / 2;
		
		return merge(mergeSort(list, startIndex, splitIndex), mergeSort(list, splitIndex+1 , endIndex));
		
	}
		
	private List merge(List left, List right){
		
		List resultList = new ArrayList();
		
		Iterator finger1 = left.iterator();
		Iterator finger2 = right.iterator();
		finger1.first();
		finger2.first();
			
			
			
				if(comparator.compare(finger1.current(), finger2.current()) <= 0){
					resultList.add(finger1.current());
					finger1.next();
				}
				else{
					resultList.add(finger2.current());
					finger2.next();
				}
		
		while(!(finger1.isDone()) && !(finger2.isDone())){
			
			if(comparator.compare(finger1.current(), finger2.current()) <= 0){
				resultList.add(finger1.current());
				finger1.next();
			}
			else{
				resultList.add(finger2.current());
				finger2.next();
			}
		}
		
		while(!finger1.isDone()){
			resultList.add(finger1.current());
			finger1.next();
		}
		while(!finger2.isDone()){
			resultList.add(finger2.current());
			finger2.next();
		}
		/*
		ArrayList arTest = (ArrayList)resultList;
		arTest.printAll();
		System.out.println();
		*/
		return resultList;
		
	}
	
	public static void main(String[]args){
		
		MergeSort mg = new MergeSort(new CarComparatorYear());
		
		CarFactory cf = new CarFactory(1900,1800,20,10,4,10);
		Object[]array = cf.generate();
		ArrayList array2 = new ArrayList(array);
		array2.printAll();
		System.out.println();
		ArrayList sorted = (ArrayList)mg.sort(array2);
		sorted.printAll();
		
	}
	
}
