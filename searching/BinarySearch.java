package searching;

import java.util.Arrays;

public class BinarySearch {
	
	public static int searchBinary(int from, int to, int value, int[]array){
		//tests
		int counter = 0;
		
		Arrays.sort(array);
		
		int bound;
		
		while(from < to){
			
			bound = nextBound(from, to);
			
			if(array[bound] == value){
				//test
				System.out.println("Steps: " + counter);
				return bound;
			}
			else if( array[bound] > value){
				to = bound;
			}
			else{
				from = bound + 1;
			}
			//test
			counter++ ;
		}
		//test
		System.out.println("Steps: " + counter);
		
		return -1;
		
	}
	
	private static int nextBound(int start, int end){
		
		return start/2 + end/2; 
		
	}
}
