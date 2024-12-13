package org.lucky.Ex_02_RestAssure_Basics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_007_NON_BDD {


    // NON BDD Style uses REst Assured Interfaces..
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify Positive Testcase : 500018")
    @Test
    public void test_GET_NONBDDStyle_Positive_TestCase() {


        String pincode = "500018";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }

    @Description("Verify NegativeTestcase : -1")

    @Test
    public void test_GET_NONBDDStyle_NEGATIVE_Testcase() {

        String pincode = "-1";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);


    }
    // negative testcase - string

    @Description("Verify Negative Testcase : String srt as input")
    @Test
    public void test_GET_NONBDDStyle_NEGATIVE_Testcase2() {

        String pincode = "srt";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);


    }


    @Description("Verify Negative Testcase : long 465464684645132131 as input")
    @Test
    public void test_GET_NONBDDStyle_NEGATIVE_Testcase3() {

        String pincode = "465464684645132131";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);

    }


    @Description("Verify Negative Testcase : special char 546*54211 as input")
    @Test
    public void test_GET_NONBDDStyle_NEGATIVE_Testcase4() {

        String pincode = "546*54211 ";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);

    }

    @Description("Verify Positive Testcase : valid input 523001")
    @Test
    public void test_GET_NONBDDStyle_Positive_TestCase1() {


        String pincode = "523001";

        r = RestAssured.given();

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }






}