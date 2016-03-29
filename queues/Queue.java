package queues;

public interface Queue {
	
	void enqueue(Object value) throws FullQueueException;
	
	Object dequeue() throws EmptyQueueException;
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
}
