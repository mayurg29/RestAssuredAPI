package com.bl.qa.restAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Spotify_API_test {
	public String token;
	public String uri = "https://api.spotify.com/v1";
	public String playlist_id = "5I3NnN3EIdgnGpCGw0QbSr";
	
	@BeforeTest
	public void getToken() {
		token = "Bearer BQC9mSWcvNEi39XWvcQNuJJbUkN59GXWJhc6cgxxPpsJfvsoZh8gnUdROkXZahMBGez3QfB2niwT9pn2zRhXvkn6rMMaSpPSswtaOaD3LExmYXeUJzao2pmohybXd_kcPM85u1vC11neV67m-mryGoj57zCPL9WuebMmSs3brpMyVE0Fn1Tuw7EJ_Cgch9P_ayW0auzf1Hz_J3u2ZHS3OTUTV_hPJdWtj8nv3bw7KXpZtYnLhDLc50ZFssmYFzjR";
	}
	
	/**
	 * Getting current user profile using GET method 
	 */
	@Test
	public void getCurrentUserProfile() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.header("Authorization", token)
							.get("/me");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Getting user profile by user id using GET method
	 */
	@Test
	public void getUserProfile() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.header("Authorization", token)
							.get("/users/31uqgedzv7jp7vocqzffgcy4b4hq");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Searching for tracks, artists, albums using GET method
	 */
	@Test
	public void searchForItem() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.header("Authorization", token)
							.params("q", "Selena Gomez", "type", "track", "limit", "5", "market", "IN")
							.get("/search");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Creating a new playlist using POST method
	 */
	@Test
	public void createPlaylist() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.contentType(ContentType.JSON)
							.header("Authorization", token)
							.body("{\r\n"
								+ "\"name\": \"CQA_108\",\r\n"
								+ "\"description\": \"Sample\",\r\n"
								+ "\"public\": false\r\n"
								+ "}")
							.post("/users/31uqgedzv7jp7vocqzffgcy4b4hq/playlists");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Adding tracks to playlist using POST method
	 */
	@Test
	public void addItemsToPlaylist() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.contentType(ContentType.JSON)
							.header("Authorization", token)
							.body("{\"uris\": [\"spotify:track:06KyNuuMOX1ROXRhj787tj\"]}")
							.post("/playlists/" + playlist_id +"/tracks");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Getting current user's playlists using GET method
	 */
	@Test
	public void getCurrentUserPlaylists() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.header("Authorization", token)
							.get("/me/playlists");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Getting playlist items using GET method
	 */
	@Test
	public void getPlaylistItems() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.header("Authorization", token)
							.params("market", "IN")
							.get("/playlists/" + playlist_id +"/tracks");
		System.out.println(response.asPrettyString());
	}
	
	/**
	 * Removing items from playlist using DELETE method
	 */
	@Test
	public void removePlaylistItems() {
		RestAssured.baseURI = uri;
		Response response = RestAssured.given()
							.contentType(ContentType.JSON)
							.header("Authorization", token)
							.body("{\"tracks\": [{\"uri\": \"spotify:track:06KyNuuMOX1ROXRhj787tj\"}]}")
							.delete("/playlists/" + playlist_id +"/tracks");
		System.out.println(response.asPrettyString());
	}
}	