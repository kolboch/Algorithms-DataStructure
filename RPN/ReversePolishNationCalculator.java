package RPN;

import java.io.*;
import java.util.*;
public class ReversePolishNationCalculator {
	
	private String input;
	private Stack<Double>operands = new Stack<Double>();
	
	public double calculate() throws WrongPhraseException{
		StringTokenizer tokenizer = new StringTokenizer(input);
		
		while(tokenizer.hasMoreTokens()){
			String next = tokenizer.nextToken();
			
			if(isNumeric(next)){
				double value = Double.parseDouble(next);
				operands.add(value);
			}
			else{
				operate(next);
			}	
		}
		return operands.pop();
	}
	
	private boolean isNumeric(String str){
		try{
			Double.parseDouble(str);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	public void operate(String operator) throws WrongPhraseException{
		operator = operator.replaceAll(" ", "");
	try{
		if(operator.equals("+")){
			double a = operands.pop();
			double c = a + operands.pop();
			operands.push(c);
		}
		if(operator.equals("-")){
			double a = operands.pop();
			double c = a - operands.pop();
			operands.push(c);
		}
		if(operator.equals("/")){
			double a = operands.pop();
			double c = a / operands.pop();
			operands.push(c);
		}
		if(operator.equals("*")){
			double a = operands.pop();
			double c = a * operands.pop();
			operands.push(c);
		}
		if(operator.equals("^")){
			double b = operands.pop();
			double c = Math.pow(operands.pop(), b);
			operands.push(c);
		}
		if(operator.equals("log")){
			double base = operands.pop();
			double value = Logarithm.logBase(operands.pop(), base);
			operands.push(value);
		}
		if(operator.equals("sqrt")){
			double c = Math.sqrt(operands.pop());
			operands.push(c);
		}
		if(operator.equals("")){
			
		}
		
	}
	catch(EmptyStackException e){
		System.out.println("Wrong phrase format. Tried to pop missing value.");
	}
		
	}
	
	public void loadPhrase(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Write here your phrase in RPN to count its value: ");
		input = sc.nextLine();
	}
	
	public String getInputPhrase() throws NullPointerException{
		if(input != null){
			return input;
		}
		else{
			throw new NullPointerException("No input was given.");
		}	
	}
	
	public void loadPhraseFromFile(String pathName) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(pathName));
		input = sc.nextLine();
	}
	
	static class WrongPhraseException extends Throwable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public WrongPhraseException(){}
		public WrongPhraseException(String message){
			super(message);
		}
	}
	
	
}
