package queues;

import lists.Car;

public class TestLimitedQueue {
	public static void main(String[]args){
		QueueLimited queue = new QueueLimited(5);
		
		Car c1 = new Car(1910,101,1);
		Car c2 = new Car(1920,102,2);
		Car c3 = new Car(1930,103,3);
		Car c4 = new Car(1940,104,4);
		Car c5 = new Car(1950,105,5);
		// Car c6 = new Car(1960,106,6);
		
		try{
		queue.enqueue(c1);
		queue.enqueue(c2);
		queue.enqueue(c3);
		queue.enqueue(c4);
		queue.enqueue(c5);
		// queue.enqueue(c6);
		}
		catch(FullQueueException e){
			e.printStackTrace();
		}
		
		try{
			while(!queue.isEmpty()){
				System.out.print(queue.dequeue().toString());
			}
		}
		catch(EmptyQueueException e){
			e.printStackTrace();
		}
		
		/*
		try{
			queue.dequeue();
		}
		catch(EmptyQueueException e){
			e.printStackTrace();
		}
		*/
		
		try{
			queue.enqueue(c1);
			System.out.println(queue.isEmpty());
			queue.clear();
			System.out.println(queue.isEmpty());
		}
		catch(FullQueueException e){
			e.printStackTrace();
		}
		
	}
}
