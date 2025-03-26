package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class P10_GET_ResponseBodyTestListKullanimi {
    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    bir GET request yolladigimizda
    donen Response'in
    status code'unun 200,
    ve content type'inin Aplication.JSON,
    ve response body'sindeki
        employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox" isimli olduğunu
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin
    test edin.
     */

    @Test
    public void test01(){
        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response= RestAssured.get(url);

      //response.prettyPeek();

       response.then().assertThat().statusCode(200).contentType("application/json")
                                    .body("data.id", hasSize(24),
                                    "data.employee_name",hasItem("Ashton Cox"),
                                             "data.employee_age",hasItems(61,21,35));
    }
}
