package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class Base_ReqRes {
    protected RequestSpecification specReqRes;
    @BeforeTest
    public void setUp(){
        specReqRes=new RequestSpecBuilder().setBaseUri("https://reqres.in").build();


    }
}
