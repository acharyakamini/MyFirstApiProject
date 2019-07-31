package com.api.automation;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudOperation {


	@Test public void getCall() {

		Response resp =  RestAssured.get("http://localhost:8080/employee");
		int statusCode = resp.getStatusCode();
		System.out.println(""+statusCode);
		Assert.assertEquals(statusCode, 200);

	}
	@Test 
	public void postCall() throws JSONException { 
		RestAssured.baseURI = "http://localhost:8080/employee"; 
		RequestSpecification request =RestAssured.given(); 
		JSONObject json = new JSONObject(); 
		json.put("id","106");
		json.put("name", "Jerken"); 
		json.put("department", "Tech");
		request.header("Content-Type", "application/json");
		request.body(json.toString());
		Response response = request.post("");
		System.out.println("Response Body ---->"+response.asString());
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);

	}
	 @Test 
	  public void putCall() throws JSONException { 
	RestAssured.baseURI = "http://localhost:8080/employee";
	RequestSpecification request = RestAssured.given(); 
	request.header("Content-Type", "application/json");
	
	 JSONObject json = new JSONObject();
	 json.put("id", "106"); 
	 json.put("name", "Jerken");
	 json.put("department", "Finance");
	 
	  request.body(json.toString());
	 
	 Response response = request.put("/106");
	
	  int code = response.getStatusCode();
	  
	 System.out.println("response code " + code); 
	 Assert.assertEquals(code, 200);
	  
	 }


	
	 @Test public void deleteCall() { 
	RequestSpecification request = RestAssured.given();
	Response response = request.delete("http://localhost:8080/employee/106");
	int code = response.getStatusCode(); Assert.assertEquals(code, 200);
	 
	 }
	 


	
	 
	 

}
