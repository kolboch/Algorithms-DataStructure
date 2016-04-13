package dictionaries;

import java.util.Comparator;

public class KeyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Key k1 = (Key)o1;
		Key k2 = (Key)o2;
		
		if(k1.getName().equals(k2.getName()))
			return 0;
		else if(k1.getName().compareTo(k2.getName()) > 0){
			return 1;
		}
		else 
			return -1;
	}

}
