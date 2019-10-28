package lukasz.nowogorski.SpringBoot.Json.JsonToJava;

import com.mongodb.util.JSON;
import elemental.json.Json;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;

public class Json_CDL {

    private JSONArray jsonArray;
    private JSONTokener jsonTokener;
    private CDL cdl;

    public static void main(String[] args)
    {
        System.out.println("1. Producing JSONArray Directly from Comma Delimited Text: ");
        jsonArrayFromCDT();

        System.out.println("\n2. Producing Comma Delimited Text from JSONArray: ");
        cDTfromJSONArray();

        System.out.println("\n3. Producing JSONArray of JSONObjects Using Comma Delimited Text: ");
        CDLtoJsonArray();

        System.out.println("\n4. Producing JSONArray of JSONObjects Using Comma Delimited Text: ");
        CDLtoJsonArray2();
    }




    private static void jsonArrayFromCDT() {


        String json = "Mateusz,Zelek,23,years,old";
        JSONArray jsonArray = CDL.rowToJSONArray(new JSONTokener(json));
        System.out.println(jsonArray);

        for(int i = 0; i < jsonArray.length(); i++) {
            String StringArray = jsonArray.getString(i);
            System.out.println(StringArray);
        }



    }

    private static void cDTfromJSONArray()
    {
        String json = "[\"name\",\"mouse\",\"surname\",\"Wladimir\", \"age\",\"adress\",\"mouse\",\"email\",\"asdds\",\"pesel\",3445664 ]";
        JSONArray jsonArray = new JSONArray(json);
        String cdt = CDL.rowToString(jsonArray);
        System.out.println(cdt);

    }

    private static void CDLtoJsonArray() {
        String json = "name , surname ,age \n"
                    + "Wlamir , Konzo, 23 \n"
                    +"Jarek, Chrobry, 34 \n"
                    + "Mirek, Bazyl, 19 \n"
                    + "Jarosz, Kwertyn, 45 ";

        JSONArray cdlJsonArray = CDL.toJSONArray(json);
        System.out.println(cdlJsonArray);




    }


    private static void CDLtoJsonArray2() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Name");
        jsonArray.put("Surname");
        jsonArray.put("Age");
        jsonArray.put("PESEL");

        String string = "John, Birato, 23,905334"
                + "Milek, Takero, 45, 456677"
                +"Darotez, Valencja, 33, 8767678";

        JSONArray res = CDL.toJSONArray(jsonArray,string);
        System.out.println(res);
    }




}
