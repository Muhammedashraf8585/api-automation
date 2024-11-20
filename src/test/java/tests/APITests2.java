package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

import static io.restassured.RestAssured.given;

public class APITests2 extends BaseTest {

    @Test
    public void testLogin() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(TestUtils.getLoginPayload())
                .when()
                .post(config.Config.LOGIN_ENDPOINT)
                .then()
                .statusCode(200)
                .extract().response();

        String token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token should not be null");
    }
}