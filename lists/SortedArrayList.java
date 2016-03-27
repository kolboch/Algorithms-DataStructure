package lists;

import java.util.Comparator;

public class SortedArrayList extends ArrayList{
	
	
	
	private Comparator comp;
	
	public SortedArrayList(Comparator comp){
		super();
		this.comp = comp;
	}
	
	public void add(Object value) throws NullPointerException{
		if(value == null)
			throw new NullPointerException("Cannot add null Object");
		if(isFull())
			reSize();
		
		if(size()==0){
			super.add(value);
		}
		else
		{
		int i=0;
		for(  ; i<size()-1 && comp.compare(value,super.get(i)) >= 0 ; i++){	
			
		}
		
		if(i==size()){
			super.set(size(), value);
		}
		else{
			
			int j;
			
			for(j = size(); j > i; j--){
				super.set(j, super.get(j-1));
				
			}
			super.set(j, value);
		}
		super.increaseSize();
		}
	}
	
	
}
