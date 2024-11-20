package tests;

import base.BaseTest;
import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TokenGenerator;

public class APITests extends BaseTest {

    @Test(priority = 1, description = "Test Login API with valid credentials")
    public void testLogin() {
        String payload = """
                {
                    "email": "%s",
                    "password": "%s"
                }
            """.formatted(Config.EMAIL, Config.PASSWORD);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .post(Config.LOGIN_ENDPOINT);

        Assert.assertEquals(response.statusCode(), 200, "Expected 200 OK response");
        System.out.println("Response: " + response.body().prettyPrint());
    }

    @Test(priority = 2, description = "Test WhoAmI with valid token")
    public void testWhoAmI() {
        String token = TokenGenerator.generateToken();

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get(Config.WHOAMI_ENDPOINT);

        Assert.assertEquals(response.statusCode(), 200, "Expected 200 OK response");
        System.out.println("Response: " + response.body().prettyPrint());
    }
}
