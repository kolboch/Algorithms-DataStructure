package iteratorsLab;

public class EvenIterator extends IteratorDiv implements Iterator {
	
	
	
	public EvenIterator(IteratorDiv a) throws IllegalArgumentException{
		super(a.getLessThan(), a.getDivisor1(), a.getDivisor2());
		if(this.getFirst()%2 != 0)
			if(!hasNext()){
				throw new IllegalArgumentException("No even numbers for passed iterator");
				
			}
			else{
				next();
				setFirst((int)current());
				setCurrentIndex(0);
			}
	}
	
	public boolean hasPrevious() {
		int previous = (int)current()-1;
		
		while(previous >= getFirst()){
			
			if(previous%getDivisor1()==0 && previous%getDivisor2() == 0 && previous%2 ==0){
				return true;
			}
			
			previous--;
		}
		
		return false;
	}

	public void last(){
		int i = getFirst();
		int index =0;
		while(i < getLessThan()){
			if(i%getDivisor1() == 0 && i%getDivisor2() == 0 && i%2==0){
				setLast(i);
				
				setCurrentIndex(index++);
			}
		i++;
		}
		setCurrent(getLast());
		
	}
	
	public void first(){
		if(getDivisor1() % getDivisor2() == 0 && getDivisor1()%2==0){
			setCurrent(getDivisor1());
			setFirst((int)current());
			setCurrentIndex(0);
		}
		else if(getDivisor2() % getDivisor1() == 0 && getDivisor2()%2==0){
			setCurrent(getDivisor1());
			setFirst((int)current());
			setCurrentIndex(0);
		}
		else for(int i= getDivisor1() > getDivisor2() ? getDivisor1() : getDivisor2() ; i < getLessThan() ; i++ )
			if(i%getDivisor1()==0 && i%getDivisor2() ==0 && i%2==0){
					setFirst(i);
					setCurrent(i);
					setCurrentIndex(0);
					break;
			}
			
	}
	
	public boolean hasNext(){
		int next = (int)this.current()+1;
		while(next < this.getLessThan()){
			if(next%this.getDivisor1()==0 && next%this.getDivisor2()==0 && next%2==0){
				
				return true;
				
			}
			next++;
		}
		return false;
		
	}
	
	public void next()throws IndexOutOfBoundsException{
		if(hasNext()){
			this.setCurrent((int)current() + 1);
			while((int)this.current()%this.getDivisor1()!=0 || (int)this.current()%this.getDivisor2()!=0 || (int)this.current()%2 !=0){
				this.setCurrent((int)current() + 1);
			}
			this.setCurrentIndex(getCurrentIndex()+1);
		
		}
		else
			throw new IndexOutOfBoundsException("Reached last number, can't use next.");
	}
	
	public void previous() throws IndexOutOfBoundsException{
		if(hasPrevious()){
			setCurrent((int)current() -1 );
			
			while((int)this.current()%this.getDivisor1()!=0 || (int)this.current()%this.getDivisor2()!=0 || (int)this.current()%2 !=0){
				setCurrent((int)current() -1 );
			}
			setCurrentIndex(getCurrentIndex()-1);
			
		}
		else
			throw new IndexOutOfBoundsException("Reached first number, can't use previous.");
	}
	
	public Object current(){
		return EvenIterator.super.current();
	}
	
	public int getLessThan(){
		return EvenIterator.super.getLessThan();
	}
	
	public int getDivisor1(){
		return EvenIterator.super.getDivisor1();
	}
	public int getDivisor2(){
		return EvenIterator.super.getDivisor2();
	}
	
	
	
}
