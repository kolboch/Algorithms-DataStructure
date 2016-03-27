package lists;

public class Element {
	
	private Object value;
	private Element next;
	
	public Element(Object value){
		setValue(value);
	}
	
	public Object getValue(){
		return value;
	}
	public void setValue(Object value){
		this.value = value;
	}
	
	public Element getNext(){
		
		return next;
	}
	
	public void setNext(Element next)throws NullPointerException{
		if(next == null)
			throw new NullPointerException("Can't set null as next element.");
		this.next= next;
	}
	
	
	
}	
