package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P09_POST_JSONPathBodyTest {
        /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahipbir POST request gonderdigimizde
     {
        "firstname" : "Ahmet",
        "lastname" : "Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" :{
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                        },
        "additionalneeds" : "wi-fi"
     }
     donen Response’un,
     status code’unun 200,
     ve content type’inin application/json,
     ve response body’sindeki
     "firstname“in,"Ahmet",
     ve "lastname“in, "Bulut",
     ve "totalprice“in,500,
     ve "depositpaid“in,false,
     ve "checkin" tarihinin 2021-06-01 ve "checkout" tarihinin 2021-06-10
     ve "additionalneeds“in,"wi-fi"
     oldugunu test edin

     */
    @Test
    public void test01(){
        //1-Endpoint ve reqBody hazırlama
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2025-06-01");
        bookingdates.put("checkout","2025-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","BABAYİĞİT");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wi-fi");

      //2-Expected data verimediği için hazırlanmadı
      //3-Response kaydedilir
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
       response.prettyPrint();
       response.then().assertThat().statusCode(200).contentType("application/json")
               .body("booking.firstname", equalTo("Murat"),
                       "booking.lastname",equalTo("BABAYİĞİT"),
                       "booking.totalprice",equalTo(500),"booking.depositpaid",is(true),
                       "booking.bookingdates.checkin",equalTo("2025-06-01"),
                       "booking.bookingdates.checkout",equalTo("2025-06-10"),
                       "booking.additionalneeds",equalTo("wi-fi"));

    }
}
