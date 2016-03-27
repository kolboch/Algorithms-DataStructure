package lists;

public class ArrayListVSLinkedList {
	public static void main(String[]args){
		CarFactory cf=null;
		try{
		cf = new CarFactory(2000,1990,500,100,4,3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LinkedList ll = new LinkedList();
		ArrayList ar = new ArrayList();
		
		Car[] carArray = cf.produceCars();
		
		long startTime = System.nanoTime();
		
		for(Car c : carArray){
			ar.add(c);
		}
		
		long stopTime = System.nanoTime();
		System.out.printf("Adding 3000 cars to arraylist took:%8d%n" , (stopTime - startTime));
		
		
		startTime = System.nanoTime();
		for(Car c : carArray){
			ll.add(c);
		}
		
		stopTime = System.nanoTime();
		System.out.printf("Adding 3000 cars to linkedlist took:%8d%n" , (stopTime - startTime));
	}
}
