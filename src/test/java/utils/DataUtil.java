package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtil{

    @DataProvider
    public Object[] dataRegistration(){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        //Reading JSON file
        try{
            Object obj = parser.parse(new FileReader("src/main/resources/dataProvider.json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Array to store JSON Data
        Object[] data = new Object[1];

        // Store JSON data s ke/value in a hasMap
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set<String> jsonObjKeys = jsonObject.keySet();
            for (String jsonObjKey : jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        } else {
            //log.error("Error retrieving JSON data");
            throw new RuntimeException();
        }

        // Store HashMap in an array and return array
        data[0] = hashMap;
        return data;

    }
}
