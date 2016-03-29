package queues;

public class EmptyQueueException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyQueueException(){}
	
	public EmptyQueueException(String message){
		super(message);
	}
	
	
}
