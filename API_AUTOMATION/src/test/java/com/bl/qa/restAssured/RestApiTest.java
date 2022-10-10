package com.bl.qa.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiTest {
	String uri = "https://reqres.in/api";
	
	/**
	 * Method : Getting single user using GET method
	 */
	@Test
	public void getSingleUser() {	
		
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get("/users/1");
		System.out.println("\nGet single user:"
						 + "\n Status Code: " + response.getStatusCode() 
					 	 + "\n Response Time: " + response.getTime() 
					   	 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method : Getting list of users using GET method
	 */
	@Test
	public void listUsers() {	
		
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get("/users");
		System.out.println("\nList of users:"
						 + "\n Status Code: " + response.getStatusCode() 
					 	 + "\n Response Time: " + response.getTime() 
					   	 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method : Creating user using POST method
	 */
	@Test
	public void createUser() {		
		
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\"name\": \"morpheus\",\"job\": \"leader\"}");
		
		Response response = httpRequest.post("/users/2");
		System.out.println("\nCreate user:"
						 + "\n Status Code: " + response.getStatusCode() 
						 + "\n Response Time: " + response.getTime() 
						 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method : Updating user using PUT method
	 */
	@Test
	public void updateUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\"name\": \"morpheus\",\"job\": \"Engineer\"}");
		
		Response response = httpRequest.put("/users/2");
		System.out.println("\nUpdate user (PUT):"
				 		 + "\n Status Code: " + response.getStatusCode() 
						 + "\n Response Time: " + response.getTime() 
						 + "\n Response Body: " + response.asPrettyString());
	}
	
	/**
	 * Method : Deleting user
	 */
	@Test
	public void deleteUser() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.delete("/users/2");
		System.out.println("\nDelete user:"
				 		 + "\n Status Code: " + response.getStatusCode() 
						 + "\n Response Time: " + response.getTime());
	}
	
	/**
	 * Method : Updating user using PATCH method
	 */
	@Test
	public void updateUser_Patch() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON)
				   .body("{\"name\": \"morpheus\",\"job\": \"Developer\"}");
		
		Response response = httpRequest.patch("/users/2");
		System.out.println("\nUpdate user (PATCH):"
				 		 + "\n Status Code: " + response.getStatusCode() 
						 + "\n Response Time: " + response.getTime() 
						 + "\n Response Body: " + response.asPrettyString());
	}
}