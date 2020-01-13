package customintegration.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import customintegration.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_RenameChannel {
	
	String ChannelName = RestUtils.ChannelGenerator();
	public static RequestSpecification httprequest;
	public static Response response;
	/**
	 * 
	 * Preparing the Paramters for Post Request and Headers
	 * @arvij
	 * 
	 */
	
	@BeforeClass
	void get() {
       RestAssured.baseURI = "https://slack.com/api";
	   httprequest = RestAssured.given();
	   httprequest.header("Authorization"," Bearer xoxp-903411961717-905608557686-903430649616-385e71a2408f9d8fa039fc9574ffa82d");
	   httprequest.header("Content-Type","application/x-www-form-urlencoded");
	        String responseBody = response.getBody().asString();
			//Assert.assertEquals(responseBody.contains(ChannelName),true);  
	        response = httprequest.request(Method.POST,"channels.rename");
			System.out.println(responseBody);
			
	   
	}
	public void RenameChannel() {
		RestAssured.baseURI = "https://slack.com/api";
		
		httprequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();
		
		
		requestParam.put("name",ChannelName);
		requestParam.put("channel", "CS80696FM");
		httprequest.header("Authorization"," Bearer xoxp-903411961717-905608557686-903430649616-385e71a2408f9d8fa039fc9574ffa82d");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParam.toJSONString());
		response = httprequest.request(Method.POST,"channels.rename");
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

}
