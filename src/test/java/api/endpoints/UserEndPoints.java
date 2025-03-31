package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given()
				.contentType(ContentType.JSON) // Set request content type as JSON
				.accept(ContentType.JSON) // Expect JSON response
				.body(payload) // Attach user data (payload)
				
				.when()
				.post(Routes.post_url); // Send a POST request to create a user

		return response;
	}

	public static Response readUser(String userName) {
		Response response = given()
				.pathParam("username", userName) // Replaces `{username}` in the URL with actual
																	// userName
				.when()
				.get(Routes.get_url); // Send a GET request to fetch user details

		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given()
				.contentType(ContentType.JSON) // Request content type is JSON
				.accept(ContentType.JSON) // Expect JSON response
				.pathParam("username", userName) // Set path parameter `{username}`
				.body(payload) // Send updated user details in the request body
				
				.when()
				.put(Routes.update_url); // Send a PUT request to update user details

		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given()
				.pathParam("username", userName) // Set path parameter `{username}`
				
				.when()
				.delete(Routes.delete_url); // Send a DELETE request to remove the user

		return response;
	}
}
