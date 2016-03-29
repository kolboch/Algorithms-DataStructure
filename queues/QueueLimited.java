package queues;

import lists.LinkedList;

public class QueueLimited implements Queue{
  
  private LinkedList linkedList;
  private int size;

  public QueueLimited(int size){
		this.size = size;
		this.linkedList = new LinkedList();
  }
	
  public QueueLimited(){
		this(10);
  }
	
  @Override
  public void enqueue(Object value) throws FullQueueException{
	  if(linkedList.size() < this.size){
		  linkedList.add(value);
	  }
	  else{
		  throw new FullQueueException("Queue is full, cannot enqueue more elements.");
	  }
  }

  @Override
  public Object dequeue() throws EmptyQueueException {
	if(linkedList.size() > 0){
		Object temp = linkedList.get(size()-1);
		linkedList.delete(size()-1);
		return temp;
	}
	else{
		throw new EmptyQueueException("Queue is empty, cannot use dequeue now.");
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
	  return this.size;
  }

}
