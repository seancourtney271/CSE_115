package code.comparators;
import java.util.Comparator;
import code.Utilities;
import code.ratables.Ratable;

public class AverageRatingComparator implements Comparator<Ratable>{
	@Override
	public int compare(Ratable one, Ratable two) {
		double avg1 = Utilities.averageRatingOfReviews(one.getReviews());
		double avg2 = Utilities.averageRatingOfReviews(two.getReviews());
		return (int) ((int) 100*(avg2 - avg1));
		
	}
}
