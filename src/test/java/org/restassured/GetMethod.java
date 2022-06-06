package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetMethod {

	static RequestSpecification reqSpec;

	public static void main(String[] args) {

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "Application/Json");
		// reqSpec = reqSpec.param("page", "2");

		Response response = reqSpec.log().all().get("https://reqres.in/api/users?page=2");
		int statusCode = response.getStatusCode();
		System.out.println("ResponseCode: "+statusCode);

		ResponseBody body = response.getBody();
		
		//asString print unallignment
//		String asString = body.asString();
//		System.out.println(asString);
		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);

	}

}
