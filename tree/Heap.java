package tree;

import java.util.Comparator;
import java.util.NoSuchElementException;

import lists.ArrayList;

public class Heap {
	
	private ArrayList array; 
	private final Comparator comparator;
	
	public Heap(Comparator comparator){
		this.comparator = comparator;
		array = new ArrayList();
	}
	
	private void siftUp(){
		
		int k = array.size() - 1;
		while(k > 0){
			
			int p = (k-1)/2;
			
			Object item = array.get(k);
			Object parent = array.get(p);
			
			if(comparator.compare(item, parent)> 0){
				array.swap(k, p);
				k = p;
			}
			else{
				break;
			}
		}
	}
	
	private void siftDown(){
		int k = 0;
		int l = 2*k+1;
		
		while(l < array.size()){
			int max = l;
			int r = l+1;
			
			if(r < array.size()){ //checking if r is right index, if so it is right child
				if(comparator.compare(array.get(r), array.get(l)) > 0){
					max++;
				}
			}
			if(comparator.compare(array.get(k), array.get(max)) < 0){
				
				array.swap(max, k);
				k = max;
				l = 2*k+1;
			}
			else{
				break;
			}
		}
	}
	
	public void insert(Object obj){
		array.add(obj);
		siftUp();
	}
	
	public Object delete() throws NoSuchElementException{
		if(array.size() == 0){
			throw new NoSuchElementException("There is no element to delete.");
		}
		if(array.size() == 1){
			Object temp = array.get(0);
			array.delete(0);
			return temp;
		}
		Object hold = array.get(0);
		Object value = array.get(array.size()-1);
		array.set(0, value);
		array.delete(array.size()-1);
		siftDown();
		
		return hold;
	}
	
	public int size(){
		return array.size();
	}
	public boolean isEmpty(){
		return array.isEmpty();
	}
	public void printAll(){
		array.printAll();
	}
}
