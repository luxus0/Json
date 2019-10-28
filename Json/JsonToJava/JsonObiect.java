package lukasz.nowogorski.SpringBoot.Json.JsonToJava;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonObiect {
    public static void main(String[] args) {
        System.out.println("4.1. Creating JSONObject: ");
        jsonFromJSONObject();

        System.out.println("\n4.2. Creating JSONObject from Map: ");
        jsonFromMap();

        System.out.println("\n4.3. Creating JSONObject from JSON string: ");
        jsonFromJSONString();
    }

    private static void jsonFromJSONString() {

        JSONObject jsonObiect = new JSONObject(
                "{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}"
        );

        System.out.println(jsonObiect.toString());

    }

    private static void jsonFromMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "jon doe");
        map.put("age", "22");
        map.put("city", "chicago");

        JSONObject jsonObject = new JSONObject(map);
        String jsonobj =  jsonObject.toString();
        System.out.println(jsonobj);


    }

    private static void jsonFromJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "jon doe");
        jsonObject.put("age", "22");
        jsonObject.put("city", "chicago");

        System.out.println(jsonObject.toString());
    }
}