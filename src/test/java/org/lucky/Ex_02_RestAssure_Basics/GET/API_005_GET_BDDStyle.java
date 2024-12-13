package org.lucky.Ex_02_RestAssure_Basics.GET;

import io.restassured.RestAssured;

public class API_005_GET_BDDStyle {

    public static void main(String[] args) {


        String pincode = "500018";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


        // negative test case

        pincode= "-1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }
}
