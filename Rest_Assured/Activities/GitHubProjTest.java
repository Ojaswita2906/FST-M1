
package GitHubProject;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjTest {
	/*
	 * POST : https://api.github.com/user/keys GET:
	 * https://api.github.com/user/keys/{keyId} DELETE: POST :
	 * https://api.github.com/user/keys/{keyId}
	 */
	//SSH key to test with
	String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIB79G6tPC6IARu5/4ycnJiNTyERhE3fKLbpZrolNadY3";
	//Temp variable to store keyId
	int keyId;	
	//Declare the req and resp specification
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void SetUp() {
		//Initialize the req specification
		//Since the below parameters are common to all the 3 request, that's what we include in specification
		requestSpec= new RequestSpecBuilder()
				.setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-type", "application/json")
				.addHeader("Authorization", "token")
				.addHeader("X-GitHub-Api-Version", "2022-11-28")
				.build();
		//Initialize the response specification
		responseSpec= new ResponseSpecBuilder()
				.expectBody("title",Matchers.equalTo("TestKey"))
				.expectBody("key",Matchers.equalTo(sshKey))
				.expectResponseTime(Matchers.lessThanOrEqualTo(3000L))
				.build(); //expectStatusCode(), expectBody("prop",Matchers.equalTo())
	}
	
	@Test(priority=1)
	public void postRequestTest() {
		//create a request Body
		HashMap<String,String> reqBody= new HashMap<String,String>();
		reqBody.put("title", "TestKey");
		reqBody.put("key",sshKey);		
		//send req, save reponse
		Response response= RestAssured.given().spec(requestSpec).body(reqBody).log().all().when().post();
		//Extract the  id from response
		keyId=response.then().extract().path("id");
		//Assertions
		response.then().
		statusCode(201).
		spec(responseSpec).log().all();
		
	}
		
	@Test(priority=2)
	public void getRequestTest() {
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
		when().get("/{keyId}").
		then().statusCode(200).spec(responseSpec);
    }
	
	@Test(priority=3)
	public void deleteRequestTest() {
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
		when().delete("/{keyId}").
		then().statusCode(204);
    }

}
