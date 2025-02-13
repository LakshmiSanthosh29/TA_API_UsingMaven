package org.lucky.Ex_05_PayloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class API_025_ResrAssured_Payload_Map {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

       /* String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
*/


        Map<String,Object> jsonBodyUsingMap= new LinkedHashMap<>();

        jsonBodyUsingMap.put("firstname","Pramod");
        jsonBodyUsingMap.put("lastname","Dutta");
        jsonBodyUsingMap.put("totalprice",123);
        jsonBodyUsingMap.put("depositpaid",false);

        Map<String,Object> bookingDatesMap=new LinkedHashMap<>();

        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);


        // RestAssure takes  json data but the payload here is map
        // so to convert payload to json we need to add gson dependency..
        // gson or jackson API  converts map to json

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all().statusCode(200);


        // to validate using RestAssured default one first we need to import org.hamcrest.Matchers
        //second we need to use function Matchers.equalto()
        // third we need to give json path(can find json path using jsonpathfinder.com

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));




        // for TestNG assertions we need to extract in to the variable using extract.path(jsonpath)

        bookingId = response.then().extract().path("bookingid");
        String firtname=response.then().extract().path("booking.firstname");
        String lastname=response.then().extract().path("booking.lastname");

        // TestNG Assertions

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firtname,"Pramod");
        Assert.assertEquals(lastname,"Dutta");


        // AssertJ Assertions
        // Extraction part is common for TestNG and AssertJ Assertions
        // once you Extract then..

        assertThat(bookingId).isNotNegative().isNotNull().isNotZero();
        assertThat(firtname).isEqualTo("Pramod").isAlphanumeric().isNotBlank().isNotEmpty();


    }
}
