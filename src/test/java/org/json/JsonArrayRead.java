package org.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonArrayRead {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader=new FileReader("C:\\Users\\lenovo\\eclipse-workspace\\APITesting\\src\\test\\resources\\JSON\\Employee.json");
		JSONParser jsonParser=new JSONParser();
		Object parse = jsonParser.parse(reader);
		JSONObject j=(JSONObject) parse;
		Object name = j.get("name");
		System.out.println(name);
		Object email = j.get("email");
		System.out.println(email);
		Object phNo = j.get("phoneNo");
		System.out.println(phNo);
		
		Object studDetails = j.get("studDetails");
		JSONArray a=(JSONArray) studDetails;
		for (int i = 0; i < a.size(); i++) {
			Object eachStudDetails = a.get(i);
			JSONObject j2=(JSONObject) eachStudDetails;
			System.out.println(j2.get("firstName"));
			System.out.println(j2.get("course"));
			System.out.println(j2.get("address"));
		}
		
		
		
		 
	}

}
