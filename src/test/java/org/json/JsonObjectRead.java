package org.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonObjectRead {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader = new FileReader(
				"C:\\Users\\lenovo\\eclipse-workspace\\APITesting\\src\\test\\resources\\JSON\\Reqres.json");

		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(reader);

		JSONObject j = (JSONObject) parse;

		Object data = j.get("data");
		JSONObject j1 = (JSONObject) data;

		Object id = j1.get("id");
		System.out.println(id);
		Object email = j1.get("emai");
		System.out.println(email);
		Object fN = j1.get("first_name");
		System.out.println(fN);
		Object lN = j1.get("last_name");
		System.out.println(lN);
		Object ava = j1.get("avatar");
		System.out.println(ava);
		
		Object support = j.get("support");
		JSONObject j2 = (JSONObject) support;
		
		Object url = j2.get("url");
		System.out.println(url);
		Object txt = j2.get("text");
		System.out.println(txt);


	}

}
