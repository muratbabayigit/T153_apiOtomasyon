package tests;

import baseUrl.BaseUrl_JPH;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P14_BaseUrlKullanimi extends BaseUrl_JPH {

    @Test
    public void test01() {

        //1- EndPoint hazırlanır
        specJPH.pathParam("pp1", "posts");

        Response response = given().spec(specJPH).when().get("/{pp1}");
        // response.prettyPrint();

        response.then().assertThat().statusCode(200).body("body", Matchers.hasSize(100));

    }

    @Test
    public void checkTest(){
          /*
    2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

     */

     specJPH.pathParams("pp1","posts","pp2","44");
     //expected data yok
     Response response=given().spec(specJPH).when().get("{pp1}/{pp2}");

     response.then().assertThat().statusCode(200)
             .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }
}