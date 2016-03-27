package iterators;

public interface Iterable {
	
	public void first();
	
	public void last();
	
	public void next();
	
	public void previous();
	
	public Object current();
	
	public boolean isDone();
	
	public int getCurrent();
	
	public int getFirst();
	
	public int getLast();
	
	
	
}
