package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.TestDatas_JPH;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P19_PUT_testDataKullanimi extends BaseUrl_JPH {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */
    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2","70");
        JSONObject reqBody= TestDatas_JPH.expDataCreate("Ahmet","Merhaba",10,70);
        JSONObject expBody=reqBody;
        Response response=given().contentType(ContentType.JSON).when().spec(specJPH).body(reqBody.toString()).put("/{pp1}/{pp2}");

        assertEquals(response.getStatusCode(),TestDatas_JPH.basarliStatusCode);
        assertEquals(response.getContentType(),TestDatas_JPH.contentType);
        assertEquals(response.getHeader("Connection"),TestDatas_JPH.connectionHeader);

        JsonPath resJP=response.jsonPath(); //içerik karşılaştırılacaksa hazırlanmalı

        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));




    }
}
