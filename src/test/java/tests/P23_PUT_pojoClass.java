package tests;

import baseUrl.BaseUrl_JPH;
import org.testng.annotations.Test;
import pojos.PojoClas_JPH;

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
        specJPH.pathParams("pp1","posts","pp2","70");
        PojoClas_JPH reqPojo=new PojoClas_JPH("Ahmet","Merhaba",10,70);

        PojoClas_JPH expPojo=new PojoClas_JPH("Ahmet","Merhaba",10,70);

    }
}
