package lukasz.nowogorski.SpringBoot.Json.Adapter;

import com.google.gson.annotations.JsonAdapter;
import lukasz.nowogorski.SpringBoot.Json.Entity.Weather;

import javax.json.*;
import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeatherAdapter implements JsonAdapter {

    @Override
    public Class<?> value() {

        Weather weather = new Weather(1, 30, "Shine", "Brasil", DateFormat.getDateInstance(2, Locale.CHINA), 2);
        JsonObject jsonObject1 =Json.createObjectBuilder().add("id",weather.getId()).build();
        JsonObject jsonObject2 =Json.createObjectBuilder().add("temp",weather.getTemp()).build();
        JsonObject jsonObject3 =Json.createObjectBuilder().add("kindOfWeather",weather.getKindOfWeather()).build();
        JsonObject jsonObject4 = Json.createObjectBuilder().add("country",weather.getCountry()).build();
        JsonObject jsonObject5 = Json.createObjectBuilder().add("Date ", String.valueOf(weather.getDate())).build();

        Map<String,Object> map = new HashMap<>();
        map.put("CLOUDY",1);
        map.put("FREEZY",2);
        map.put("SUNNY",3);


        Json.createObjectBuilder(map);

        JsonArray jsonArray = jsonObject1.getJsonArray(weather.getCountry());
        if(jsonArray.get(weather.getId()).getValueType() == JsonValue.ValueType.ARRAY)
        {
            System.out.println("Type Value is array");
        }

        String jsonobj = jsonObject2.getString(weather.getCountry(),weather.getKindOfWeather());
        System.out.println(jsonobj);

        for(int i = 0 ; i < jsonObject3.size(); i++) {
            System.out.println(jsonObject3.get(i));
        }

        JsonNumber jsonNumberWeather = jsonObject4.getJsonNumber(weather.getCountry());
        if(jsonNumberWeather.intValue() > 0)
        {

        }
        else {
            jsonNumberWeather.isIntegral();
        }

        return null;
    }

    @Override
    public boolean nullSafe() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public static void main(String args[])
    {

    }
}
