package sortAlgorithms;

import java.util.Comparator;

import lists.ArrayList;
import lists.CarComparatorYear;
import lists.CarFactory;
import lists.List;
import tree.Heap;

public class HeapSort implements ListSorter{
	
	private Heap heap;
	
	public HeapSort(Comparator comparator){
		this.heap = new Heap(comparator);
	}

	@Override
	public List sort(List list) {
		ArrayList array = new ArrayList(list);
		for(int i=0; i< array.size(); i++){
			heap.insert(array.get(i));
		}
		
		for(int i = heap.size() - 1; i >= 0; i--){
			array.set(i, heap.delete());
		}
		return array;
	}
	
	public static void main(String[]args){
		
		HeapSort hp = new HeapSort(new CarComparatorYear());
		CarFactory cf = new CarFactory(1900,1800,20,10,4,10);
		Object[]array = cf.generate();
		ArrayList array2 = new ArrayList(array);
		array2.printAll();
		System.out.println();
		ArrayList sorted = (ArrayList)hp.sort(array2);
		sorted.printAll();
	}
	
	
	
	
}
