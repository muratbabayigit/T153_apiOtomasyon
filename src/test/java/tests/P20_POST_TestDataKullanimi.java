package tests;

import baseUrl.BaseUrl_RestFull;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.TestDatas_HerOkuApp;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P20_POST_TestDataKullanimi extends BaseUrl_RestFull {
     /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","booking");
        JSONObject reqBody=TestDatas_HerOkuApp.reqDataOlustur();

        JSONObject expBody=TestDatas_HerOkuApp.expBodyOlustur();

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(reqBody.toString()).post("/{pp1}");

        JsonPath resJP=response.jsonPath();
        assertEquals(resJP.get("booking.firstname"),expBody.getJSONObject("booking").get("firstname"));
        assertEquals(resJP.get("booking.lastname"),expBody.getJSONObject("booking").get("lastname"));
        assertEquals(resJP.get("booking.totalprice"),expBody.getJSONObject("booking").get("totalprice"));
        assertEquals(resJP.get("booking.depositpaid"),expBody.getJSONObject("booking").get("depositpaid"));
        assertEquals(resJP.get("booking.additionalneeds"),expBody.getJSONObject("booking").get("additionalneeds"));
        assertEquals(resJP.get("booking.bookingdates.checkin"),expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        assertEquals(resJP.get("booking.bookingdates.checkout"),expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));

    }
}
