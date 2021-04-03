package code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message{

    private String username;
    private String message;
    private int timestamp;

    public Message(String username, String message, int timestamp){
        this.username = username;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(int timestamp){
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        Date date = new Date(((long) timestamp) * 1000);
        String readableDate = new SimpleDateFormat("MMM d @ h:mm:ss a").format(date);
        return "[" + readableDate + "] " + username + ": " + message;
    }
}
