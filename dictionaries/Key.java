package dictionaries;

public class Key {
	
	private String name;
	private int value;
	
	public Key(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public String toString(){
		return String.format("%s %d%n", name,value);
	}
}
