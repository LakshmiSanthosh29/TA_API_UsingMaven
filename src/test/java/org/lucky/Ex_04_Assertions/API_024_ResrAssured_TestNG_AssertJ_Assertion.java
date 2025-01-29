package org.lucky.Ex_04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class API_024_ResrAssured_TestNG_AssertJ_Assertion {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
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


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

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
