package tests;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P08_JsonPathKullanim {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }


     */

    @Test
    public void test01(){
        JSONObject cepTel=new JSONObject();
        cepTel.put("type","iPhone");
        cepTel.put("number", "0123-4567-8888");

        JSONObject homeTel=new JSONObject();
        homeTel.put("type", "home");
        homeTel.put("number", "0123-4567-8910");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,cepTel);
        phoneNumbers.put(1,homeTel);

        JSONObject address=new JSONObject();
        address.put("streetAddress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONObject personalInfo=new JSONObject();
        personalInfo.put("firstName","John");
        personalInfo.put("lastName","doe");
        personalInfo.put("age",26);
        personalInfo.put("address",address);
        personalInfo.put("phoneNumbers",phoneNumbers);


        System.out.println("Personel Info:\nFirstname: "+personalInfo.get("firstName")+"\nLastname: "+personalInfo.get("lastName")+
                           "\nAge: "+personalInfo.get("age")+"\nStreet Adres: "+personalInfo.getJSONObject("address").get("streetAddress")+
                           "\nCity: "+personalInfo.getJSONObject("address").get("city")+
                           "\nPostal Code: "+personalInfo.getJSONObject("address").get("postalCode")+
                           "\nHome Tel: "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type")+"-"+personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number")+
                           "\nCep Tel: "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type")+"-"+personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

    }
}
