package customintegration.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import customintegration.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GETChannel {
	
	String ChannelName = RestUtils.ChannelGenerator();
	public static RequestSpecification httprequest;
	public static Response response;
	/**
	 * 
	 * Preparing the Paramters for Post Request and Headers
	 * @arvij
	 * 
	 */
	
	@BeforeTest
	void get() {
	       RestAssured.baseURI = "https://slack.com/api";
		   httprequest = RestAssured.given();
		   httprequest.header("Authorization"," Bearer xoxp-903411961717-905608557686-903430649616-385e71a2408f9d8fa039fc9574ffa82d");
		   httprequest.header("Content-Type","application/x-www-form-urlencoded");
		   response = httprequest.request(Method.GET,"channels.list");
				}
	/*
	 * Getting the Response body of the After the Post Request and Print the value of Response
	 * @arvij
	 * 
	 */
	@Test	 
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		//Assert.assertEquals(responseBody.contains(ChannelName),true);  
		System.out.println(responseBody);
	}
	
	/*
	  * Validating the Response Status for the above request
	  * @arvij
	  * 
	  */
  @Test	

	void CheckStatusCode() {
		Assert.assertEquals(response.getStatusCode(),200);
	}
  
  @Test 
  void ValidatingArchive() {
	  
  }

}
