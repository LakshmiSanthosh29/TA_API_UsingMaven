package org.lucky.Ex_02_RestAssure_Basics.DELETE;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_012_DELETE_NONBDD {


    String bookingid="931";
    String token= "e56227d20a6563a";

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Description("verify DELETE request Positive")
    @Test

    public void test_Delete_NonBdd() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token).log().all();

        response = requestSpecification.when().log().all().delete();

        validatableResponse = response.then().log().all().statusCode(201);


    }




    }
