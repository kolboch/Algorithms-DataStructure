package queues;

public interface Queue {
	
	void enqueue(Object value);
	
	Object dequeue() throws EmptyQueueException;
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
}
