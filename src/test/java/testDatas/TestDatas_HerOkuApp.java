package testDatas;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestDatas_HerOkuApp {
    public static int basarliStatusCode=200;
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


    public static JSONObject reqDataOlustur(){
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2021-06-01");
        innerData.put("checkout","2021-06-10");
        JSONObject reqData=new JSONObject();
        reqData.put("firstname","Murat");
        reqData.put("lastname","Yiğit");
        reqData.put("totalprice",250);
        reqData.put("depositpaid",true);
        reqData.put("bookingdates",innerData);
        reqData.put("additionalneeds","wi-fi");

        return reqData;

    }


    public static JSONObject bookingDatesOlustur(String checkin, String checkout){
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);
        return bookingDates;
    }

    public static JSONObject expBodyOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        JSONObject booking=reqDataOlustur();
        expData.put("booking",booking);
        return expData;
    }








}
