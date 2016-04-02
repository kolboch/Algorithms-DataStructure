package sortAlgorithms;

import java.util.Comparator;

import lists.*;

public class ShellSort implements ListSorter{

	private ArrayList array;
	private final Comparator comparator;
	
	public ShellSort(Comparator comparator){
		this.comparator = comparator;
	}
	
	@Override
	public List sort(List list) {
		array = new ArrayList(list);
		
		int n = array.size() / 2;
		
		while(n > 0){
			
			for(int i = 0; i < n; i++){
				
				int j = i;
				boolean noSwap = false;
				while( j + n < array.size()){
					
					noSwap = true;
					if(comparator.compare(array.get(j), array.get(j+n)) > 0){
						array.swap(j, j+n);
						noSwap = false;
					}
					if(!noSwap){
						j = i;
					}
					else{
						j += n;
					}
					
				}
				
			}
			
			n /= 2;
		}
		
		
		return array;
	}
		
		
	

}
