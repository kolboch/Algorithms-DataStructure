package stacks;

import lists.LinkedList;
import queues.EmptyQueueException;
import queues.FullQueueException;

public class StackSinking implements Stack{
	
	private int size;
	LinkedList linkedList;
	
	public StackSinking(int size){
		this.size = size;
		linkedList = new LinkedList();
	}
	
	public StackSinking(){
		this(10);
	}
	
	@Override
	public void enqueue(Object value) throws FullQueueException {
		if(linkedList.size()+1 > maxSize()){
			linkedList.delete(size()-1);
			linkedList.add(value);
		}
		else{
			linkedList.add(value);
		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if(linkedList.size() > 0){
			Object temp = linkedList.get(0);
			linkedList.delete(0);
			return temp;
		}
		else{
			throw new EmptyQueueException("The stack is empty, can't use pop now.");
		}
	}

	@Override
	public void push(Object value) {
		if(linkedList.size()+1 > maxSize()){
			linkedList.delete(size()-1);
			linkedList.add(value);
		}
		else{
			linkedList.add(value);
		}
	}

	@Override
	public Object pop() throws EmptyStackException {
		if(linkedList.size() > 0){
			Object temp = linkedList.get(0);
			linkedList.delete(0);
			return temp;
		}
		else{
			throw new EmptyStackException("The stack is empty, can't use pop now.");
		}
	}

	@Override
	public Object peek() throws EmptyStackException {
		if(linkedList.size() > 0){
			return linkedList.get(0);
		}
		else{
			throw new EmptyStackException("Stack is empty, can't use peek now.");
		}
	}

	@Override
	public void clear() {
		linkedList.clear();
	}

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	public int maxSize(){
		return size;
	}

}
