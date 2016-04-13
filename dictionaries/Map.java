package dictionaries;

public interface Map {
	
	int get(String key) throws NoSuchKeyException;
	
	void put(String key, int value);
	
	boolean containsKey(String key);
	
	int remove(String key) throws NoSuchKeyException;
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
}
