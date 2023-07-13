package api.testcases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import api.pojo.VisualCrossingPojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class VisualCrossingApiNegativeValidations {
	@DataProvider(name = "cityNames")
	public static Object[] cityNames() {
		return new Object[] { "zzzz", "" };
	}
    

	// Test For Invalid CityNames
	@Test(dataProvider = "cityNames", priority = 3)
	public void validateApi(String cityName) throws IOException {

		// Get the list of cities.
		Object[] cityNames = cityNames();
		String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
		System.out.println("CityName: " + cityName);
		RestAssured.baseURI = "https://weather.visualcrossing.com/";
		Response response = given()
				.queryParam("unitGroup", "metric")
				.queryParam("key", "53CRP7PGMBPDEVMUDZUE6EK7B")
				.queryParam("contentType", "json")
				.when().get(endpoint)
				.then().extract().response();
		// Assert that the response body contains the string "Bad API Request"
		Assert.assertTrue(response.getBody().asString().contains("Bad API Request"));

		// Assert that the status code is 400
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Response time: " + response.getTime());
		System.out.println("Response ContentType: " + response.getContentType());
		// Get the response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

	}
	
	// Test For Invalid MetricGroup
	@Test(priority=4)
	public void invalidmetricgroup() throws IOException {

		String cityName = "Raichur";
		String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
		RestAssured.baseURI = "https://weather.visualcrossing.com/";
		Response response = given()
				.queryParam("unitGroup", "met")
				.queryParam("key", "53CRP7PGMBPDEVMUDZUE6EK7B")
				.queryParam("contentType", "json")
				.when().get(endpoint)
				.then().extract().response();
		// Assert that the response body contains the string "Unknown unit group id"
		Assert.assertTrue(response.getBody().asString().contains("Unknown unit group id"));

		// Assert that the status code is 500
		Assert.assertEquals(response.getStatusCode(), 500);
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Response time: " + response.getTime());
		System.out.println("Response ContentType: " + response.getContentType());
		// Get the response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
}
	
	// Test For Invalid API Key
	
	@Test(priority=5)
		
		public void invalidapikey() throws IOException {

			String cityName = "Raichur";
			String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
			String key = "123";
			RestAssured.baseURI = "https://weather.visualcrossing.com/";
			Response response = given()
					.queryParam("unitGroup", "metric")
					.queryParam("key", key)
					.queryParam("contentType", "json")
					.when().get(endpoint)
					.then().extract().response();
			System.out.println(key);
			// Assert that the response body contains the string "No account found with API key"
			Assert.assertTrue(response.getBody().asString().contains("No account found with "));

			// Assert that the status code is 401
			Assert.assertEquals(response.getStatusCode(), 401);
			System.out.println("Status code: " + response.getStatusCode());
			System.out.println("Response time: " + response.getTime());
			System.out.println("Response ContentType: " + response.getContentType());
			// Get the response body
			String responseBody = response.getBody().asString();
			System.out.println("Response Body: " + responseBody);
	}
	
	// Test For Empty API Key
	
		@Test(priority=5)
			
			public void emptyapikey() throws IOException {

				String cityName = "Raichur";
				String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
				String key = "";
				RestAssured.baseURI = "https://weather.visualcrossing.com/";
				Response response = given()
						.queryParam("unitGroup", "metric")
						.queryParam("key", key)
						.queryParam("contentType", "json")
						.when().get(endpoint)
						.then().extract().response();
				System.out.println(key);
				// Assert that the response body contains the string "No API key or session found. Please verify that your API key parameter is correct"
				Assert.assertTrue(response.getBody().asString().contains("No API key or session found. Please verify that your API key parameter is correct"));

				// Assert that the status code is 401
				Assert.assertEquals(response.getStatusCode(), 401);
				System.out.println("Status code: " + response.getStatusCode());
				System.out.println("Response time: " + response.getTime());
				System.out.println("Response ContentType: " + response.getContentType());
				// Get the response body
				String responseBody = response.getBody().asString();
				System.out.println("Response Body: " + responseBody);
		}
		
		// Test For Invalid Content Type
		
			@Test(priority=5)
				
				public void invalidContentType() throws IOException {

					String cityName = "Raichur";
					String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
					String contentType = "xml";
					RestAssured.baseURI = "https://weather.visualcrossing.com/";
					Response response = given()
							.queryParam("unitGroup", "metric")
							.queryParam("key", "53CRP7PGMBPDEVMUDZUE6EK7B")
							.queryParam("contentType", contentType)
							.when().get(endpoint)
							.then().extract().response();
					System.out.println(contentType);
					// Assert that the response body contains the string "Bad API Request:Unknown contentType"
					Assert.assertTrue(response.getBody().asString().contains("Bad API Request:Unknown contentType"));

					// Assert that the status code is 400
					Assert.assertEquals(response.getStatusCode(), 400);
					System.out.println("Status code: " + response.getStatusCode());
					System.out.println("Response time: " + response.getTime());
					System.out.println("Response ContentType: " + response.getContentType());
					// Get the response body
					String responseBody = response.getBody().asString();
					System.out.println("Response Body: " + responseBody);
			}

}
