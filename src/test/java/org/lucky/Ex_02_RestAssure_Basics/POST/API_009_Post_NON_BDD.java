package org.lucky.Ex_02_RestAssure_Basics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class API_009_Post_NON_BDD {


    String payload=" {\n" +
            "            \"username\":\"admin\",\n" +
            "            \"password\":\"password123\"\n" +
            "            }";


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify the POST request Positive")
    @Test
    public void test_POST_BDD() {

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        response= r.when().log().all().post();

        vr= response.then().log().all().statusCode(200);


    }
}
