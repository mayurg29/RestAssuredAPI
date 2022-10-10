package com.bl.qa.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonServerApiTest {
	public String uri = "http://localhost:3000/users";
	
	/**
	 * Method 1 : Getting single user using GET method
	 */
	@Test
	public void getSingleUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/1");
		System.out.println("\nGet single user:"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime() 
				 		 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method 2 : Getting all users using GET method
	 */
	@Test
	public void getUsers() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		System.out.println("\nGet users:"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime() 
				 		 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method 3 : Creating user using POST method
	 */
	@Test
	public void createUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\r\n"
				   		+ "\"id\": 4,\r\n"
				   		+ "\"firstName\": \"Elon\",\r\n"
				   		+ "\"lastName\": \"Musk\",\r\n"
				   		+ "\"Phone\": \"7687675445\",\r\n"
				   		+ "\"Email\": \"elonmusk@gmail.com\"\r\n"
				   		+ "}");
		
		Response response = httpRequest.post();
		System.out.println("\nCreate user:"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime() 
				 		 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method 4 : Updating user using PUT method
	 */
	@Test
	public void updateUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\r\n"
				   		+ "\"id\": 1,\r\n"
				   		+ "\"firstName\": \"Jeff\",\r\n"
				   		+ "\"lastName\": \"Bezos\",\r\n"
				   		+ "\"Phone\": \"8789867643\",\r\n"
				   		+ "\"Email\": \"jeffbez@gmail.com\"\r\n"
				   		+ "}");
		
		Response response = httpRequest.put("/1");
		System.out.println("\nUpdate user (PUT):"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime() 
				 		 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method 5 : Deleting user using DELETE method
	 */
	@Test
	public void deleteUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/4");
		System.out.println("\nDelete user:"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime());
	}
	
	/**
	 * Method 6 : Updating user using PATCH method
	 */
	@Test
	public void updateUser_Patch() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\"Email\": \"mark_z@facebook.com\"}");
		
		Response response = httpRequest.patch("/3");
		System.out.println("\nUpdate user (PATCH):"
				 		 + "\n Status Code: " + response.getStatusCode() 
				 		 + "\n Response Time: " + response.getTime() 
				 		 + "\n Response Body: " + response.asPrettyString());
	}
}