package sortedCases;

public class EnumTest {
	private SortExtent t;
	public EnumTest(SortExtent t){
		this.t = t;
	}
	public int getSortExtentPerc(){
		return t.getSortPercentage();
	}
	
	public static void main(String[]args){
		
		EnumTest test = new EnumTest(SortExtent.RANDOM);
		EnumTest test1 = new EnumTest(SortExtent.MINIMAL_SORT);
		EnumTest test2 = new EnumTest(SortExtent.MEDIUM_SORT);
		EnumTest test3 = new EnumTest(SortExtent.SORTED);
		System.out.println(test.getSortExtentPerc());
		System.out.println(test1.getSortExtentPerc());
		System.out.println(test2.getSortExtentPerc());
		System.out.println(test3.getSortExtentPerc());
		
		
	}
}
