package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.POJO_JPH;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class P23_PUT_pojoClass extends BaseUrl_JPH {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body'e sahip bir PUT request yolladigimizda
    donen response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Response body : // expected data
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
 */
    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2","70");  //Endpoint hazırlandı
        POJO_JPH reqPOJO=new POJO_JPH("Ahmet","Merhaba",10,70); //requestBody pojo class yardımıyla hazırlandı

        POJO_JPH expPOJO=new POJO_JPH("Ahmet","Merhaba",10,70);//expectedBody pojo class yardımıyla hazırlandı

        Response response=given().contentType(ContentType.JSON).when().spec(specJPH).body(reqPOJO).put("/{pp1}/{pp2}"); //Response kayıt edildi

        POJO_JPH resPOJO=response.as(POJO_JPH.class);
        //içerik karşılaştırması yapılabilmesi için dönen cevap POJO türüne çevrildi

        //assert yapıldı
        assertEquals(resPOJO.getTitle(),expPOJO.getTitle());
        assertEquals(resPOJO.getBody(),expPOJO.getBody());
        assertEquals(resPOJO.getUserId(),expPOJO.getUserId());
        assertEquals(resPOJO.getId(),expPOJO.getId());

    }

}
