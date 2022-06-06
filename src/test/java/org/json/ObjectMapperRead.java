package org.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Datum;
import com.pojo.MainPojo;
import com.pojo.Support;

public class ObjectMapperRead {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file=new File("C:\\Users\\lenovo\\eclipse-workspace\\APITesting\\src\\test\\resources\\JSON\\Emp.json");
		
		ObjectMapper mapper=new ObjectMapper();
		MainPojo readValue = mapper.readValue(file, MainPojo.class);
		int page = readValue.getPage();
		System.out.println(page);
		int per_page = readValue.getPer_page();
		System.out.println(per_page);
		int total = readValue.getTotal();
		System.out.println(total);
		int total_pages = readValue.getTotal_pages();
		System.out.println(total_pages);
		
		//data
		
		ArrayList<Datum> data = readValue.getData();
		for (Datum d : data) {
			System.out.println(d.getId());
			System.out.println(d.getEmail());
			System.out.println(d.getFirst_name());
			System.out.println(d.getLast_name());
			System.out.println(d.getAvatar());
			
		}
		
		//support
		Support support = readValue.getSupport();
		System.out.println(support.getUrl());
		System.out.println(support.getText());
	}

}
