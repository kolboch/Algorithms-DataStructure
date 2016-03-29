package stacks;

import lists.Car;

public class StackSinkingTest {
	public static void main(String[]args){
		StackSinking stack = new StackSinking(4);
		
		Car c1 = new Car(1910,101,1);
		Car c2 = new Car(1920,102,2);
		Car c3 = new Car(1930,103,3);
		Car c4 = new Car(1940,104,4);
		Car c5 = new Car(1950,105,5);
		
		stack.push(c1);
		stack.push(c2);
		stack.push(c3);
		stack.push(c4);
		stack.push(c5);
		
		while(!stack.isEmpty()){
			System.out.print(stack.peek().toString());
			System.out.print(stack.pop().toString());
		}
		// stack.pop();
	}
}
