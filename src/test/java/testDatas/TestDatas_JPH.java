package testDatas;

import org.json.JSONObject;

public class TestDatas_JPH {

    public static int basarliStatusCode=200;
    public static String connectionHeader="keep-alive";
    public static String contentType="application/json; charset=utf-8";

    /*
       {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio
        \nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse”
    }
     */

    //public static JSONObject expDataOlustur=new JSONObject(); //bir obje oluşturdum
    public static JSONObject expDataOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("userId", 3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut \nsed omnis non odio \nexpedita earum mollitia molestiae aut atque rem suscipit \nnam impedit esse");

        return expData;
    }

    public static JSONObject expDataCreate(String title, String body, int userId, int id){
        JSONObject expData=new JSONObject();
        expData.put("userId", userId);
        expData.put("id",id);
        expData.put("title",title);
        expData.put("body",body);

        return expData;

    }
}
