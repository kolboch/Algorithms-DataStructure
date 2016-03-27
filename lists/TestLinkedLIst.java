package lists;

public class TestLinkedLIst {
	
	public static void main(String[]args) throws Exception{
		
		// CarFactory cf = new CarFactory(1000,200,100,50,4,10);
		
		Car b = new Car(1999,100,3);
		Car c = new Car(2005,60,4);
		Car d = new Car(1997,120,5);
		Car a = new Car(2015,100,4);
		
		
		LinkedList l = new LinkedList();
		l.add(a);
		l.add(b);
		l.add(c);
		
		System.out.println(l.contains(c));
		System.out.println(l.contains(d));
		
		System.out.print(l.get(0));
		System.out.print(l.get(1));
		System.out.print(l.get(2));
		// System.out.print(l.get(5)); // should throw excception
		
		System.out.println(l.getIndexOf(a));
		System.out.println(l.getIndexOf(c));
		System.out.println(l.getIndexOf(d));
		
		System.out.println("Before changes:");
		l.printAll();
		System.out.println("Delete index 1:");
		l.delete(1);
		l.printAll();
		System.out.println("Delete object c:");
		l.delete(c);
		l.printAll();
		
		l.add(a);
		l.add(b);
		l.add(c);
		l.add(d);
		l.add(d);
		System.out.println("<<<>>><<<>>><<<>>>");
		System.out.println("is empty?: " +l.isEmpty());
		System.out.println("LinkedList before clean:");
		l.printAll();
		l.clear();
		System.out.println("LinkedList after clean:");
		l.printAll();
		System.out.println("is empty?: " +l.isEmpty());
		
	}
}
