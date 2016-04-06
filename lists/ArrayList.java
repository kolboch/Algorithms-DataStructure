package lists;

import iterators.ArrayIterator;
import iterators.Iterator;

public class ArrayList implements List{
	
	private Object[]array;
	private int size;
	private int currentIndex;
	
	public ArrayList(){
		array = new Object[10];
		this.size=0;
		currentIndex = 0;
	}
	public ArrayList(List list){
		this();
		ensureCapacity(list.size());
		for(int i = 0; i < list.size(); i++){
			add(list.get(i));
		}
	}
	public ArrayList(Object[]array){
		int a = array.length;
		this.array = new Object[a + (int)(a*0.5)];
		for(int i=0; i<array.length ; i++){
			this.array[i] = array[i];
		}
		size = array.length;
		this.currentIndex = 0;
	}
	
	public int getCapacity(){
		return array.length;
	}
	public void ensureCapacity(int capacity){
		if(array.length < capacity){
			Object[]array2 = new Object[capacity];
			for(int i=0; i< size(); i++)
				array2[i] = array[i];
			
			array=array2;
		}
	}
		
	
	protected void reSize(){
		int a = array.length;
		Object[]copyArray = new Object[a+(int)(a*0.5)];
		for(int i=0; i<array.length ; i++){
			copyArray[i] = array[i];
		}
		array = copyArray;
	}
	@Override
	public void add(Object value) throws NullPointerException {
		if(value == null)
			throw new NullPointerException("Cannot add null Object");
		if(isFull())
			reSize();
		
		array[size] = value;
		size++;
	}
	private boolean isIndexValid(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > size()-1)
				throw new IndexOutOfBoundsException("Index out of border");
		else 
			return true;
	}
	@Override
	public void delete(int index) {
		if(index == size() - 1){
			size--;
		}
		else if(isIndexValid(index)){
			for(int i = index ; i < size() ; i++) // test it 
				array[i] = array[i+1];
			
			size--;
		}
	}
	@Override
	public Object get(int index) {
		if(isIndexValid(index))
			return array[index];
		else 
			return null;
	}
	protected void increaseSize(){
		size++;
	}
	@Override
	public void set(int index, Object value) {
		if(isIndexValid(index)){
			array[index] = value;
		}
	}
	protected boolean isFull(){
		return size()+1  > array.length;
	}
	@Override
	public boolean isEmpty() {
		return size() > 0;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void clear() {
		size = 0;
		array = new Object[10];
	}
	@Override
	public boolean contains(Object value) {
		for(int i=0; i<size(); i++){
			if(value.equals(array[i])){
				return true;
			}
		}
		return false;
	}
	@Override
	public int getIndexOf(Object value) {
		for(int i=0 ; i<size(); i++){
			if(value.equals(array[i]))
				return i;
		}
		return -1;
	}
	
	public void printAll(){
		for(int i=0; i<size(); i++){
			System.out.print(array[i].toString());
		}
	}
	
	public void swap(int index1, int index2) throws IndexOutOfBoundsException{
		if(isIndexValid(index1) && isIndexValid(index2)){
			Object tempValue = array[index1];
			array[index1] = array[index2];
			array[index2] = tempValue;
		}
		else{
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}
	@Override
	public Iterator iterator() {
		return new Iterator(array, size);
	}
	
}
