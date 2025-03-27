package tests;

import baseUrl.BaseUrl_RestFull;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P15_RestfullBaseUrl extends BaseUrl_RestFull {

     /*
       https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 bookingid'sine sahip booking oldugunu test edin
  */
    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","booking");

        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));


    }

    @Test
    public void test02() {

   /*
            https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname” degerinin “Murat” oldugunu test edin
{
                 "firstname" : “Murat”,
                 “lastname” : “Yiğit”,
                 “totalprice” : 500,
                 “depositpaid” : false,
                 “bookingdates” : {
                          "checkin": "2021-06-01",
                          "checkout" : “2021-06-10”
                                   },
                 “additionalneeds” : “wi-fi”
  }
     */
        specHerOkuApp.pathParam("pp1","booking");

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout" ,"2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put( "firstname" , "Murat");
        reqBody.put( "lastname" , "YİĞİT");
        reqBody.put( "totalprice" , 345);
        reqBody.put( "depositpaid" , true);
        reqBody.put( "additionalneeds" , "wi-fi");


        Response response=given().contentType(ContentType.JSON).spec(specHerOkuApp)
                .when().body(reqBody.toString()).post("/{pp1}");

        response.then().assertThat().statusCode(200)
                .body("booking.firstname",Matchers.equalTo("Murat"));


    }




}
