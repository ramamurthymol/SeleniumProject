package restAssured.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
public class RestAPI {

//	@Test
	public void get() {

		baseURI = "http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();

		given().param("name", "Automation").get("/subjects").then().statusCode(200).log().all();
		
	}

//	@Test
	public void post() {

		JSONObject obj = new JSONObject();

		obj.put("firstName", "Ravi");
		obj.put("lastName", "muvvala");
		obj.put("subjectId", 1);
//		obj.put("id", 1);

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(obj.toJSONString()).when().post("/users").
//		param("name", "Automation").get("/subjects").
				then().statusCode(201).log().all();

	}
	
//	@Test
	public void Put() {

		JSONObject obj = new JSONObject();

		obj.put("firstName", "Ravi kumar");
		obj.put("lastName", "molaklaapalli");
		obj.put("subjectId", 1);
//		obj.put("id", 1);

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(obj.toJSONString()).when().put("/users/4").
//		param("name", "Automation").get("/subjects").
				then().statusCode(200).log().all();

	}
	
//	@Test
	public void patch() {

		JSONObject obj = new JSONObject();

		obj.put("lastName", "kotapati");

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(obj.toJSONString()).when().patch("/users/4").
//		param("name", "Automation").get("/subjects").
				then().statusCode(200).log().all();

	}
	
//	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().delete("users/4").then().statusCode(200);
	}
	
}
