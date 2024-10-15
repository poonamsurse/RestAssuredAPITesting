package Post;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPostRequest {
	
	@Test(priority=1)
	public void getRequest()
	{
		JSONObject jd=new JSONObject();
		jd.put("Name", "Poonam");
		jd.put("Job", "QA");
		
		baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-type", "application/json").
		contentType(ContentType.JSON).body(jd.toJSONString()).when().post().then().statusCode(201).log().all();
				
		

		
	}

}
