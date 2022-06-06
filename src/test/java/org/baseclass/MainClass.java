package org.baseclass;

import java.io.IOException;

import io.restassured.response.Response;

public class MainClass  extends BaseClass{
	
	public void login() throws IOException {
		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyvalue("username"), getPropertyvalue("password"));
		Response response = requestType("POST", Endpoints.LOGIN);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		String bodyprettyAsString = getBodyprettyAsString(response);
		System.out.println(bodyprettyAsString);
	}

	public static void main(String[] args) throws IOException {
		MainClass mc=new MainClass();
		mc.login();
		
	}

}
