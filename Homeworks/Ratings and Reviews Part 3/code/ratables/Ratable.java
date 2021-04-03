package code.ratables;

import java.util.ArrayList;

import code.Review;

public abstract class Ratable{
protected ArrayList <Review> review;
protected String id;

public Ratable () { 
	review = new ArrayList <Review>();
}
public abstract String getDescription();
public abstract String getLink(); 

public String getID() {
	return this.id;
}
public ArrayList <Review> getReviews(){
	return this.review;
}
public void addRating(int rating) {
	Review a = new Review(rating);
	this.review.add(a);
}
public void addRatingWithReview(int rating, String review){
	Review a = new Review (rating,review);
	this.review.add(a);
}
    // provided since it's required by the example AlphabeticalComparator class



    // After you implement the required methods you uncomment the toString method for more descriptive output

    @Override
    public String toString(){
       return "(" + this.getLink() + ") " + this.getDescription() + " | ratings: " + this.getReviews();
    }

}
