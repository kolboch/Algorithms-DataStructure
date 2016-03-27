package iteratorsLab;

public class TestClass {
	public static void main(String[]args){
		IteratorDiv it1 = new IteratorDiv(100, 3 , 5);
		EvenIterator it2 = new EvenIterator(it1);
		TransformIterator it3 = new TransformIterator(it2,3);
		
		System.out.println("LessThan:" + it1.getLessThan() + " div1:"+ it1.getDivisor1() + " div2:" + it1.getDivisor2());
		System.out.println("IteratorDiv test.");
		while(it1.hasNext()){
			System.out.printf("%6d  |  %6d%n", it1.getCurrentIndex(), it1.current());
			it1.next();
		}
		System.out.printf("%6d  |  %6d%n", it1.getCurrentIndex(), it1.current());
		
		
		System.out.println("EvenIteratorTest");
		while(it2.hasNext()){
			System.out.printf("%6d  |  %6d%n", it2.getCurrentIndex(), it2.current());
			it2.next();
		}
		System.out.printf("%6d  |  %6d%n", it2.getCurrentIndex(), it2.current());
		
		
		System.out.println("TransformIterator.");
		it3.first();
		while(it3.hasNext()){
			System.out.printf("%6d  |  %6d%n", it3.getCurrentIndex(), it3.current());
			it3.next();
		}
		System.out.printf("%6d  |  %6d%n", it3.getCurrentIndex(), it3.current());
	}
}
