package code;

/**
 * This class contains a variety of methods that will be used throughout the Ratings and Reviews
 * project.
 */
public class Utilities{

    /**
     * Computes the average of two ratings
     *
     * @param rating0 An integer rating in the range of 1-5 inclusive
     * @param rating1 An integer rating in the range of 1-5 inclusive
     * @return the average of rating0 and rating1 as a double
     */
    public double averageRating(int rating0, int rating1){
    	double averageoftwo = (rating0 + rating1) / 2.0;
    	return averageoftwo; // Don't forget to replace this return statement with your own
    }

    /**
     * Computes the average of three ratings
     *
     * @param rating0 An integer rating in the range of 1-5 inclusive
     * @param rating1 An integer rating in the range of 1-5 inclusive
     * @param rating2 An integer rating in the range of 1-5 inclusive
     * @return the average of rating0, rating1, and rating2 as a double
     */
    public double averageRating(int rating0, int rating1, int rating2){
    	double averageofthree = (rating0 + rating1 +rating2) / 3.0;
        return averageofthree; // Don't forget to replace this return statement with your own
    }


    /**
     * Computes the number of stars for a given rating to the nearest half star. This is
     * equivalent to rounding the input to the nearest 0.5. For example, a something with
     * a rating of 3.34 would have a star rating of 3.5 stars.
     *
     * @param rating An average rating as a double in the range of 1.0-5.0 inclusive
     * @return The star rating of the input rating
     */
    public double starRating(double rating){
    	double starvalue = 0.0;
    	if (rating > 1.0 && rating < 2.0) {  
    		if(rating > 1.0 && rating < 1.25) {
    			starvalue = 1.0;
    		}
    		if(rating >= 1.25 && rating < 1.75) {
    			starvalue = 1.5;
    		}
    		if(rating >= 1.75) {
    			starvalue = 2.0;
    		}
    	    }
    	if (rating > 2.0 && rating < 3.0) {  
			if(rating > 2.0 && rating < 2.25) {
				starvalue = 2.0;
			}
			if(rating >= 2.25 && rating < 2.75) {
				starvalue = 2.5;
			}
			if(rating >2.75) {
				starvalue = 3.0;
			} 
			}
    	if (rating > 3.0 && rating < 4.0) {  
			if(rating > 3.0 && rating < 3.25) {
				starvalue = 3.0;
			}
			if(rating >= 3.25 && rating < 3.75) {
				starvalue = 3.5;
			}
			if(rating >= 3.75) {
				starvalue = 4.0;
			} 
			}
    	if (rating > 4.0 && rating < 5.0) {  
			if(rating > 4.0 && rating < 4.25) {
				starvalue = 4.0;
			}
			if(rating >= 4.25 && rating < 4.75) {
				starvalue = 4.5;
			}
			if(rating >= 4.75) {
				starvalue = 5.0;
			}
			}
    	
    	if (rating == 5.0) { starvalue = 5.0;  }
        return starvalue; // Don't forget to replace this return statement with your own
    }


    /**
     * Updates an average rating after a new rating is made.
     *
     * @param average         The current average rating
     * @param numberOfRatings The number of ratings contributing to the current average rating
     * @param newRating       The value of the new rating as a double in the range of 1.0-5.0 inclusive
     * @return The new average rating after the new rating has been applied
     */
    public double updateAverage(double average, int numberOfRatings, double newRatingValue){
    	double updatedAverage = average;
    	updatedAverage = ((average * numberOfRatings) + (newRatingValue))/(numberOfRatings + 1.0);
        return updatedAverage; // Don't forget to replace this return statement with your own
    }


    /**
     * Computes the Bayesian average for the given inputs. The Bayesian average is computed
     * by adding a fixed number of extra ratings at a certain value to the current rating.
     * 
     * Sorting rated items by their Bayesian average can improve the usefulness of their
     * ratings. For example, an item with 1 rating of 5 with no other ratings will
     * be ranked higher than an item with 200 ratings at an average rating of 4.9. Most
     * likely we would prefer the later item. To adjust for this, we can rank the items by their
     * Bayesian rating and choose 5 extra ratings of 3 to be added to each item. Now the
     * first item has 1 rating of 5 and 5 ratings of 3 for a Bayesian average of 3.33 and the
     * second item has 200 ratings at an average of 4.9 and 5 ratings of 3 for a Bayesian
     * average of 4.85. Bayesian averages can be used in this way the penalize ratings where
     * there is not enough information to make a judgment on the item.
     * 
     * Hint: You can call your updateAverage method in a loop to complete this method
     *
     * @param average              The current average rating
     * @param numberOfRatings      The number of ratings contributing to the current average rating
     * @param numberOfExtraRatings The number of extra ratings to be added to the current average
     * @param extraRatingValue     The value of the extra ratings
     * @return The new average after the extra ratings have been taken into account
     */
    public double bayesianAverage(double average, int numberOfRatings,
                                  int numberOfExtraRatings, double extraRatingValue){
    	for(int i = 0; i < (numberOfExtraRatings); i++) {
    	 average = updateAverage(average,numberOfRatings,extraRatingValue);
    	 numberOfRatings += 1;
    	}
        return average; // Don't forget to replace this return statement with your own
    }

}
