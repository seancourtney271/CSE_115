package code.comparators;
import java.util.Comparator;

import code.ratables.Ratable;

public class NumberOfReviewsComparator implements Comparator<Ratable> {
	@Override 
	public int compare(Ratable o1, Ratable o2){
		int comp1 = o1.getReviews().size();
		int comp2 = o2.getReviews().size();
		int comp3 = comp2 - comp1;
		return comp3;
    }
//	public ArrayList<Ratable> sortByNumberOfReviews (ArrayList <Ratable> a){
//		HashMap<String, Ratable> hash = new HashMap <String, Ratable>();
//		(int i = 0; i < a.size(); i++) {
//			if(!(i+1 > a.size())) {
//				Ratable one = a.get(i);
//				Ratable two = a.get(i+1);
//				int rat = compare(one,two);
//				if(rat > 0) {
//				}
//				}
//				
//			}
//		}
		
	}

