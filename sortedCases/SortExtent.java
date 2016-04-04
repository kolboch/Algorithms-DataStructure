package sortedCases;

public enum SortExtent {
	
	RANDOM(0),
	MINIMAL_SORT(15),
	MEDIUM_SORT(35),
	SORTED(100)	;
	
	private final int sortPercentage;
	private SortExtent(int sortPercentage){
		this.sortPercentage = sortPercentage;
	}
	
	public int getSortPercentage(){
		return sortPercentage;
	}
	
	private SortExtent(String sortExtent){
		this.sortPercentage = valueOf(sortExtent).getSortPercentage();
	}
}
