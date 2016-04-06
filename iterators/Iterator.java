package iterators;

public class Iterator implements Iterable{
	
	private final int first;
	private final int last;
	private int current;
	private Object[] array;
	

	
	public Iterator(Object[]array, int size){
		this.array = array;
		this.first = 0;
		this.last = size;
		this.current = 0;
	}
	
	public Iterator(Object[]array){
		this.array = array;
		this.first = 0;
		this.last = array.length;
		this.current =0;
	}
	
	
	@Override
	public void first() {
		this.current = 0;
		
	}

	@Override
	public void last() {
		this.current = this.array.length -1 ;
		
	}

	@Override
	public void next() throws IndexOutOfBoundsException{
		current++;
	}

	@Override
	public void previous() throws IndexOutOfBoundsException{
		if(current-1 > 0 )
			current--;
		else
			throw new IndexOutOfBoundsException("Index spoza zakresu.");
		
	}

	@Override
	public Object current() throws IndexOutOfBoundsException {
		if(current > array.length)
			throw new IndexOutOfBoundsException("Index out of bounds");
		else
			return array[current];
		
			
	}

	@Override
	public boolean isDone() {
		
		if(current < last)
			return false;
		else 
			return true;
	}

	@Override
	public int getCurrent() {
		return current;
	}

	@Override
	public int getFirst() {
		return first;
	}

	@Override
	public int getLast() {
		return last;
	}
	
	public void iterator(){
		current = 0;
	}
	
	
}
