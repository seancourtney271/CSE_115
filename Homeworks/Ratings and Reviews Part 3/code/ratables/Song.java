package code.ratables;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import code.Review;

public class Song extends Ratable{

    private ArrayList<Integer> ratings;
//    private String id;
    private String artist;
    private String title;


    /**
     * The constructor used to create new Song instances
     *
     * @param id The 11 character unique id for the song
     * @param artist The artist of the song
     * @param title The title of the song
     */
    public Song(String ide, String artist, String title){
        id = ide;
        this.artist = artist;
        this.title = title;
        this.ratings = new ArrayList<>();
    }


    public String getArtist(){
        return artist;
    }

    public String getTitle(){
        return title;
    }
    public String getLink(){
        return "https://www.youtube.com/watch?v=" + this.id;
    }


    @Override
    public String getDescription(){
        return artist + " - " + title;
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


    /**
     * Opens a playlist of songs in YouTube using the machine's default we browser. A maximum of 50 songs
     * can be added to a playlist
     *
     * @param songs A list of songs to play
     */
    public static void playList(ArrayList<Song> songs){
        if(songs != null && Desktop.isDesktopSupported()){
            try{
                String url = "https://www.youtube.com/watch_videos?video_ids=";
                if(!songs.isEmpty()){
                    url += songs.get(0).getID();
                }
                for(int i = 1; i < songs.size(); i++){
                    url += "," + songs.get(i).getID();
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
