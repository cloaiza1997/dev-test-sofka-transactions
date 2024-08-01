package org.cloaiza.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class TransactionControllerTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().post("/transactions")
                .then()
                .statusCode(404);
    }

}