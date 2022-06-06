package org.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.pojowrite.DatumWrite;
import org.pojowrite.Root;
import org.pojowrite.SupportWrite;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperWrite {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File file=new File("C:\\Users\\lenovo\\eclipse-workspace\\APITesting\\src\\test\\resources\\JSON\\LinkUsers.json");
		
		ObjectMapper mapper=new ObjectMapper();
		
		//Data
		ArrayList<DatumWrite> data=new ArrayList<DatumWrite>();
		DatumWrite d1=new DatumWrite(7, "michael.lawson@reqres.in","Michael","Lawson","https://reqres.in/img/faces/7-image.jpg");
		DatumWrite d2=new DatumWrite(8, "lindsay.ferguson@reqres.in", "Lindsay","Ferguson","https://reqres.in/img/faces/8-image.jpg");
		DatumWrite d3=new DatumWrite(9, "tobias.funke@reqres.in","Tobias","Funke","https://reqres.in/img/faces/9-image.jpg");
		DatumWrite d4=new DatumWrite(10, "byron.fields@reqres.in","Byron","Fields","https://reqres.in/img/faces/10-image.jpg");
		DatumWrite d5=new DatumWrite(11,  "george.edwards@reqres.in","George","Edwards","https://reqres.in/img/faces/11-image.jpg");
		DatumWrite d6=new DatumWrite(12, "rachel.howell@reqres.in","Rachel","Howell","https://reqres.in/img/faces/12-image.jpg");
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);
		data.add(d6);	
		
		//Support
		SupportWrite support=new SupportWrite("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
		
		Root r=new Root(2, 6, 12, 2, data, support);
		
		mapper.writeValue(file, r);
	}

}
