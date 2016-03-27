/*
 * author Karol Bochynski
 * iterator generating numbers which are lessThan given value and divible by divisor1 and divisor2
 */
package iteratorsLab;

public class IteratorDiv implements Iterator {
	
	private int first; //first number generated by given parameters
	private int last; //last number generated by given parameters
	private int current=0; //current number
	private int currentIndex; //current indexOfgeneratedElement
	private int lessThan;
	private int divisor1;
	private int divisor2;
	
	public IteratorDiv(int lessThan, int divisor1, int divisor2) throws IllegalArgumentException{
		
		if(divisor1 != 0)
			this.divisor1 = divisor1;
		else
			throw new IllegalArgumentException("Cannot put 0 as a divisor.");
		
		if(divisor2 != 0)
			this.divisor2 = divisor2;
		else
			throw new IllegalArgumentException("Cannot put 0 as a divisor.");
		
		if(lessThan>0)
			this.lessThan = lessThan;
		else
			throw new IllegalArgumentException("First number must be greater than 0.");
		
		if(lessThan <= divisor1 || lessThan <= divisor2)
			throw new IllegalArgumentException("Wrong argument, for divisor greater or equal lessThan iterator wouldn't generate any numbers.");
		
		if(divisor1%divisor2 != 0 && divisor2%divisor1 != 0)
			if(!hasNext())
				throw new IllegalArgumentException("There is no number passing these parameters.");
		
		
		last();
		first();
		
		
		
		
		
	}
	@Override //changes current and index to next correct number
	public void next() throws IndexOutOfBoundsException{
		if(hasNext()){
			current++;
			while(current%divisor1!=0 || current%divisor2!=0 ){
				current++; // nww ( najmniejsza wspolna wielokrotnosc)
			}
			currentIndex++;
		
		}
		else
			throw new IndexOutOfBoundsException("Reached last number, can't use next.");
	}

	@Override //changes current and index to previous proper number
	public void previous() throws IndexOutOfBoundsException{
		if(hasPrevious()){
			current--;
			while(current%divisor1!=0 || current%divisor2!=0){
				current--;
			}
			currentIndex--;
			
		}
		else
			throw new IndexOutOfBoundsException("Reached first number, can't use previous.");
	}

	@Override 
	public void first() { //sets currentIndex to 0 and current to first correct number
		if(divisor1 % divisor2 == 0){
			current = divisor1;
			first = current;
			currentIndex=0;
		}
		else if(divisor2 % divisor1 == 0){
				current = divisor2;
				first = current;
				currentIndex=0;
		}
		else for(int i= divisor1 > divisor2 ? divisor1 : divisor2 ; i < lessThan ; i++ )
			if(i%divisor1==0 && i%divisor2 ==0){
					first = i;
					current = i;
					currentIndex = 0;
					break;
			}
					
		
	}

	@Override //sets current to last correct number and currentIndex to last relevant
	public void last() {
		int i = first;
		int index =0;
		while(i < lessThan){
			if(i%divisor1==0 && i%divisor2 == 0){
				last = i;
				
				currentIndex = index++;
			}
		i++;
		}
		current = last;
		
	}

	@Override 
	public boolean hasNext() {
		
		int next = current+1;
		while(next < lessThan){
			if(next%divisor1==0 && next%divisor2==0){
				
				return true;
				
			}
			next++;
		}
		return false;
		
	}

	@Override
	public boolean hasPrevious() {
		int previous = current-1;
		
		while(previous >= first){
			
			if(previous%divisor1==0 && previous%divisor2 == 0){
				return true;
			}
			
			previous--;
		}
		
		return false;
	}

	@Override
	public Object current() {
		return current;
	}
	public void setCurrent(int i){
		this.current = i;
	}
	public void setCurrentIndex(int i){
		this.currentIndex = i;
	}
	public int getCurrentIndex(){
		return currentIndex;
	}
	public void setFirst(int i){
		first = i;
	}
	public void setLast(int i){
		last = i;
	}
	public int getLast(){
		return last;
	}
	public int getFirst(){
		return first;
	}
	public int getLessThan(){
		return lessThan;
	}
	public int getDivisor1(){
		return divisor1;
	}
	public int getDivisor2(){
		return divisor2;
	}
	
	
}