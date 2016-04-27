package searching;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {

	public static void main(String[]args){
		
		int[]array = new int[100];
		fillArray(array, 100);
		
		Random r = new Random();
		int value = r.nextInt(100);
		
		int valueIndex = BinarySearch.searchBinary(0, array.length, value, array);
		
		System.out.println(Arrays.toString(array));
		
		System.out.println("Value " + value + " founded at index: " + valueIndex);
		
	}
	
	private static void fillArray(int[]array, int maxValue){
		
		Random r = new Random();
		
		for(int i = 0; i < array.length; i++){
			
			array[i] = r.nextInt(maxValue);
	
		}
	}
}
