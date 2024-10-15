package Delete;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FirstDeleteRequest {

	@Test(priority=1)
	public void putRequest()
	{
		
		baseURI="https://reqres.in/api/users/201";
		RestAssured.given().
		  
		            when().
		               delete().
		            then().
		                statusCode(204);
				
		

		
	}

}
