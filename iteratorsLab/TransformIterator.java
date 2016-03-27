package iteratorsLab;

public class TransformIterator implements Iterator{
	
	private int multiplier;
	private Iterator it;
	
	public TransformIterator(Iterator a , int multiplier){
		
		this.it = a;
		this.multiplier = multiplier;
	
	}
	
	public boolean hasNext(){
		return it.hasNext();
	}
	
	public boolean hasPrevious(){
		return it.hasPrevious();
	}
	
	public void next(){
		it.next();
	}
	public void previous(){
		it.previous();
	}
	public void first(){
		it.first();
	}
	public void last(){
		it.last();
	}
	
	public int getCurrentIndex(){
		return it.getCurrentIndex();
	}
	
	public Object current(){
		
		return  (int)it.current() * multiplier;
	}
	
	
	
	
	
	
	
}
