package lists;
import java.util.Comparator;
public class CarComparator implements Comparator<Car>{

	@Override
	public int compare(Car arg1, Car arg2) {
		return Integer.compare(arg1.getProductionYear(), arg2.getProductionYear());
	}
	
}
