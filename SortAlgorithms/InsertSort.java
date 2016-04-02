package SortAlgorithms;

import java.util.Comparator;
import lists.ArrayList;
import lists.List;

public class InsertSort implements ListSorter {
	
	private ArrayList array;
	private final Comparator comparator;
	
	public InsertSort(Comparator comparator){
		this.comparator = comparator;
	}
	
	@Override
	public List sort(List list) {
		array = new ArrayList(list);
		
		for(int j = 1; j < array.size(); j++){
			Object toInsert = array.get(j);
			while( (j > 0) && comparator.compare(array.get(j-1), toInsert) > 0){
				array.set(j, array.get(j-1));
				j--;
			}
			array.set(j, toInsert);
		}
		
		return array;
	}
}
