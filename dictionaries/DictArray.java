package dictionaries;

import java.util.Comparator;

import iterators.Iterator;
import iterators.KeyValueIterator;
import lists.SortedArrayList;

public class DictArray implements Map{
	
	private SortedArrayList array;
	private Comparator<?> KeyComparator = new KeyComparator();
	
	public DictArray(){
		this.array = new SortedArrayList(KeyComparator);
	}
	
	@Override
	public int get(String key) throws NoSuchKeyException {
		
		for(int i = 0; i < array.size(); i++){
			
			if(((Key)array.get(i)).getName().equals(key)){
				return ((Key)array.get(i)).getValue();
			}
		}
		throw new NoSuchKeyException("There is no key with specified name.");
	}

	@Override
	public void put(String key, int value) {
		if(!containsKey(key)){
			array.add(new Key(key,value));
		}
		else{
			try{
			remove(key);
			put(key , value);
			}
			catch(NoSuchKeyException e){
				e.printStackTrace();
			}
		}
	}
	
	public void put(Key key){
		if(!containsKey(key.getName())){
			array.add(key);
		}
		else{
			try{
			remove(key.getName());
			put(key);
			}
			catch(NoSuchKeyException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean containsKey(String key) {
		
		for(int i = 0; i < array.size(); i++){
			
			if(((Key)array.get(i)).getName().equals(key)){
				return true;
			}
			
		}
		return false;
		
	}

	@Override
	public int remove(String key) throws NoSuchKeyException{
		
		for(int i = 0; i < array.size(); i++){
			
			if(((Key)array.get(i)).getName().equals(key)){
				int deletedValue = ((Key)array.get(i)).getValue();
				array.delete(i);
				return deletedValue;
			}
		}
		throw new NoSuchKeyException("There is no key with specified name.");
	}

	@Override
	public void clear() {
		array.clear();
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	public Iterator keyIterator(){
		return array.iterator();
	}
	
	public Iterator valueIterator(){
		return new KeyValueIterator(array.getSourceArray());
	}
	
}
