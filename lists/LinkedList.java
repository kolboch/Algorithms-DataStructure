package lists;

public class LinkedList implements List {
	
	private int size;
	private final Element sentinel =new Element(null);
	private Element first;
	private Element current;
	
	public LinkedList(){
		clear();
	}
	
	public LinkedList(Object[]array){
		for(Object obj : array){
			add(obj);
		}
	}
	
	
	
	
	public void add(Object value) throws NullPointerException{
		if(value== null){
			throw new NullPointerException("Can't add null to LinkedList.");
		}
		Element e = new Element(value);
		if(size()==0){
			e.setNext(sentinel);
			first = e;
		}
		else{
			e.setNext(first);
			first = e;
		}
		
		size++;
			
		
	}
	public void first(){
		current = first;
	}
	
	public void delete(Object value){
		int indexToDelete = getIndexOf(value);
		delete(indexToDelete);
	}
	public void delete(int index){
		isIndexValid(index);
		first();
		
		if(index == 0){
			first = current.getNext();
		}
		else{
			for(int i=0; i<index-1 ; i++)
			next();
			current.setNext(current.getNext().getNext());
		}
		size--;
	}
	
	public void next(){
		current = current.getNext();
	}
	
	private boolean isIndexValid(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("Index out of borders");
		}
		else return true;
	}
	
	public Object get(int index) {
		
		isIndexValid(index);
		first();
			for(int i=0; i<index ; i++){
				next();
			}
		
		return getCurrent();
		
	}
	
	private Object getCurrent(){
		return current.getValue();
	}
	
	public void set(int index, Object value) throws NullPointerException {
		if(value==null)
			throw new NullPointerException ("can't set element to null");
		
		isIndexValid(index);
		first();
		Element e = new Element(value);
		for(int i=0; i<index-1 ; i++){
			next();
		}
		Element next = current.getNext();
		current.setNext(e);
		e.setNext(next);
		
		
	}

	
	public boolean isEmpty() {
		return size() == 0;
	}

	
	public int size() {
		return size;
	}

	
	public void clear() {
		size = 0;
		first = sentinel;
		current = first;
	}

	
	public boolean contains(Object value) {
		return getIndexOf(value) != -1;
	}

	
	public int getIndexOf(Object value) {
		int index = 0;
		if(!isEmpty()){
		first();
		while(current != sentinel){
			if(getCurrent().equals(value))
				return index;
			else{
				index++;
				next();
			}
		}
		}
		return -1;
	}

	public void printAll(){
		
		if(!isEmpty()){
			first();
			while(current.getNext()!=sentinel){
				System.out.print(getCurrent().toString());
				next();
			}
			System.out.print(getCurrent().toString());
		}
	}
	
	
	
}
