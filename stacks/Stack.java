package stacks;

import queues.Queue;

public interface Stack extends Queue{
	
	void push(Object obj);
	
	Object pop() throws EmptyStackException;
	
	Object peek() throws EmptyStackException;
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
}
