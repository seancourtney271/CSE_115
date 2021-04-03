package code.comparators;
import java.util.Comparator;

import code.Utilities;
import code.ratables.Ratable;

public class BayesianAverageComparator implements Comparator<Ratable>{
private int numberOfExtraRatings = 0;
private double extraRatingValue = 0;
public BayesianAverageComparator(int a, double b) {
	super();
	numberOfExtraRatings = a;
	extraRatingValue = b;
}
@Override
public int compare(Ratable o1, Ratable o2) {
	double avg1 = Utilities.bayesianAverageOfReviews(o1.getReviews(), numberOfExtraRatings, extraRatingValue);
	double avg2 = Utilities.bayesianAverageOfReviews(o2.getReviews(), numberOfExtraRatings, extraRatingValue);
	return (int) ((int) 100*(avg2 - avg1));
}

}
