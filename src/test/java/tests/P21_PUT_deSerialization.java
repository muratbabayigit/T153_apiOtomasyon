package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.TestDatas_HerOkuApp;
import testDatas.TestDatas_JPH;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P21_PUT_deSerialization extends BaseUrl_JPH {
/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

     Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */
    @Test
    public void deSerailizationTest(){
        specJPH.pathParams("pp1","posts","pp2","70");
        Map<String, Object> reqMap= TestDatas_JPH.mapBodyOlustur();

        Map<String, Object> expMAP= TestDatas_JPH.mapBodyCreate("Ahmet","Merhaba",10.0,70.0);

       Response response=given().contentType(ContentType.JSON).when().spec(specJPH).body(reqMap).put("/{pp1}/{pp2}");

        //Expected data türü MAP fakat dönen cevap json olduğu için dönen cevabı beim map olarak kaydetmem lazım

        Map<String,Object> resMAP=response.as(HashMap.class);

        assertEquals(resMAP.get("title"),expMAP.get("title"));
        assertEquals(resMAP.get("body"),expMAP.get("body"));
        assertEquals(resMAP.get("userId"),expMAP.get("userId"));
        assertEquals(resMAP.get("id"),expMAP.get("id"));



    }

}
