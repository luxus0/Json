package spring_boot.spring_boot.Json.Escape;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import static java.io.Writer.*;

public class WeatherEscape {

    static String escapeJson(String temperature)
    {
        JSONObject jsonObject = new JSONObject();

        Map<String,String> weathermap = new HashMap<>();
        weathermap.put("USA","30C");
        weathermap.put("CANADA","22C");
        weathermap.put("BRASIL","38C");
        weathermap.put("INDIE","28C");
        weathermap.put("GREECE",temperature);

        jsonObject.put("1",weathermap);
       JSONArray jsonArray =  jsonObject.getJSONArray("USA");
       System.out.println(jsonArray.toList());

        return jsonObject.toString();
    }

   public static String espaceGson(String gsonOutput) throws IOException {

        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();

        gson.newJsonWriter(nullWriter());
        jsonObject.addProperty("COUNTRY",gsonOutput);

        return jsonObject.toString();

    }

    public static ObjectWriter espaceJackson()
    {

        return new ObjectMapper().writer(DateFormat.getDateInstance(DateFormat.AM_PM_FIELD));
    }


}
