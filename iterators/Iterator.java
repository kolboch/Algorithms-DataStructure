package iterators;

public class Iterator implements Iterable{
	
	private final int first;
	private final int last;
	private int current;
	private Object[] array;
	

	
	
	public Iterator(Object[]array){
		this.array = array;
		this.first = 0;
		this.last = array.length-1;
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
		if(current + 1 < this.array.length - 1)
			current++;
		else
			throw new IndexOutOfBoundsException("Index spoza zakresu.");
		
	}

	@Override
	public void previous() throws IndexOutOfBoundsException{
		if(current-1 > 0 )
			current--;
		else
			throw new IndexOutOfBoundsException("Index spoza zakresu.");
		
	}

	@Override
	public Object current() {
		
			return array[current];
		
			
	}

	@Override
	public boolean isDone() {
		
		if(current == this.array.length - 1)
			return true;
		else 
			return false;
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
