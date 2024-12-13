package org.lucky.Ex_02_RestAssure_Basics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_006_GET_BDD_UsingTESTNG_Annotaions {

    @Test

    public void test_GET_req_POSITIVE() {


        String pincode = "500018";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


    }


        // negative test case

    @Test

    public void test_GET_req_NEGATIVE(){

        String pincode= "-1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }

}
