package lukasz.nowogorski.SpringBoot.Json.JsonToJava;

import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class JSONArray_CREATE
{


    public static void main(String[] args)
    {
        System.out.println("CREATE JSONArray");
        createJSONArray();
    }

    private static void createJSONArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(0,"Janek");
        jsonArray.put(1,"Jarocki");
        jsonArray.put(2,"Marekos");
        jsonArray.put(3,"Maretza");
        jsonArray.put(4,"Birika");
        jsonArray.put(5,"Faela");
        jsonArray.put(6,"Izidiom");
        jsonArray.put(7,"Mateksa");
        jsonArray.put(8,"Bitur");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("FIELD: ",Arrays.asList("Marek","Franek","Darek","Andrzej","WIOSNA","LATO","JESIEN","ZIMA","Bialoszedws"));

        System.out.println("Covert from JSONObiect to JSONArray");
       JSONArray toJsonArray = jsonObject.toJSONArray(jsonArray);
       System.out.println(toJsonArray);

       System.out.println("Convert From JSONArray to JSONObiect");
       System.out.println(jsonArray.toJSONObject(jsonArray));

    }
}
