package dictionaries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import iterators.Iterator;

public class DictIteratorTest {
	
	public static void main(String[]args){
		
		DictArray dici = new DictArray();
		Scanner sc = null;
		try{
			sc = new Scanner(new File("C:\\Users\\Karol\\Desktop\\Keys.txt"));
				
				while(sc.hasNext()){
					String name = sc.next();
					int value = sc.nextInt();
					dici.put(name, value);
				}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		finally{
			sc.close();
		}
		
		System.out.println("Iterowanie po kluczach:");
		
		Iterator it = dici.keyIterator();
		
		while(it.current() != null && it.hasNext()){
			System.out.print(it.current().toString());
			it.next();
		}
		
		System.out.println("\nIterowanie po wartosciach:");
		
		Iterator it2 = dici.valueIterator();
		
		for(it2.current(); it2.current() != null && it2.hasNext(); it2.next()){
			System.out.println(it2.current());
		}
		
	}
}
