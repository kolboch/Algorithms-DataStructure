package RPN;

import java.io.FileNotFoundException;

import RPN.ReversePolishNationCalculator.WrongPhraseException;

public class TestRPN {
	public static void main(String[]args){
		
		ReversePolishNationCalculator calc = new ReversePolishNationCalculator();
		
		try{
			calc.loadPhraseFromFile("D:\\javaeclipseprog\\Algorytmy i struktury danych\\src\\RPN\\test.txt");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		System.out.println(calc.getInputPhrase());
		try{
		double result = calc.calculate();
		System.out.println(result);
		}
		catch(WrongPhraseException e){
			e.printStackTrace();
		}
	}
}
