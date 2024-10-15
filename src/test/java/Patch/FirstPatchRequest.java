package Patch;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FirstPatchRequest {

	@Test(priority=1)
	public void putRequest()
	{
		JSONObject jd=new JSONObject();
		jd.put("Name", "Guru");
		jd.put("Job", "Engineer");
		
		baseURI="https://reqres.in/api/users/201";
		RestAssured.given().
		              header("Content-type", "application/json").contentType(ContentType.JSON).body(jd.toJSONString()).
		            when().
		               patch().
		            then().
		                statusCode(200).log().all();
				
		

		
	}

}
