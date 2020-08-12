package restAssured.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class rest_CRUD {

	@Test
	public void Get() {

		given().header("Content-Type", "application/json").get("https://reqres.in/api/users?page=2").then()
				.statusCode(200).body("data.id[0]", equalTo(7))
				.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias")).log().status();

	}

	@Test
	public void Post() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Kishore");
		jsonObj.put("job", "Sr.Engineer");

		System.out.println(jsonObj.toJSONString());

		given().
		header("Content-Type", "application/jason").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jsonObj.toJSONString()).when()
		.post("https://reqres.in/api/users").then()
		.statusCode(201).log().all();
	}
	
	@Test
	public void put() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Kishore");
		jsonObj.put("job", "Sr Software Engineer");

		System.out.println(jsonObj.toJSONString());

		given().
		header("Content-Type", "application/jason").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jsonObj.toJSONString()).when()
		.put("https://reqres.in/api/users/7").then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void patch() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Kishore");
		jsonObj.put("job", "Sr QA Engineer");

		System.out.println(jsonObj.toJSONString());

		given().
		header("Content-Type", "application/jason").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(jsonObj.toJSONString()).when()
		.patch("https://reqres.in/api/users/7").then()
		.statusCode(200).log().all();
	}
	
	//@Test
	public void delete() {
	
		when()
		.delete("https://reqres.in/api/users/7").then()
		.statusCode(204).log().all();
	}
	
}
