package iterators;

public class ArrayIterator implements Iterable {
	
	private final int _first;
	private final int _last;
	private int _current;
	private Object[] _array;
	
	public ArrayIterator(Object[]_array, int start , int length){
		
		this._array = _array;
		this._first = start;
		this._last = start + length -1;
		_current = -1;
		
	}
	
	@Override
	public void first() {
		_current = _first;
		
	}

	@Override
	public void last() {
		_current = _last;
		
	}

	@Override
	public void next() {
		_current++;
		
	}

	@Override
	public void previous() {
		_current--;
		
	}

	@Override
	public Object current() {
		
		return _array[_current];
	}

	@Override
	public boolean isDone() {
		return _current > _last || _current < _first;
	}

	@Override
	public int getCurrent() {
		return _current;
	}

	@Override
	public int getFirst() {
		return _first;
	}
	@Override
	public int getLast() {
		return _last;
	}
	
}
