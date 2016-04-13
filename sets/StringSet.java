package sets;

import lists.ArrayList;

public class StringSet implements Set{
	
	ArrayList arrayList;
	
	public StringSet(){
		arrayList = new ArrayList();
	}
	
	public StringSet(String[]array){
		for(int i = 0; i < array.length; i++){
			this.arrayList.add(array[i]);
		}
	}
	
	@Override
	public void add(String value) {
		
		if(!contains(value)){
			arrayList.add(value);
		}
		
	}

	@Override
	public boolean contains(String value) {
		
		for(int i = 0; i < arrayList.size(); i++){
			
			if(arrayList.get(i).equals(value)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void remove(String value) {
		int i = 0;
		for( ; i < arrayList.size(); i++){
		
			if(arrayList.get(i).equals(value)){
				arrayList.delete(i);
				break;
			}
		}
	}

	@Override
	public void clear() {
		arrayList.clear();
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	@Override
	public boolean isEmpty() {
		return arrayList.isEmpty();
	}
	
	public void printAllElements(){
		for(int i=0; i < arrayList.size(); i++){
			System.out.print(arrayList.get(i).toString()+" ");
		}
	}

	
}
