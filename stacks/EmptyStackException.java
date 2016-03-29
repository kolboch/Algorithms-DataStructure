package stacks;

public class EmptyStackException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyStackException(){}
	public EmptyStackException(String message){
		super(message);
	}
}
