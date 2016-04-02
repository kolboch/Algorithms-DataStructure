package sortAlgorithms;


import java.util.Comparator;
import lists.ArrayList;
import lists.List;

public final class BubbleSort implements ListSorter {
	
	private ArrayList array;
	private final Comparator comparator;
	public BubbleSort(Comparator comparator){
		this.comparator = comparator;
	}
	
	@Override
	public List sort(List list) {
		array = new ArrayList(list);
		boolean sorted = false;
		for(int i = 0; i < array.size() && !sorted ; i++){
			sorted = true;
			for(int j = 0; j < array.size() - i - 1; j++){
				
				if(comparator.compare(array.get(j), array.get(j+1)) > 0){
					array.swap(j, j+1);
					sorted = false;
				}
				
			}
			
		}
		
		return array;
	}
	
	

}
