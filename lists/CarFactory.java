package lists;

import java.util.Random;

public class CarFactory {
	Car[]array;
	
	private int maxYear;
	private int minYear;
	private int minPower;
	private int maxPower;
	private int seets;
	
	public CarFactory(int maxYear, int minYear, int maxPower, int minPower, int seets, int quantity)throws IllegalArgumentException{
		if(maxYear < minYear || maxPower < minPower){
			throw new IllegalArgumentException("Max can't be smaller than min value");
		}
		this.maxYear = maxYear;
		this.minYear= minYear;
		this.minPower = minPower;
		this.maxPower = maxPower;
		this.seets = seets;
		array = new Car[quantity];
	}
	

	public Car randomCar(){
		Random rg = new Random();
		int year = rg.nextInt(maxYear - minYear) + minYear;
		int power = (rg.nextInt(maxPower - minPower) + minPower);
		Car c= new Car(year,power, seets);
		return c;
	}
	
	public Car[] produceCars(){
		for(int i=0; i < array.length ; i++){
			array[i] = randomCar();
		}
	return array;
	}
}
