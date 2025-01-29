package org.lucky.Ex_02_RestAssure_Basics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_010_PUT_NONBDD {

    String payload= "{\n" +
            "    \"firstname\" : \"lucks\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String bookingid="741";
    String token="5637a6a9ab7fa45";


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify the Put request Positive")
    @Test
    public void test_PUT_NonBDD() {

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response= r.when().log().all().put();

        vr= response.then().log().all().statusCode(200);


    }
}
