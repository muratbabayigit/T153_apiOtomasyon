package tests;

import baseUrl.BaseUrl_RestFull;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.TestDatas_HerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P22_POST_deSeralization extends BaseUrl_RestFull {
    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
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
                            Response Body // expected data
                        {
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10",
                            "additionalneeds":"wi-fi"
                        }
         */
    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","booking");
        Map<String,Object> reqMap= TestDatas_HerOkuApp.reqMapOlustur();

        Map<String,Object> expMap=TestDatas_HerOkuApp.expMapOlustur();

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(reqMap).post("/{pp1}");

        Map<String,Object> resMAP=response.as(HashMap.class);


       assertEquals(((Map)resMAP.get("booking")).get("firstname"),((Map)expMap.get("booking")).get("firstname"));
       assertEquals(((Map)resMAP.get("booking")).get("lastname"),((Map)expMap.get("booking")).get("lastname"));
       assertEquals(((Map)resMAP.get("booking")).get("depositpaid"),((Map)expMap.get("booking")).get("depositpaid"));
       assertEquals(((Map)resMAP.get("booking")).get("totalprice"),((Map)expMap.get("booking")).get("totalprice"));
       assertEquals(((Map)resMAP.get("booking")).get("additionalneeds"),((Map)expMap.get("booking")).get("additionalneeds"));
       assertEquals(((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)(expMap.get("booking"))).get("bookingdates")).get("checkin"));
       assertEquals(((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)(expMap.get("booking"))).get("bookingdates")).get("checkout"));





    }

}
