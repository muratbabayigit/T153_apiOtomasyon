package tests;

import baseUrl.Base_ReqRes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.POJO_ReqResData;
import pojos.POJO_ReqResExpBody;
import pojos.POJO_ReqResSupport;
import pojos.POJO_Restfull_expBody;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class P25_GET_reqResApi extends Base_ReqRes {
        /*
    Soru: ReqRes API'sini kullanarak,
    bir kullanıcının ID'sine göre bilgilerinin alındığı
    bir GET isteği yapmanız isteniyor.
    Aşağıdaki gereksinimleri karşılayan bir TestNG test sınıfı yazın:

        https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.

        Dönen cevabın aşağıdaki gibi olduğunu test edin
        {
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
        "text": "Tired of writing endless social media content? Let Content Caddy generate it for you."
    }
}

     */

    @Test
    public void test01(){
        specReqRes.pathParams("pp1","api","pp2","users","pp3","2");

        POJO_ReqResData dataPOJO=new POJO_ReqResData(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        POJO_ReqResSupport supportPOJO=new POJO_ReqResSupport("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral","Tired of writing endless social media content? Let Content Caddy generate it for you.");
        POJO_ReqResExpBody expPOJO=new POJO_ReqResExpBody(dataPOJO,supportPOJO);

        Response response=given().when().spec(specReqRes).get("/{pp1}/{pp2}/{pp3}");

        POJO_ReqResExpBody resPOJO=response.as(POJO_ReqResExpBody.class);

        assertEquals(resPOJO.getData().getId(),expPOJO.getData().getId());
        assertEquals(resPOJO.getData().getFirst_name(),expPOJO.getData().getFirst_name());
        assertEquals(resPOJO.getData().getLast_name(),expPOJO.getData().getLast_name());
        assertEquals(resPOJO.getData().getEmail(),expPOJO.getData().getEmail());
        assertEquals(resPOJO.getData().getAvatar(),expPOJO.getData().getAvatar());
        assertEquals(resPOJO.getSupport().getUrl(),expPOJO.getSupport().getUrl());
        assertEquals(resPOJO.getSupport().getText(),expPOJO.getSupport().getText());






    }
}
