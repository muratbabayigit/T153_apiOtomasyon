package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import testDatas.TestDatas_JPH;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P17_TestDataKullanimi extends BaseUrl_JPH {
    /*

     https://jsonplaceholder.typicode.com/posts/22 url’ine bir
    GET request yolladigimizda donen response’in
    status kodunun 200 ve
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

     Response body : (expected data)
    {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio
        \nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse”
    }
 */


    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2","22");
        //GET---> request Body yok
        JSONObject expBody=TestDatas_JPH.expDataOlustur();

        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(response.getStatusCode(), TestDatas_JPH.basarliStatusCode);
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));
        assertEquals(resJP.getString("title"),expBody.getString("title"));
        //assertEquals(resJP.getString("body"),expBody.getString("body"));




    }
}
