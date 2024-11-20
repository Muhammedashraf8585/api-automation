package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests5 extends BaseTest {

    @Test
    public void testWhoami() {
        Response response = given()
                .header("Authorization", "Bearer " + config.Config.TOKEN)
                .when()
                .get(config.Config.WHOAMI_ENDPOINT)
                .then()
                .statusCode(200)
                .extract().response();

        String email = response.jsonPath().getString("email");
        Assert.assertEquals(email, config.Config.EMAIL, "Email should match");
    }
}