package org.lucky.Ex_02_RestAssure_Basics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class API_008_Post_BDD {


    // TC <100 -> BDD
    // TC > 100 -> NON BDD

    // for post request we need :
        // url, body, header,


    // url - https://restful-booker.herokuapp.com/auth

    /*    {
            "username":"admin",
            "password":"password123"
            }

            content type - application/json
     */

        String payload = " {\n" +
                "            \"username\":\"admin\",\n" +
                "            \"password\":\"password123\"\n" +
                "            }";
        @Description("Verify the POST request Positive")
        @Test
        public void test_POST_BDD() {
            RestAssured.given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all().body(payload)
                    .when().log().all().post()
                    .then().log().all().statusCode(200);


        }

}
