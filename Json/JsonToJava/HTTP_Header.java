package lukasz.nowogorski.SpringBoot.Json.JsonToJava;

import com.mongodb.util.JSON;
import org.json.HTTP;
import org.json.JSONObject;

public class HTTP_Header {



    public static void main(String[] args)
    {
        System.out.println("CONVERT HTTP HEADER TO JSONObject");
        HttpHeadertoJsonObject();

        System.out.println("CONVERT JSONObject TO HTTP HEADER");
        JSONObjectToHTTPHeader();
    }

    private static void JSONObjectToHTTPHeader() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Method", "POST");
        jsonObject.put("Request-URI", "http://www.example.com/");
        jsonObject.put("HTTP-Version", "HTTP/1.1");

        String httpHeader = HTTP.toString(jsonObject);
        System.out.println(httpHeader);

    }

    public static void HttpHeadertoJsonObject()
    {
        JSONObject jsonObject = HTTP.toJSONObject("POST \"http://www.example.com/\" HTTP/1.1");
        System.out.println(jsonObject);
    }
}
