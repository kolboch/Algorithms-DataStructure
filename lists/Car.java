package lists;

public class Car implements Comparable<Car>{
	
	private int productionYear=2016;
	private final int seets;
	private int powerKM;
	
	public Car(Car c){
		this.productionYear = c.getProductionYear();
		this.seets = c.getSeetsNumber();
		this.powerKM = c.getPowerKM();
	}
	
	public Car(int productionYear, int powerKM, int seets){
		this.productionYear = productionYear;
		this.powerKM = powerKM;
		this.seets = seets;
	}
	public String toString(){
		return String.format("%4d", productionYear);
		// return String.format("year:%6d power:%6d seets:%2d%n", productionYear, powerKM, seets);
	}
	
	public int getProductionYear(){
		return productionYear;
	}
	
	public int getSeetsNumber(){
		return seets;
	}
	
	public int getPowerKM(){
		return powerKM;
	}
	
	protected void setProductionYear(int newProductionYear){
		this.productionYear = newProductionYear;
	}
	
	public boolean equals(Car other){
		if(other == this)
			return true;
		else if(other == null)
			return false;
		else
			return getProductionYear()==other.getProductionYear() &&
						getPowerKM() == other.getPowerKM() && getSeetsNumber() == other.getSeetsNumber();
	}
	
	
	@Override
	public int compareTo(Car other) throws NullPointerException {
		return Integer.compare(this.productionYear, ((Car)other).getProductionYear());
	}
	
	
}
