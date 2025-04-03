package tests;

import baseUrl.BaseUrl_RestFull;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.POJO_Restfull_bookingdates;
import pojos.POJO_Restfull_expBody;
import pojos.POJO_Restfull_reqBody;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P24_POST_PojoKullanimi extends BaseUrl_RestFull {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : "Bulut",
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
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */
@Test
    public void test01(){
      //1-Endpoint ve POST old için reqBody hazırlama
        specHerOkuApp.pathParam("pp1","booking");
        POJO_Restfull_bookingdates bookingdates=new POJO_Restfull_bookingdates("2025-05-01","2025-05-10");
        POJO_Restfull_reqBody reqBody=new POJO_Restfull_reqBody("Murat","Yiğit",250,true,bookingdates,"wi-fi");

      //2-ExpBody hazırlama
        POJO_Restfull_expBody expBody=new POJO_Restfull_expBody(24,reqBody);

      //3-Response kayıt edilir
        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(reqBody).post("/{pp1}");

        POJO_Restfull_expBody resPOJO=response.as(POJO_Restfull_expBody.class);

     //4-Assertion işlemleri

    assertEquals(resPOJO.getBooking().getFirstname(),expBody.getBooking().getFirstname());
    assertEquals(resPOJO.getBooking().getLastname(),expBody.getBooking().getLastname());
    assertEquals(resPOJO.getBooking().getTotalprice(),expBody.getBooking().getTotalprice());
    assertEquals(resPOJO.getBooking().isDepositpaid(),expBody.getBooking().isDepositpaid());
    assertEquals(resPOJO.getBooking().getBookingdates().getCheckin(),expBody.getBooking().getBookingdates().getCheckin());
    assertEquals(resPOJO.getBooking().getBookingdates().getCheckout(),expBody.getBooking().getBookingdates().getCheckout());
    assertEquals(resPOJO.getBooking().getAdditionalneeds(),expBody.getBooking().getAdditionalneeds());
}

}
