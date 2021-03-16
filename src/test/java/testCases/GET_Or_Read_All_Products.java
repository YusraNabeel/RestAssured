package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class GET_Or_Read_All_Products {

	@Test
	public void read_All_Products() {
//	RestAssured.baseURI();
		Response response =
		(Response) given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json; charset=UTF-8")
		.when()
	.get("/read.php")
	.then()
//	.statusCode(200)
//	.header("Content-Type", "application/json; charset=UTF-8")
	.extract()
	.response();
	
		int stausCode = response.getStatusCode();
		System.out.println("Status Code:" + stausCode);
		Assert.assertEquals(stausCode, 200);
		
		String responseBody = response.asString();
		System.out.println(responseBody);
	}		
}
