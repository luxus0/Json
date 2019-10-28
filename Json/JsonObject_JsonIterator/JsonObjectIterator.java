package lukasz.nowogorski.SpringBoot.Json.JsonObject_JsonIterator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class JsonObjectIterator
{
    private Map<String, Object> keyValuePairs;

    public JsonObjectIterator(Map<String, Object> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }

    public void handleValue(String key,Object value)
    {
        if(value instanceof JSONArray)
        {
            handleJSONArray(key,(JSONArray)value);
        }
        else if(value instanceof JSONObject)
        {
            handleJSONObject((JSONObject)value);
        }
    }



    private void handleJSONObject(JSONObject jsonObject) {

        Iterator<String> jsonObjectIterator = jsonObject.keys();
        jsonObjectIterator.forEachRemaining(key ->{
               Object value = jsonObject.get(key);
               handleValue(key,value);
    } );

    }

    private void handleJSONArray(String key, JSONArray jsonArray) {

        Iterator<Object> JsonArrayIterator = jsonArray.iterator();
        JsonArrayIterator.forEachRemaining(element ->
        {
            handleValue(key,element);
        });
    }

    public Map<String, Object> getKeyValuePairs() {
        return keyValuePairs;
    }

    public void setKeyValuePairs(Map<String, Object> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;

    }
}
