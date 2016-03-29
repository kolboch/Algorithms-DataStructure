package queues;

public class FullQueueException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FullQueueException(){}
	public FullQueueException(String message){
		super(message);
	}
}
