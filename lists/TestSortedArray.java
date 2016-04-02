package lists;

public class TestSortedArray {
	public static void main(String[]args){
		Car a = new Car(1999,100,4);
		Car b = new Car(1939,130,4);
		Car c = new Car(1989,120,4);
		Car d = new Car(1979,140,4);
		Car e = new Car(1969,160,4);
		
		SortedArrayList sat = new SortedArrayList(new CarComparatorYear());
		
		
		sat.add(a);
		sat.add(b);
		sat.add(c);
		sat.add(d);
		sat.add(e);
		
		sat.printAll();
	}
}
