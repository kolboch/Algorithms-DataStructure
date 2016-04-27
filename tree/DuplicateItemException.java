package tree;

public class DuplicateItemException extends Exception {

	private static final long serialVersionUID = 145687L;

	public DuplicateItemException(){
		super();
	}
	
	public DuplicateItemException(String message){
		super(message);
	}
}
