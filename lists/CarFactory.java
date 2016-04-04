package lists;

import java.util.Random;

import sortedCases.Generator;
import sortedCases.SortDefinedGenerator;
import sortedCases.SortExtent;

public class CarFactory implements Generator, SortDefinedGenerator{
	Car[]array;
	
	private int maxYear;
	private int minYear;
	private int minPower;
	private int maxPower;
	private int seets;
	private static Random rg = new Random();
	
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
	
	private int randomPower(){
		return (rg.nextInt(maxPower - minPower) + minPower);
	}
	
	public Object[] generate(){
		return produceCars();
	}

	private Car generateCarWithOrder(Car previous){
		int previousProductionYear = previous.getProductionYear();
		if(previousProductionYear + 1 < maxYear){
			previousProductionYear += 1;
		}
		Car c = new Car(previousProductionYear, randomPower() , seets );
		return c;
	}
	
	@Override
	public Object[] generate(SortExtent extent) {
		if(extent.getSortPercentage() == 0){
			return generate();
		}
		int sortedIndexSpace = 100 / extent.getSortPercentage();
		
		array[0] = randomCar();
		
		for(int i = 1; i < array.length; i++){
			if( ((i + 1) % sortedIndexSpace) == 0){
				array[i] = generateCarWithOrder(array[i-1]);
			}
			else{
				array[i] = randomCar();
			}
		}
		
		return array;
		
	}
	
	/*test of generate(SortExtent extent) and example usage
	public static void main(String[]args){
		
		CarFactory cf = new CarFactory(2016, 1900 , 500, 10 , 4, 100);
		Object[] arr = cf.generate(SortExtent.MINIMAL_SORT);
		for(Object obj : arr){
			System.out.print(obj.toString());
		}
		
	}
	*/
}
