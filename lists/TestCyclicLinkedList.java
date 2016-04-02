package lists;

public class TestCyclicLinkedList {
	
	public static void main(String[]args){
		
		CyclicLinkedList cyclic = new CyclicLinkedList(new CarComparatorYear());
		
		Car a = new Car(1899,100,3); // problem!
		Car b = new Car(2016,100,3);
		Car c = new Car(2005,100,3);
		Car d = new Car(1979,100,3);
		Car e = new Car(1992,100,3);
		Car f = new Car(2004,100,3);
		
		cyclic.add(a);
		cyclic.add(b);
		cyclic.add(c);
		cyclic.add(d);
		cyclic.add(e);
		cyclic.add(f);
		
		cyclic.printAll();
	}
	
}
