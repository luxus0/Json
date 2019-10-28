package spring_boot.spring_boot.Json.JsonCrud;


import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonPointerCrud {

    private JsonStructure jsonStructure;
    private javax.json.JsonReader jsonReader;
    private javax.json.JsonPointer jsonPointer;

    public void getJsonReader(String filename) throws IOException {

        try {
            jsonReader = Json.createReader(Files.newInputStream((Paths.get(filename))));
            jsonStructure = jsonReader.read();
        }
        catch(Exception e)
        {
            System.out.println("Error to open Json file: " +e.getMessage());
        }
    }


    public void JsonPointerCrud(InputStream inputStream)
    {
        JsonReader jsonReader = Json.createReader(inputStream);
        jsonStructure = jsonReader.read();
        jsonReader.close();
    }

    public JsonStructure insert(String key,String value)
    {
        jsonPointer = Json.createPointer("/" +key);
        JsonString jsonValue = Json.createValue(value);
        jsonStructure = jsonPointer.add(jsonStructure,jsonValue);

        return jsonStructure;
    }

    public JsonStructure update(String key,String value)
    {
        jsonPointer = Json.createPointer("/" +key);
        JsonString jsonValue = Json.createValue(value);
        jsonStructure = jsonPointer.add(jsonStructure,jsonValue);

        return jsonStructure;
    }

    public JsonStructure delete(String key) {

        javax.json.JsonPointer jsonPointer = Json.createPointer("/" + key);
        jsonPointer.getValue(jsonStructure);
        jsonStructure = jsonPointer.remove(jsonStructure);

        return jsonStructure;

    }

    public String fetchValueFromKey(String key) {
        javax.json.JsonPointer jsonPointer = Json.createPointer("/" + key);
        JsonString jsonString = (JsonString) jsonPointer.getValue(jsonStructure);

        return jsonString.getString();
    }

    public String fetchListValues(String key) {
        javax.json.JsonPointer jsonPointer = Json.createPointer("/" + key);
        JsonObject jsonObject = (JsonObject) jsonPointer.getValue(jsonStructure);

        return jsonObject.toString();
    }

    public String fetchFullJSON() {
        javax.json.JsonPointer jsonPointer = Json.createPointer("");
        JsonObject jsonObject = (JsonObject) jsonPointer.getValue(jsonStructure);

        return jsonObject.toString();

    }

    public boolean check(String key) {
        JsonPointer jsonPointer = Json.createPointer("/" + key);
        boolean found = jsonPointer.containsValue(jsonStructure);

        return found;
    }



}
