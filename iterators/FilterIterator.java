package iterators;

public class FilterIterator implements Iterable{

	private final Iterable _it;
	
	private final Predicate _predicate;
	
	public FilterIterator(Iterable _it, Predicate _predicate){
		
		this._it = _it;
		this._predicate = _predicate;
		
	}
	
	public void filterForwards(){
		
		while(!_it.isDone() && !_predicate.accept(_it.current()))
				_it.next();
		
	}
	
	public void filterBackwards(){
		
		while(!_it.isDone() && !_predicate.accept(_it.current()))
			_it.previous();
		
	}
	
	
	public void first(){
		
		_it.first();
		filterForwards();
		
	}
	
	public void next(){
		
		_it.next();
		filterForwards();
		
	}
	
	public void last(){
		
		_it.last();
		filterBackwards();
		
	}
	
	public void previous(){
		
		_it.previous();
		filterBackwards();
		
	}

	@Override
	public Object current() {
		return _it.current();
	}

	@Override
	public boolean isDone() {
		return _it.isDone();
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
