package com.apitests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class LogintoDummyApi extends ReusableMethods{
	static Response response;
	static int userid;
	
	@BeforeMethod
	 public void setupApi() {
			RestAssured.baseURI = getBaseUri();
			}	
	@Test(priority = 1,enabled = false)
	
	public static void TC_01validlogin() {
		
		String path = "/employees";
		RestAssured.baseURI = getBaseUri()+path;
		Response response  = RestAssured.given().contentType(ContentType.JSON).get()
		.then().assertThat().statusCode(200).extract().response();
        
		System.out.println("Response = "+response.asPrettyString());
		int status = response.getStatusCode();
		Assert.assertEquals(200, status);
		String name = response.jsonPath().get("data[0].employee_name");
		System.out.println("name == " +name);
		
//capture response to pojo class
		EmployeePojo empPojo =new EmployeePojo();
		
		int id =response.jsonPath().get("data[0].id");
		String name1 = response.jsonPath().get("data[0].employee_name");
		int sal = response.jsonPath().get("data[0].employee_salary");
		int age = response.jsonPath().get("data[0].employee_age");
		
				
		empPojo.setId(id);
		empPojo.setEmpName(name1);
		empPojo.setSalary(sal);
		empPojo.setAge(age);
		
		System.out.println(empPojo.toString());
	
		int noofrecords = response.jsonPath().get("data.size()");
		System.out.println("Total number of records = " + noofrecords);
		System.out.println("\n");

	}
	
	
//Testcase 2
	@Test(priority = 2, enabled = false)
	public static void TC_02createdata() {
	   		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
	
		Response response  = RestAssured.given().contentType(ContentType.JSON)
.body("{\"id\":1000,\"employee_name\":\"Indira Gandhi\",\"employee_salary\":67500,\"employee_age\":50}")
				.when()
				.post("/create");
		         response.then().statusCode(200);
		         response.prettyPrint();
		         
		System.out.println("Status code ----->"+response.getStatusCode());
		
		
		int userid1 = response.body().jsonPath().getInt("data.id");
        System.out.println("userid = "+userid1);
			
		System.out.println("*****************");
		
		int id2 = response.body().jsonPath().getInt("data.id");
		String name2 = response.body().jsonPath().getString("data.employee_name");
		int sal2 = response.jsonPath().getInt("data.employee_salary");
		int age2 = response.jsonPath().getInt("data.employee_age");
		
		
		EmployeePojo empPojo1 = new EmployeePojo();
		empPojo1.setId(id2);
		empPojo1.setEmpName(name2);
		empPojo1.setSalary(sal2);
		empPojo1.setAge(age2);
		
		//print the pojo class to console
		System.out.println(empPojo1.toString());
			
	}
	
	
	
	//Test case 3	
	@Test(priority = 4, enabled=false)

	public void deletedata() {
			
		int userid = 9848;
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		System.out.println("user id = "+userid);
		Response response  = RestAssured.given()
				.when()
				 .delete("/delete/9848").then().extract().response();
		System.out.println("-----"+response.getStatusCode());
		
	    response.then().statusCode(200);
		response.prettyPrint();
		
			
	}
	
	//Test case 4
	
	@Test(priority = 4, enabled=false)
	
	public void invalidDelete() {
RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		System.out.println("user id = "+userid);
		Response response  = RestAssured.given()
				.when()
				 .delete("/delete/0").then().extract().response();
		System.out.println("-----"+response.getStatusCode());
	    response.then().statusCode(400);
		response.prettyPrint();
		//response.then().assertThat().statusCod;
		
		
		System.out.println("delete response ="+response);	
			
	}
	
	//test case 5
	
	
	@Test(priority = 4, enabled=true)
	
	public void getEmployeedata() {
	
RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
				
Response response  = RestAssured.given().contentType(ContentType.JSON)
						 .when()
                          .get("/employee/2");
                          response.then().statusCode(200);
                          response.prettyPrint();
			
	}
	
	

}
