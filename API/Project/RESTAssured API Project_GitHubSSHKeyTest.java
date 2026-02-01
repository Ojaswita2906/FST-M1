package github;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubSSHKeyTest {

    RequestSpecification requestSpec;

    // SSH public key (replace with your own)
    String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAg....";

    // Will store the generated SSH key ID
    int keyId;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token YOUR_GITHUB_ACCESS_TOKEN")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                RestAssured
                        .given()
                        .body(requestBody)
                        .when()
                        .post("/user/keys")
                        .then()
                        .extract()
                        .response();

        Reporter.log("POST Response: " + response.asPrettyString(), true);

        Assert.assertEquals(response.statusCode(), 201, "SSH key creation failed");

        keyId = response.jsonPath().getInt("id");
        Assert.assertTrue(keyId > 0, "Invalid SSH Key ID generated");
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}")
                        .then()
                        .extract()
                        .response();

        Reporter.log("GET Response: " + response.asPrettyString(), true);

        Assert.assertEquals(response.statusCode(), 200, "Failed to retrieve SSH key");
        Assert.assertEquals(response.jsonPath().getString("title"), "TestAPIKey");
    }

    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}")
                        .then()
                        .extract()
                        .response();

        Reporter.log("DELETE Response Status Code: " + response.statusCode(), true);

        Assert.assertEquals(response.statusCode(), 204, "Failed to delete SSH key");
    }
}
