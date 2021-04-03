package code.ratables;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class Song{

    private ArrayList<Integer> ratings;
    private String youtubeID;
    private String artist;
    private String title;


    /**
     * The constructor used to create new Song instances
     *
     * @param youtubeID The 11 character unique id for the song
     * @param artist The artist of the song
     * @param title The title of the song
     */
    public Song(String youtubeID, String artist, String title){
        this.youtubeID = youtubeID;
        this.artist = artist;
        this.title = title;
        this.ratings = new ArrayList<>();
    }


    // Getter methods
    public String getYoutubeID(){
        return youtubeID;
    }

    public String getArtist(){
        return artist;
    }

    public String getTitle(){
        return title;
    }

    /**
     * Returns all the ratings that have been added to this song
     *
     * @return A list of ratings for this song
     */
    public ArrayList<Integer> getRatings(){
        return this.ratings;
    }


    /**
     * Adds a new rating to this song
     *
     * @param rating The rating to be added. Must be an integer between 1 and 5 inclusive
     */
    public void addRating(int rating){
        this.ratings.add(rating);
    }

    /**
     * Formats this song's YouTube ID into a full url
     *
     * @return A YouTube link for this song
     */
    public String getLink(){
        return "https://www.youtube.com/watch?v=" + this.youtubeID;
    }


    @Override
    public String toString(){
        return "(" + this.getLink() + ") " + this.getArtist() +
                " - " + this.getTitle() + " | ratings: " + this.getRatings();
    }


    /**
     * Play this song in the default web browser
     */
    public void play(){
        if(Desktop.isDesktopSupported()){
            try{
                String url = this.getLink();
                Desktop.getDesktop().browse(new URI(url));
            }catch(IOException e){
                e.printStackTrace();
            }catch(URISyntaxException e){
                e.printStackTrace();
            }
        }
    }

}
