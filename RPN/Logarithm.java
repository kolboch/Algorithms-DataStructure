package RPN;

public class Logarithm {
	public static double logBase(double a, double base)throws ArithmeticException{
		if(base == 1){
			throw new ArithmeticException("Wrong algorithm base.");
		}
		
		return Math.log(a) / Math.log(base);
		
	}
}
