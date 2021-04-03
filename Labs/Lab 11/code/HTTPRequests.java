package code;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

public class HTTPRequests {

    public static String getRequest(String url){
        String response = "";

        try{
            response = Request.Get(url).execute().returnContent().asString();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return response;
    }

    public static String postRequest(String url, String params, boolean json){
        String response = "";
        try{
            ContentType type = ContentType.DEFAULT_TEXT;
            if(json){
                type = ContentType.APPLICATION_JSON;
            }
            response = Request.Post(url).bodyString(params, type).execute().returnContent().asString();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return response;
    }

}
