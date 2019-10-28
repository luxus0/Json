package lukasz.nowogorski.SpringBoot.Json.JsonToJava;

import org.json.Cookie;
import org.json.JSONObject;

public class Cookie_ {


    public static void main(String[] args)
    {
        System.out.println("--CREATE COOKIE STRING TO JSONObject--");
        cookieStringToJSONObject();

        System.out.println("JSONOBJECT TO STRING COOKIE");
        jsonObjectToStringCookie();
    }



    private static void cookieStringToJSONObject() {
        String cookie = "name = Mateusz;surname = Wladimir;age = 45,ColorEyes = brown";
        JSONObject jsonObject = Cookie.toJSONObject(cookie);
        System.out.println(jsonObject);

    }

    private static void jsonObjectToStringCookie() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Franko");
        jsonObject.put("Surname","MAretza");
        jsonObject.put("Age","45");
        jsonObject.put("ColorHair","brown");

        String cookieString = Cookie.toString(jsonObject);
        System.out.println(cookieString);
    }



}
