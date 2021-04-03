package code;

import code.comparators.AlphabeticalComparator;
import code.comparators.AverageRatingComparator;
import code.comparators.BayesianAverageComparator;
import code.comparators.NumberOfReviewsComparator;
import code.ratables.Product;
import code.ratables.Ratable;
import code.ratables.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RatingsManager{

    /**
     * Return a map of YouTubeID's to Song objects containing all the information from the provided file.
     *
     * In this method, and others in this class, you are provided a filename for a csv file containing song
     * ratings. Each line of these files will be in the format "YouTubeID,artist,songName,rating" where the
     * YouTubeID is an 11 character String identifying the video for the song and the rating is an integer
     * in the range 1-5 inclusive.
     *
     * Since the YouTubeID's will be unique (no duplicates) we will use them as the keys in the HashMap. This
     * allows us to quickly find a specific song given its id by calling .get on the HashMap. The values of
     * this HashMap will be Song objects containing the information for each Song. Review the Song class in
     * the ratables package to find all the methods that can be called on these Songs. Most notably you will
     * need the following Song methods:
     *
     * // Create a new Song
     * Song song = new Song("DmeUuoxyt_E", "Nickleback", "Rockstar");
     *
     * // Add a rating to a song
     * song.addRating(5);
     * song.addRating(4);
     *
     * // Get an ArrayList of all ratings for a Song
     * ArrayList<Integer> ratings = song.getRatings();
     *
     * Hint: When a song has multiple ratings in the file you must not add the song to the map a second time
     * or the original song will be overwritten (no duplicates in a HashMap). Instead, you only want ot call the
     * addRating method on the existing song in the HashMap. One way to avoid overwriting the song is to
     * call putIfAbsent(key, value) when putting a key-value pair into the HashMap. This method is used in the
     * same way as the .put(key, value) method except it will not do anything if the key already exists in
     * the HashMap.
     *
     * @param filename The name of a csv file containing song ratings
     * @return A map of YouTubeID's to Song objects containing all the information from the provided file
     */
    public static ArrayList <Ratable> readSongCSVFile(String filename){
        HashMap<String, Song> songs = new HashMap<>();
        ArrayList <Ratable> ratable = new ArrayList <Ratable>();
        try{
            for(String line : Files.readAllLines(Paths.get(filename))){
                String[] values = line.split(",");
                String id = values[0];
                String artist = values[1];
                String title = values[2];
                int rating = new Integer(values[3]);
                songs.putIfAbsent(id, new Song(id, artist, title));
                songs.get(id).addRating(rating);
             
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        for(Song s: songs.values()) {
       	 ratable.add(s);
       }

        return ratable;
    }

    public static ArrayList<Ratable> readProductCSVFile(String filename){
    	ArrayList<Ratable> a = new ArrayList <Ratable>();
        HashMap<String, Product> product = new HashMap<>();
    	try{
            for(String line : Files.readAllLines(Paths.get(filename))){
                String[] values = line.split(",");
                String asin = values[0];
//                String reviewername = values[1];
                int rating = new Integer(values[2]);
                String review = values[3];
                Product p = new Product(asin);
                product.putIfAbsent(asin, p);
                product.get(asin).addRatingWithReview(rating, review);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    	for(Product s: product.values()) {
    		a.add(s);
    	}
    	return a;
    }
    /**
     * Return every song that has only 5 star ratings (average rating of 5.0)
     *
     * Note: These songs all have the highest possible average rating and there are a lot of them! In the
     * all_ratings.csv there are 505 such songs which would make it meaningless to sort the songs by
     * their average rating. For this reason, we will only consider their Bayesian average when searching for
     * the top songs
     *
     * @param filename The name of a csv file containing song ratings
     * @return A list of all songs with an average rating of 5.0
     */
    public static ArrayList<Ratable> allFives(ArrayList<Ratable> ratable){
        ArrayList<Ratable> ans = new ArrayList<>();
        for(int i = 0;i < ratable.size(); i++){
        	Ratable rate = ratable.get(i);
            if(songAllFives(rate)){
                ans.add(rate);
            }
        }
        return ans;
    }

    // Helper method used to implement allFives
    private static boolean songAllFives(Ratable rate){
        for(Review review : rate.getReviews()){
        	int rating = review.getRating();
;            if(rating != 5){
                return false;
            }
        }
        return true;
    }


    /**
     * Return a list of all songs with a Bayesian average greater than or equal to the threshold.
     *
     * Note: calling this method with 0 extra ratings will return the same results as the using
     * the average rating without Bayesian averaging.
     *
     * Hint: For each song you can call .getRatings() to access its ratings and use this as
     * an input to your Bayesian average method from step 3.2. You can use any method from
     * the Utilities class through the utils instance variable as follows:
     *
     * double average = utils.averageRating(4, 5);
     *
     * @param filename             The name of a csv file containing song ratings
     * @param numberOfExtraRatings The number of extra ratings to be added to the average
     * @param extraRatingValue     The value of the extra ratings
     * @param threshold            The minimum Bayesian rating of the returned songs
     * @return All songs from filename with a Bayesian average greater than, or equal to, threshold
     */
    public static ArrayList<Ratable> bayesianRatingThreshold(ArrayList<Ratable> trait, int numberOfExtraRatings,
                                                          double extraRatingValue, double threshold){
        ArrayList<Ratable> ans = new ArrayList<>();
        for(int i = 0;i < trait.size(); i++){
        	Ratable rate = trait.get(i);
            double avg = Utilities.bayesianAverage(rate.getReviews(), numberOfExtraRatings, extraRatingValue);
            if(avg >= threshold){
                ans.add(rate);
            }
        }
        return ans;
    }


    /**
     * Return all rated songs by the given artist.
     *
     * Hint: When comparing String, as well as any other objects, in java you should use the .equals method
     * and not the == operator. Using == does not always return true even when the two Strings have identical
     * values. However, the .equals method will compare the values of the Strings and return true only if these
     * values are identical (same characters in the same order).
     *
     * Example:
     * String x = "hello";
     * String y = "hello";
     * if(x.equals(y)){
     * System.out.println("hello!");
     * }
     *
     * Note: For this assignment you should only return the songs that match the provided artist String exactly.
     * However, this this may miss some songs when the rater did not use proper capitalization, didn't add
     * spaces, or even misspelled the artists name.
     *
     * @param filename The name of a csv file containing song ratings
     * @param artist   The artist to be searched
     * @return All songs by the artist that have been rated in the provided file
     */


    /**
     * Prints a list of ratables to the console with one ratable per line instead of on a single line as is the
     * behavior of printing an ArrayList directly
     *
     * @param ratables A list of ratables to be printed
     */
    public static void printList(ArrayList<Ratable> ratables){
        if(ratables != null){
            for(Ratable ratable : ratables){
                System.out.println(ratable);
            }
        }
    }


    /**
     * Sorts the input list alphabetically by description
     *
     * @param ratables The Ratables to be sorted
     */
    public static void sortAlphabetically(ArrayList<Ratable> ratables){
        Collections.sort(ratables, new AlphabeticalComparator());
    }


    /**
     * Sorts the input list by number of reviews in decreasing order (The most reviewed Ratable should be at index 0)
     *
     * @param ratables The Ratables to be sorted
     */
    public static void sortByNumberOfReviews(ArrayList<Ratable> ratables){
    	Collections.sort(ratables, new NumberOfReviewsComparator());
    }


    /**
     * Sorts the input list by average rating in decreasing order (The highest rated Ratable should be at index 0)
     *
     * @param ratables The Ratables to be sorted
     */
    public static void sortByAverageRating(ArrayList<Ratable> ratables){
    	Collections.sort(ratables, new AverageRatingComparator());
    }


    /**
     * return an ArrayList containing the top k ratables according to the given Comparator
     *
     * Hint: You can fist sort the ArraList with the Comparator, then copy the Ratables from index 0 to k-1 into a
     * new ArrayList to return
     *
     * @param ratables The Ratables to be sorted
     * @param k The number of top ratables to be returned (Ex. if k=10 you'll return a top ten list)
     * @param comparator A Comparator to define the sorting order
     * @return The top k list based on the given Comparator
     */
    public static ArrayList<Ratable> getTopK(ArrayList<Ratable> ratables, int k, Comparator<Ratable> comparator){
    	Collections.sort(ratables, comparator);
    	ArrayList<Ratable> rat = new ArrayList<Ratable>();
    	for(int i = 0; i < k; i++) {
    		Ratable r = ratables.get(i);
    		rat.add(r);
    	}
        return rat;
    }


    /**
     * Sorts the input list by bayesian rating in decreasing order (The highest rated Ratable should be at index 0)
     *
     * @param ratables             The Ratables to be sorted
     * @param numberOfExtraRatings The number of extra ratings to be added to the average
     * @param extraRatingValue     The value of the extra ratings
     */
    public static void sortByBayesianAverage(ArrayList<Ratable> ratables, int numberOfExtraRatings, double extraRatingValue){
    	Collections.sort(ratables, new BayesianAverageComparator(numberOfExtraRatings,extraRatingValue));
    }


}
