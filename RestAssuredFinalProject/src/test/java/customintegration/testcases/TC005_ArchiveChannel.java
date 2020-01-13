package customintegration.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import customintegration.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TC005_ArchiveChannel {

	/**
	 * 
	 * Preparing the Paramters for Post Request and Headers
	 * @arvij
	 * 
	 */
	

		
		String ChannelName = RestUtils.ChannelGenerator();
		public static RequestSpecification httprequest;
		public static Response response;
		
		@BeforeClass
		void createChannel() {
			RestAssured.baseURI = "https://slack.com/api";
			
			httprequest = RestAssured.given();
			JSONObject requestParam = new JSONObject();
			
			requestParam.put("channel", "CSKDHJ493");
			httprequest.header("Authorization"," Bearer xoxp-903411961717-905608557686-903430649616-385e71a2408f9d8fa039fc9574ffa82d");
			httprequest.header("Content-Type","application/json");
			httprequest.body(requestParam.toJSONString());
			response = httprequest.request(Method.POST,"channels.archive");
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
	  @Test	

		void CheckStatusCode() {
			Assert.assertEquals(response.getStatusCode(),200);
			JsonPath jsnPath = response.jsonPath();
			String empId = jsnPath.get("ok");
			
			
		}
	    
	  /*
		  * Validating the Response Status for the above request
		  * @arvij
		  * 
		  */
	  @Test
	  void ValidateArchive() {
		 
		 
			Assert.assertEquals(response.getStatusCode(),200);
			JsonPath jsnPath = response.jsonPath();
			String archive = jsnPath.get("ok");
			
			
		
		}
	@AfterClass
	  void EndTestCase() {
		System.out.println("S the Followig TestCases");
	   }
	

}
