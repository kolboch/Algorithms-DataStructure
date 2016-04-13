package dictionaries;

public class NoSuchKeyException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchKeyException(){
		super();
	}
	
	public NoSuchKeyException(String message){
		super(message);
	}
}
