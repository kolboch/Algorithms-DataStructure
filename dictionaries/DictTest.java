package dictionaries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictTest {
	
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
	
	System.out.println("Contains pierwszy:" + dici.containsKey("pierwszy"));
	System.out.println("Is dictionary empty:" + dici.isEmpty());
		try{
			dici.remove("pierwszy");
		}
		catch(NoSuchKeyException e){
			e.printStackTrace();
		}
	
	System.out.println("after remove, contains pierwszy:" + dici.containsKey("pierwszy"));
	System.out.println("Is empty?: " + dici.isEmpty());
	dici.clear();
	System.out.println("After clear, Is empty?: " + dici.isEmpty());
	}
	
}
