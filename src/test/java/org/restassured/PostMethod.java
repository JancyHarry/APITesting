package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostMethod {

	static RequestSpecification reqSpec;

	public static void main(String[] args) {

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "Application/Json");

		reqSpec = reqSpec.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}");
		Response response = reqSpec.log().all().post("https://reqres.in/api/users");

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
