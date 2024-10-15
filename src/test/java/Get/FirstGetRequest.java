package Get;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstGetRequest {
	
	@Test(priority=1)
	public void getRequest()
	{
		
		//https://reqres.in/api/users/2
		Response res=get("https://reqres.in/api/users/2");
		
		System.out.println(" Body :"+res.asPrettyString());
		
		System.out.println("Status Code :"+res.getStatusCode());

		
	}
	
	@Test(priority=2)
	public void Test1_Get()
	{
		Response res=get("https://reqres.in/api/users/2");
		System.out.println("Status Code :"+res.getStatusCode());
		System.out.println(" Body :"+res.getBody());
		System.out.println(" Time :"+res.getTime());
		System.out.println(" Header :"+res.getHeader("content-type"));
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2)
	public void Test2_Get()
	{
		baseURI="https://reqres.in/api/users/";
		given().queryParam("page",'2').when().get().then().statusCode(200);
	}
	
	@Test(priority=3)
	public void validationGetRequest()
	{
		//Specifying base URI
		RestAssured.baseURI="https://reqres.in/api/users/19";
		
		RequestSpecification req= RestAssured.given();
		
		Response res=req.get();
		
		int statusCode=res.getStatusCode();
		
		Assert.assertEquals(statusCode,200,"Correct status code received");
		
		String statusline=res.getStatusLine();
		
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK","Incorrect status line received");

	}
}
