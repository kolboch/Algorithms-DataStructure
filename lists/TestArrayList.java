package lists;

public class TestArrayList {
	public static void main(String[]args){
		
		Car a = new Car(1999,100,4);
		Car b = new Car(1979,160,3);
		Car c = new Car(2009,130,2);
		Car d = new Car(2016,150,4);
		Car notAdded = new Car(2015,10,4);
		ArrayList al = new ArrayList();
		al.add(a);
		al.add(b);
		al.add(c);
		al.add(d);
		
		al.printAll();
		
		System.out.println(al.contains(a));
		System.out.println(al.contains(notAdded));
		
		al.delete(0);
		al.delete(0);
		al.printAll();
		CarFactory cars = null;
		
		try{
		cars = new CarFactory(2016,2000,400,100,4,5000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Car[]arrayOfCars = cars.produceCars();
		
		for(Car carFromArray : arrayOfCars){
			al.add(carFromArray);
		}
		
		System.out.println(al.getCapacity());
		al.clear();
		System.out.println(al.getIndexOf(a));
	}
}
