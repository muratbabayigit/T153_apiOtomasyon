package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.TestDatas_JPH;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P18_TestDataKullanimi extends BaseUrl_JPH {
        /*
        https://jsonplaceholder.typicode.com/posts/65 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200 olduğunu
            Connection Header değerinin keep-alive olduğunu
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
             "userId": 7,
             "id": 65,
             "title": "consequatur id enim sunt et et",
             "body": "voluptatibus ex esse\nsint explicabo est aliquid cumque adipisci fuga repellat labore\nmolestiae corrupti ex saepe at asperiores et perferendis\nnatus id esse incidunt pariatur"
        }
     */
    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2","65");

        JSONObject expBody= TestDatas_JPH.expDataCreate("consequatur id enim sunt et et","voluptatibus ex esse\nsint explicabo est aliquid cumque adipisci fuga repellat labore\nmolestiae corrupti ex saepe at asperiores et perferendis\nnatus id esse incidunt pariatur",7,65);

        Response response=given().when().spec(specJPH).get("/{pp1}/{pp2}");

        assertEquals(response.getStatusCode(),TestDatas_JPH.basarliStatusCode);
        assertEquals(response.getHeader("Connection"),TestDatas_JPH.connectionHeader);

        JsonPath resJP=response.jsonPath();

        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));



    }
}
