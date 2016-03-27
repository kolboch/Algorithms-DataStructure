package lists;

import java.util.Comparator;

public class CyclicLinkedList implements List {
	
	private Comparator comp;
	private Element first = new Element(null);
	private int size;
	private Element current;
	
	public CyclicLinkedList(Comparator<?> comp){
		this.comp = comp;
		clear();
	}
	
	@Override
	public void add(Object value)throws NullPointerException {
		
		if(value==null)
			throw new NullPointerException("Cannot add null object");
		
		if(first.getValue() == null){
			first.setValue(value);
			first.setNext(first);
		}
		else{
			
			Element e = new Element(value);
			
			
			while(comp.compare(e.getValue(),current.getNext().getValue()) >= 0 && current.getNext().getValue() != first.getValue())
				next();
			
			
			e.setNext(current.getNext());
			current.setNext(e);
			
			
		}
		size++;
	}

	@Override
	public void delete(int index) {
		isIndexValid(index);
		
		first();
		
		if(index ==0)
			first = current.getNext();
		else{
			for(int i=0; i<index-1 ; i++)
				next();
				current.setNext(current.getNext().getNext());
		}
		
		
		size--;
		
	}
	
	private boolean isIndexValid(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("Index out of borders");
		}
		else return true;
	}
	@Override
	public Object get(int index) {
		isIndexValid(index);
		first();
		for(int i=0; i<index ; i++){
			next();
		}
	
		return getCurrent();
	}

	@Override
	public void set(int index, Object value) {
		isIndexValid(index);
		
	}
	private Object getCurrent(){
		return current.getValue();
	}

	@Override
	public boolean isEmpty() {
		return !(size() > 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		first.setValue(null);
		current= first;
	}

	@Override
	public boolean contains(Object value) {
		return getIndexOf(value) != -1;
	}
	
	public Object current(){
		return current.getValue();
	}
	public void next(){
		current = current.getNext();
	}
	public void first(){
		current = first;
	}
	
	
	@Override
	public int getIndexOf(Object value) {
		int index =0;
		
		first();
		while(current.getNext().getValue()!= first.getValue()){
			if(current.getValue().equals(value))
				return index;
			index++;
		}
		return -1;
	}
	
	public void printAll(){
		if(!isEmpty()){
			first();
			
		while(current.getNext().getValue() != first.getValue()){
			System.out.print(current.getValue().toString());
			next();
		}
		System.out.print(current.getValue().toString());
		}
			
	}
	

}
