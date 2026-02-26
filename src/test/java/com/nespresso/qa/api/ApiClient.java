package com.nespresso.qa.api;

import com.nespresso.qa.utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

   private static final String BASE_URL = "https://dotesthere.com";

        public Response createUser() {

            String requestBody =
                    JsonUtils.readJsonFile("testdata/createUser.json");

            return RestAssured
                    .given()
                    .baseUri(BASE_URL)
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .log().all()
                    .when()
                    .post("/api/users")
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response getUser(String id) {
            return RestAssured
                    .given()
                    .baseUri(BASE_URL)
                    .log().all()
                    .when()
                    .get("/api/users/" + id)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response updateUser(String id) {

            String requestBody =
                    JsonUtils.readJsonFile("testdata/updateUser.json");

            return RestAssured
                    .given()
                    .baseUri(BASE_URL)
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .log().all()
                    .when()
                    .put("/api/users/" + id)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response deleteUser(String id) {
            return RestAssured
                    .given()
                    .baseUri(BASE_URL)
                    .log().all()
                    .when()
                    .delete("/api/users/" + id)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }
}