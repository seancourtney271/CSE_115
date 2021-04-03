package code;

import code.ratables.Song;

import java.util.HashMap;

public class Driver{

    /**
     * This class contains test code that calls the methods from RatingsManager. You can, and should, edit
     * this file to test various aspects of your program or to find new music
     */
    public static void main(String[] args){
        RatingsManager rm = new RatingsManager();

        String filename10am = "data/10am.csv";
        String filename12pm = "data/12pm.csv";
        String filename2pm = "data/2pm.csv";
        String filenameAll = "data/all_ratings.csv";

        // Edit these values to change the program behavior
        int numberOfExtraRatings = 3;
        double extraRatingValue = 3.0;
        double threshold = 4.01;


        // Verify that all the songs and ratings from sample.csv are displayed here to test
        // your readCSVFile method
        System.out.println("** All sample songs and ratings **");
        HashMap<String, Song> songs = rm.readCSVFile("data/sample.csv");
        if(songs != null){
            for(Song song : songs.values()){
                System.out.println(song);
            }
        }

        System.out.println("\n** Most reviewed songs **");
        System.out.println("10am: " + rm.mostReviewedSong(filename10am));
        System.out.println("12pm: " + rm.mostReviewedSong(filename12pm));
        System.out.println("2pm:  " + rm.mostReviewedSong(filename2pm));
        System.out.println("all:  " + rm.mostReviewedSong(filenameAll));


        System.out.println("\n** All songs with a 5.0 average rating **");
        System.out.println("10am:");
        rm.printList(rm.allFives(filename10am));
        System.out.println("12pm:");
        rm.printList(rm.allFives(filename12pm));
        System.out.println("2pm:");
        rm.printList(rm.allFives(filename2pm));
        System.out.println("all:");
        rm.printList(rm.allFives(filenameAll));


        System.out.println("\n** All songs with Bayesian average > " + threshold + " **");
        System.out.println("10am:");
        rm.printList(rm.bayesianRatingThreshold(filename10am, numberOfExtraRatings, extraRatingValue, threshold));
        System.out.println("12pm:");
        rm.printList(rm.bayesianRatingThreshold(filename12pm, numberOfExtraRatings, extraRatingValue, threshold));
        System.out.println("2pm:");
        rm.printList(rm.bayesianRatingThreshold(filename2pm, numberOfExtraRatings, extraRatingValue, threshold));
        System.out.println("all:");
        rm.printList(rm.bayesianRatingThreshold(filenameAll, numberOfExtraRatings, extraRatingValue, threshold));


        String artist = "Tom Petty and The Heartbreakers";
        System.out.println("\n** Songs by " + artist + " **");
        rm.printList(rm.songsByArtist(filenameAll, artist));


        // Comment in this line to play the top songs as voted by the class
//        rm.playList(rm.bayesianRatingThreshold("data/all_ratings.csv",  3, 3, 4.001));
    }

}
