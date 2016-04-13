package sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringSetTest {
	
	public static void main(String[]args){
		Scanner sc = null;
		StringSet set = new StringSet();
		
		try{
			
			sc = new Scanner(new File("C:\\Users\\Karol\\Desktop\\SetTest.txt"));
			while(sc.hasNext()){
				set.add(sc.next());
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		finally{
			sc.close();
		}
		
		set.printAllElements();
		
	}
}
