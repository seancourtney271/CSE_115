package code;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class ChatLab{

    /**
     * For this lab you are given a GUI for a chat application that can be started by running the Driver class.
     * Your goal is to complete the methods in this class to add functionality to the software. This will be
     * accomplished by accessing an accompanying API that will store the chat messages.
     */




    /**
     * 50 Competency Points
     *
     * Construct a JSON object with the value of the input named 'username' as the value at a key
     * named "username" and the value of the input named 'message' as the value at a key
     * named "message" and return the resulting object as a String.
     *
     * @param username The username of the user sending a message
     * @param message The message being sent by the user
     * @return A String representing a JSON object containing the two input values at the appropriate keys
     */
    public static String toJSON(String username, String message){
    	JsonObject u = new JsonObject();
    	u.add("username", username );
    	u.add("message", message);
    	
    	
        return u.toString();
    }


    /**
     * 50 Competency Points
     *
     * Send a message to the chat API at the url "https://fury.cse.buffalo.edu/chat/sendMessage".
     * This API end point accepts HTTP POST requests containing a JSON object in the same format
     * as specified in the toJSON method.
     *
     * Hint: You can call toJSON in this method, then call HTTPRequests.postRequest to send the String the the API
     * Hint 2: The API will return an error message if there is an error with your request. You can print the
     *         response from the API to view these messages and aid your debugging process
     *
     * @param username The username of the user sending a message
     * @param message The message being sent by the user
     */
    public static void sendMessage(String username, String message){
    	try{
    		boolean json = true;
    		JsonObject u = new JsonObject();
        	u.add("username", username );
        	u.add("message", message);
			HTTPRequests.postRequest("https://fury.cse.buffalo.edu/chat/sendMessage", toJSON(username,message), json);
    	}
    	catch(Exception e){
			PrintStream s = null;
			e.printStackTrace(s);
    	}
    }


    /**
     * 50 Competency Points
     *
     * Parse the provided JsonValue and create a new Message instance containing the data from the JSON. The
     * input will be a JSON object in the format
     *
     * {"username":"hartloff","message":"Welcome to Chat Lab","timestamp":523532623}
     *
     * Hint: Study the provided Message class to understand how to create Message instances with these three values
     *
     * @param message A JSON object containing the username, message text, and timestamp of a chat message
     * @return An instance of the Message class containing the same information as the input JSON object
     */
    public static Message parseMessage(JsonValue message){
    	JsonObject obj = message.asObject();
    	JsonValue username = obj.get("username");
    	JsonValue _message = obj.get("message");
    	JsonValue timestamp = obj.get("timestamp");
    	String user = username.asString();
    	String mess = _message.asString();
    	int t = timestamp.asInt();
    			
    	 Message m;
    	 m = new Message(user,mess,t);
        return m;
    }


    /**
     * 50 Competency Points
     *
     * Get the most recent messages from the chat API at the url "https://fury.cse.buffalo.edu/chat/getMessages?n=5"
     * where 5 is the number of messages to return and should be replaced by the input value n. This API end point
     * accepts HTTP GET requests and returns a JSON array containing JSON objects in the same format specified in the
     * parseMessage method.
     *
     * Hint: You can access this url in your browser to view the response and understand the JSON format being used
     *
     * @param n The number of messages to be returned by the API. The n most recent messages will be returned
     * @return An ArrayList of Messages containing the n most recent messages returned by the chat API in the same
     *         order as given by the API
     *         [{"username":"aser","message":"asdf","timestamp":1511977578},{"username":"chase","message":"hi","timestamp":1511976716}
     *         ,{"username":"asfda","message":"kmjk","timestamp":1511976061},{"username":"u","message":"udt","timestamp":1511975654}
     *         ,{"username":"mc","message":"double","timestamp":1511971341}]
     */
    public static ArrayList<Message> getMessages(int n){
    	ArrayList<Message> message = new ArrayList<Message>();
    	String string = HTTPRequests.getRequest("https://fury.cse.buffalo.edu/chat/getMessages?n="+n);
    	JsonArray a = Json.parse(string).asArray();
    	for(JsonValue b:a){
    		Message m = parseMessage(b);
    		message.add(m);
    	}
    	
    	
    	
        return message;
    }


    /**
     * 50 Competency Points
     *
     * Return the n most recent chat messages in a single String with each message on a separate line ordered
     * from oldest to newest (The opposite order as provided by the API).
     *
     * Hint: First call getMessages(n) then work with the returned ArrayList of Messages
     * Hint 2: You can call Collections.reverse to reverse the order of an ArrayList
     * Hint 3: The Message class has an overridden toString method that should be used
     *
     * @param n The number of messages to be returned by the API. The n most recent messages will be returned
     * @return A single String containing all chat messages from oldest to newest with each message on a new line
     */
    public static String getChatString(int n){
		return "";
//    	ArrayList<Message> mess =  getMessages(n);
//    	Collections.reverse(mess);
//    	String rat ="";
//    	for(Message m: mess){
//    		String s = m.getMessage();
//    		rat.concat(s);
//    	}
//        return "";
    }



    /**
     * 1 Proficiency Point
     *
     * Given a list of messages, return a new list containing only messages that were sent on or after
     * the provided minimum timestamp.
     *
     * Note: The API uses unix timestamps that are represented as integers with a larger value being a latter time
     * Note 2: Though it's not required for points, you can add this and the next filter to your chat program
     *         to filter the messages that are displayed
     *
     * @param messages The messages to be filtered
     * @param minTimestamp The earliest timestamp that should be included in the result
     * @return Only messages from the input list that were sent on or after the given minimum timestamp
     */
    public static ArrayList<Message> filterOldMessages(ArrayList<Message> messages, int minTimestamp){

        return null;
    }


    /**
     * 1 Proficiency Point
     *
     * Truncate the messages in the given list of messages such that any message that is greater than the
     * max length is cut off after this length and an ellipsis is appended to the end of the truncated text.
     *
     * Specifically:
     * Return an ArrayList containing all of the input messages except:
     * 1. If the message contains less than, or equal to, maxLength characters, do not change the message
     * 2. If the message contains more than maxLength characters, replace the message text with the first 
     *    maxLength characters of the original message and append "..." to the end
     *
     * Example:
     * if maxLength = 10
     * 1. A message of "Welcome" remains unchanged
     * 2. A message of "Welcome to Chat Lab" is changed to "Welcome to..."
     *
     * @param messages The messages to be truncated
     * @param maxLength The maximum number of characters a message can contain without being truncated
     * @return All of the input messages except messages longer than maxLength are truncated as specified above
     */
    public static ArrayList<Message> truncateMessages(ArrayList<Message> messages, int maxLength){

        return null;
    }

}

