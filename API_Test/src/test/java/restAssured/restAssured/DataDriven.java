package restAssured.restAssured;

import org.json.simple.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import groovyjarjarpicocli.CommandLine.Parameters;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDriven extends testData {

	// @Test(dataProvider = "DataUsers")
	public void post(String firstName, String lastName, int subjectId) {

		JSONObject obj = new JSONObject();

		obj.put("firstName", firstName);
		obj.put("lastName", lastName);
		obj.put("subjectId", subjectId);

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/jason").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(obj.toJSONString()).when().post("/users").
//		param("name", "Automation").get("/subjects").
				then().statusCode(201).log().all();

	}

//	@Test(dataProvider = "DeleteUser")
	public void delete(int userId) {

		baseURI = "http://localhost:3000/";

		when().delete("users/" + userId).then().statusCode(200);
	}

	@Parameters({ "userId" }) 
	@Test
	public void delete_Params(int userId) {

		baseURI = "http://localhost:3000/";

		when().delete("users/" + userId).then().statusCode(200);
	}

}
