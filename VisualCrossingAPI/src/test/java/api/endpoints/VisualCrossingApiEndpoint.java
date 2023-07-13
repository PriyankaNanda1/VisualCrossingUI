package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.pojo.VisualCrossingPojo;

public class VisualCrossingApiEndpoint {



	public static VisualCrossingPojo getApi() {
		// public static void main(String[] args) {

		String cityName = "Raichur";
		String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
		RestAssured.baseURI = "https://weather.visualcrossing.com/";
		VisualCrossingPojo pojo = given()
				.queryParam("unitGroup", "metric")
				.queryParam("key", "53CRP7PGMBPDEVMUDZUE6EK7B")
				.queryParam("contentType", "json")
				.when().get(endpoint)
				.as(VisualCrossingPojo.class);
		return pojo;
	}
    
	//Test for Valid CityName
	@Test(priority = 2)
	public void ValidateStatusCode() throws IOException {
		String cityName = "Raichur";
		String endpoint = "VisualCrossingWebServices/rest/services/timeline/" + cityName;
		RestAssured.baseURI = "https://weather.visualcrossing.com/";
		//GET request to the API
		Response response = given()
				.queryParam("unitGroup", "metric")
				.queryParam("key", "53CRP7PGMBPDEVMUDZUE6EK7B")
				.queryParam("contentType", "json")
				.when().get(endpoint)
				.then().extract().response();
		// Assert that the response body contains the string "Raichur"
		Assert.assertTrue(response.getBody().asString().contains(cityName));

		// Assert that the status code is 200
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Response time: " + response.getTime());
		System.out.println("Response ContentType: " + response.getContentType());
		// Get the response body
		String responseBody = response.getBody().asString();

        // Create a file to store the response
        String path = System.getProperty("user.dir");
        File dir = new File(path + "/ApiResponses");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(path + "/ApiResponses/Raichur.txt");
        // Write the response to the file
        FileWriter writer = new FileWriter(file);
        writer.write(responseBody);
        writer.close();
	}

}
