package tests;

import baseUrl.BaseUrl_RestFull;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P26_TokenKullanimi extends BaseUrl_RestFull {
        /*
    https://restful-booker.herokuapp.com/booking/1251 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.


        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */
    static String token;

    @Test
    public void P1_createToken(){
        specHerOkuApp.pathParam("pp1","auth");
        JSONObject data=new JSONObject();
        data.put("username","admin");
        data.put("password","password123");

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(data.toString()).post("/{pp1}");

        JsonPath resJP=response.jsonPath();
        //response.prettyPrint();
        token=resJP.getString("token");
        System.out.println("token = " + token);
    }

@Test
/*{
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}

 */
    public void P2_bookingUpdate(){
        specHerOkuApp.pathParams("pp1","booking","pp2","1251");
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2025-05-01");
        bookingDates.put("checkout","2025-05-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","berk");
        reqBody.put("lastname","yiğit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalneeds","wi-fi,extra towel");


        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).
                                                                body(reqBody.toString()).
                                                                header("Content-Type","application/json").
                                                                header("Accept","application/json").
                                                                header("Cookie", "token="+token).
                                                                put("/{pp1}/{pp2}");

        response.prettyPrint();
}
}
