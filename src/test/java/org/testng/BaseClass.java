package org.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	static RequestSpecification reqSpec;
	static Response response;
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void basicAuth(String username, String Password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, Password);
	}

	public void addPayload(String body) {
		reqSpec = reqSpec.body(body);
	}
	public void addPayload(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public Response requestType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public ResponseBody getResBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}

	public String getAsString(Response response) {
		String asString = getResBody(response).asString();
		return asString;
	}

	public String getAsPrettyString(Response response) {
		String asPrettyString = getResBody(response).asPrettyString();
		return asPrettyString;
	}
	public String getProperty(String key) throws IOException {
		FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		Properties properties=new Properties();
		properties.load(stream);
		Object object = properties.get(key);
		String s=(String) object;
		return s;
	}
	public String jsonPath(String key ,Response response) {
		JsonPath jsonPath=getResBody(response).jsonPath();
		Object object = jsonPath.get(key);
		String s=(String) object;
		return s;
		
	}
	public int jsonPathNum(String key ,Response response) {
		JsonPath jsonPath=getResBody(response).jsonPath();
		Object object = jsonPath.get(key);
		Integer n=(Integer) object;
		return n;
		
	}

}
