package ApiTest;
import java.util.List;

import org.apache.http.params.CoreConnectionPNames;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapperType;
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
		response = httpRequest.request(Method.GET, "/search/repositories?q=tetris+language:assembly&sort=stars&order=desc");
	
	}
	
	@Test(description = "status code validation", priority = 1)
	public void statusCodeValidation() throws InterruptedException {
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + +statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(description = "status line validation", priority = 2)
	public void statusLineValidation() throws InterruptedException {
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(description = "From response body schema, verify all id field have values", priority = 3)
	public void responseBody() throws InterruptedException {
		Schema schema = response.as(Schema.class, ObjectMapperType.GSON);
		List<Item> items = schema.getItems();
		for(Item item : items) {
			Assert.assertTrue("Id is Blank", !item.getId().equals(""));
			Thread.sleep(100);
		}
	}
	
	@Test(description = "header key value Validation", priority = 4)
	public void header() throws InterruptedException {
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is : " + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	
	@Test(description = "validate json attribute values", priority = 5)
	public void jsonAttributes() throws InterruptedException {
		JsonPath jsonPath = response.jsonPath();
		boolean jsonAttributeValue = jsonPath.get("incomplete_results");
		System.out.println("Value is : " + jsonAttributeValue);
		Assert.assertEquals(false, jsonAttributeValue);
	}
	
	@Test(description = "Nested json attributes validation", priority = 6)
	public void nestedJsonAttributes() throws InterruptedException {
		JsonPath jsonPath = response.jsonPath();
		String nestedJsonValue = jsonPath.get("items[0].owner.type");
		System.out.println("Nested Json Value is : " + nestedJsonValue);
		Assert.assertEquals("User", nestedJsonValue);
	}
	
}
