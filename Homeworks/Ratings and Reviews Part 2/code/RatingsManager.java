package code;

import code.ratables.Song;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class RatingsManager{

    private Utilities utils = new Utilities();

    /**
     * step 1
     *
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
    public HashMap<String, Song> readCSVFile(String filename){
    	HashMap<String, Song> allSongs = new HashMap <String, Song> ();
    	try {
    		for (String s: Files.readAllLines(Paths.get(filename))) {
    			String ss [] = s.split(",");
    			Song song = new Song(ss[0],ss[1],ss[2]);
    			int i = new Integer(ss[3]);
    			allSongs.putIfAbsent(ss[0], song);
    			allSongs.get(ss[0]).addRating(i);
    		}
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
        return allSongs;
    }


    /**
     * Finds and returns the song with the most reviews in the input file. If more than one song
     * has this maximum number of reviews the ties are broken arbitrarily.
     *
     * Note: This method is complete and does not require any editing
     *
     * @param filename The name of a csv file containing song ratings
     * @return The song with the most reviews in the provided file of ratings
     */
    public Song mostReviewedSong(String filename){
        Song mostReviewed = null;
        int mostReviews = -1;
        HashMap<String, Song> songs = readCSVFile(filename);
        // Check if readCSVFile has been implemented. If not, it will return the default value of null
        if(songs == null){
            return null;
        }
        for(Song song : songs.values()){
            if(song.getRatings().size() > mostReviews){
                mostReviews = song.getRatings().size();
                mostReviewed = song;
            }
        }
        return mostReviewed;
    }


    /**
     * step 2
     *
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
    public ArrayList<Song> allFives(String filename){
    	HashMap<String, Song> allSongs = readCSVFile(filename);
    	ArrayList<Integer> fives = new ArrayList <Integer>();
    	ArrayList<Song> fiv = new ArrayList <Song>();
    	
    	for (Song song: allSongs.values()) {
    		fives = song.getRatings();
    		if(utils.averageRating(fives) == 5){
    			fiv.add(song);
    		}
    	}		
        return fiv;
    }


    /**
     * step 3.3
     *
     * ** Before writing this method complete the averageRating and bayesianAverage methods **
     * ** in the Utilities Class. All three methods must be completed correctly to earn the **
     * ** next point.                                                                       **
     *
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
     * @param filename The name of a csv file containing song ratings
     * @param numberOfExtraRatings The number of extra ratings to be added to the average
     * @param extraRatingValue The value of the extra ratings
     * @param threshold The minimum Bayesian rating of the returned songs
     * @return All songs from filename with a Bayesian average greater than, or equal to, threshold
     */
    public ArrayList<Song> bayesianRatingThreshold(String filename, int numberOfExtraRatings,
                                                   double extraRatingValue, double threshold){
    	ArrayList<Song> song = new ArrayList<Song>();
    	HashMap<String, Song> songs = readCSVFile(filename);
    	for(Song songe: songs.values()) {
    		double rat = utils.bayesianAverage(songe.getRatings(), numberOfExtraRatings, extraRatingValue);
    		if (rat >= threshold) {
    			song.add(songe);
    		}
    	}

        return song;
    }


    /**
     * step 4
     *
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
     *     System.out.println("hello!");
     * }
     *
     * Note: For this assignment you should only return the songs that match the provided artist String exactly.
     * However, this this may miss some songs when the rater did not use proper capitalization, didn't add
     * spaces, or even misspelled the artists name.
     *
     * @param filename The name of a csv file containing song ratings
     * @param artist The artist to be searched
     * @return All songs by the artist that have been rated in the provided file
     */
    public ArrayList<Song> songsByArtist(String filename, String artist){
    	HashMap<String, Song> Hashsong = readCSVFile(filename);
    	ArrayList<Song> artistSong = new ArrayList<Song>();
    	for(Song song: Hashsong.values()) {
    		if(song.getArtist().equals(artist)) {
    			artistSong.add(song);
    		}
    	}
        return artistSong;
    }



    /**
     * Prints a list of songs to the console with one song per line instead of on a single line as is the
     * behavior of printing an ArrayList directly
     *
     * @param songs A list of songs to be printed
     */
    public void printList(ArrayList<Song> songs){
        if(songs != null){
            for(Song song : songs){
                System.out.println(song);
            }
        }
    }

    /**
     * Opens a playlist of songs in YouTube using the machine's default we browser. A maximum of 50 songs
     * can be added to a playlist
     *
     * @param songs A list of songs to play
     */
    public void playList(ArrayList<Song> songs){
        if(songs != null && Desktop.isDesktopSupported()){
            try{
                String url = "https://www.youtube.com/watch_videos?video_ids=";
                if(!songs.isEmpty()){
                    url += songs.get(0).getYoutubeID();
                }
                for(int i = 1; i < songs.size(); i++){
                    url += "," + songs.get(i).getYoutubeID();
                }
                Desktop.getDesktop().browse(new URI(url));
            }catch(IOException e){
                e.printStackTrace();
            }catch(URISyntaxException e){
                e.printStackTrace();
            }
        }

    }

}
