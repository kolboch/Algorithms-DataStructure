package iterators;

public class ReverseIterator implements Iterable{

	private final Iterable _it;
	
	public ReverseIterator(Iterable _it){
		
		this._it = _it;
		
	}

	
	public Object current(){
		
		return _it.current();
		
	}
	
	public void first(){
		
		_it.last();
		
	}
	
	public void last(){
		
		_it.first();
		
	}
	
	public void next(){
		
		_it.previous();

	}
	
	public void previous(){
		
		_it.next();
		
	}
	
	public boolean isDone(){
		
		return _it.getCurrent() > _it.getFirst() || _it.getCurrent() < _it.getLast() ; 
		
	}

	@Override
	public int getCurrent() {
		return _it.getCurrent();
	}


	@Override
	public int getFirst() {
		return _it.getFirst();
	}


	@Override
	public int getLast() {
		return _it.getLast();
	}
	
}
