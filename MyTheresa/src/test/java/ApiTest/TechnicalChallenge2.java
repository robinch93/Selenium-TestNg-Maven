package ApiTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TechnicalChallenge2 {

	Response response;
	
	@BeforeTest
	public void setup() {
		// specify base URI
		RestAssured.baseURI = "https://api.github.com/";

		// request object
		RequestSpecification httpRequest = RestAssured.given();
				
		// define HTTP mehtod. 
		response = httpRequest.request(Method.GET, "/search/repositories?q=tetris+language:assemb ly&sort=stars&order=desc");

	}
	
	@Test(description = "status code validation", priority = 1)
	public void statusCodeValidation() {
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + +statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(description = "status line validation", priority = 2)
	public void statusLineValidation() {
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(description = "response Body print on console", priority = 3)
	public void responseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
	}
	
	@Test(description = "header key value Validation", priority = 4)
	public void header() {
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is : " + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	
	@Test(description = "validate json attribute values", priority = 5)
	public void jsonAttributes() {
		JsonPath jsonPath = response.jsonPath();
		int totalCount = jsonPath.get("total_count");
		System.out.println("Total Count is : " + totalCount);
		Assert.assertEquals(3, totalCount);
	}
	
	@Test(description = "Nested json attributes validation", priority = 6)
	public void nestedJsonAttributes() {
		JsonPath jsonPath = response.jsonPath();
		String totalCount = jsonPath.get("items[0].owner.type");
		System.out.println("Value is : " + totalCount);
		Assert.assertEquals("User", totalCount);
	}
	
}
