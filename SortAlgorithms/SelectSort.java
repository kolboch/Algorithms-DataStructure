package sortAlgorithms;

import lists.*;
import java.util.Comparator;

public class SelectSort implements ListSorter {
	
	private ArrayList array;
	private final Comparator comparator;
	
	public SelectSort(Comparator comparator){
		this.comparator = comparator;
	}
	
	@Override
	public List sort(List list) {
		array = new ArrayList(list);
		
		for(int i = 0; i < array.size(); i++){
			Object minimum = array.get(i);
			for(int j = i; j < array.size(); j++){
				
				if(comparator.compare(minimum, array.get(j)) > 0){
					minimum = array.get(j);
				}
				
			}
			array.swap(i, array.getIndexOf(minimum));
		}
		
		return array;
	}
}
