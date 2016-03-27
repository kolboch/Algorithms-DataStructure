package lists;

public interface List {
	
	void add(Object value);
	
	void delete(int index);
	
	Object get(int index);
	
	void set(int index, Object value);
	
	boolean isEmpty();
	
	int size();
	
	void clear();
	
	boolean contains(Object value);
	
	int getIndexOf(Object value);
	
	
}
