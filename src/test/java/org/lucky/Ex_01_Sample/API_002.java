package org.lucky.Ex_01_Sample;

import io.restassured.RestAssured;

public class API_002 {

    public static void main(String[] args) {


        // Gherkin Syntax
        //Given() -> Pre requisite - URL, headers, Auth, Body ...
        //When() -> HTTP Methods- GET/POST/PUT/DELETE/PATCH...
        //Then() -> Validation - 200 OK, FirstName == Something..


        // FULL URL ->  https://api.zippopotam.us/IN/500018
        // Base URI ->  https://api.zippopotam.us
        // Base path -> /IN/500018



        // passing the testcase


        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/500018")
                .when().get()
                .then()
                .log().all()
                .statusCode(200);


        // failing the testcase

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/500018")
                .when().get()
                .then()
                .log().all()
                .statusCode(404);


    }
}
