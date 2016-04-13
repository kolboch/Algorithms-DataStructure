package iterators;

import dictionaries.Key;

public class KeyValueIterator extends Iterator implements Iterable{
	
	public KeyValueIterator(Object[] array) {
		super(array);
	}
	
	public Object current() throws IndexOutOfBoundsException{
		if(super.current() == null){
			return null;
		}
		if(super.getCurrent() < getLast()){
			return ((Key)super.current()).getValue();
		}
		else{
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}
	
}
