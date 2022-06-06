package org.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import test.pojo.AddAddress_Input_Pojo;
import test.pojo.AddAddress_Output_Pojo;
import test.pojo.DeleteAddress_Input_Pojo;
import test.pojo.DeleteAddress_Output_Pojo;
import test.pojo.GetAddress_Output_Pojo;
import test.pojo.Login_Output_Pojo;
import test.pojo.UpdateAddress_Input_Pojo;
import test.pojo.UpdateAddress_Output_pojo;

public class MainClass extends BaseClass {
	String logToken;
	 String address_Id;

	@Test(priority = 1)
	public void login() throws IOException {
		addHeader("Content-Type", "application/json");
		basicAuth(getProperty("username"), getProperty("password"));
		Response response = requestType("POST", Endpoints.LOGIN);
		Login_Output_Pojo login_output_pojo = response.as(Login_Output_Pojo.class);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(login_output_pojo.getMessage(), "Login successfully", "Successfully login");
		logToken = login_output_pojo.getData().getLogtoken();
		System.out.println(logToken);
	}

	 @Test(priority = 2)
	 public void createAddress() {
	 List<Header> header = new ArrayList<>();
	 Header h1 = new Header("Content-Type", "application/json");
	 Header h2 = new Header("Authorization", "Bearer "+logToken);
	 header.add(h1);
	 header.add(h2);
	 Headers headers = new Headers(header);
	 addHeaders(headers);
	 AddAddress_Input_Pojo addAddress_input_pojo=new AddAddress_Input_Pojo("Jancy", "Harry", "879065432", "KV apt", 65,
			34, 116, "678909", "Chennai","Home");
	 
	 addPayload(addAddress_input_pojo);
	 Response response = requestType("POST", Endpoints.ADD_ADDRESS);
	 System.out.println(getResponseCode(response));
	 AddAddress_Output_Pojo addAddress_Output_pojo=response.as(AddAddress_Output_Pojo.class);
	 System.out.println(getAsPrettyString(response));
	 int address_id=addAddress_Output_pojo.getAddress_id();
	 address_Id=Integer.toString(address_id);
	 System.out.println(address_id);
	 Assert.assertEquals(addAddress_Output_pojo.getMessage(), "Address added successfully", "Verify Address added Successfully");
	 
	 }
	
	 @Test(priority=3)
	 public void updateAddress() {
	 List<Header> header = new ArrayList<>();
	 Header h1 = new Header("Content-Type", "application/json");
	 Header h2 = new Header("Authorization", "Bearer "+logToken);
	 header.add(h1);
	 header.add(h2);
	 Headers headers = new Headers(header);
	 addHeaders(headers);
	
	 UpdateAddress_Input_Pojo updateAddress_input_pojo=new UpdateAddress_Input_Pojo(address_Id, "Jeni", "Harry", "879065432",
				"Gres", 33, 3378, 101, "678909", "Chennai","Home");
	 addPayload(updateAddress_input_pojo);
	 Response response = requestType("PUT", Endpoints.UPDATE_ADDRESS);
	 System.out.println(getResponseCode(response));
	 UpdateAddress_Output_pojo updateAddress_output_pojo=response.as(UpdateAddress_Output_pojo.class);
	 System.out.println(getAsPrettyString(response));
	 Assert.assertEquals(updateAddress_output_pojo.getMessage(), "Address updated successfully","Verify updated address successfully");
	 }
	
	 @Test(priority=4)
	 public void getAddress() {
	 List<Header> header = new ArrayList<>();
	 Header h1 = new Header("Contenth-Type", "application/json");
	 Header h2 = new Header("Authorization", "Bearer "+logToken);
	 header.add(h1);
	 header.add(h2);
	 Headers headers = new Headers(header);
	 addHeaders(headers);
	 Response response = requestType("GET", Endpoints.GET_ADDRESSES);
	 System.out.println(getResponseCode(response));
	 GetAddress_Output_Pojo getAddress_output_pojo=response.as(GetAddress_Output_Pojo.class);
	 System.out.println(getAsPrettyString(response));
	 Assert.assertEquals(getAddress_output_pojo.getMessage(), "OK");
	
	 }
	 @Test(priority=5)
	 public void deleteAddress() {
	 List<Header> header = new ArrayList<>();
	 Header h1 = new Header("Content-Type", "application/json");
	 Header h2 = new Header("Authorization", "Bearer "+logToken);
	 header.add(h1);
	 header.add(h2);
	 Headers headers = new Headers(header);
	 addHeaders(headers);
	 DeleteAddress_Input_Pojo deleteAddress_input_pojo=new DeleteAddress_Input_Pojo(address_Id);
	 addPayload(deleteAddress_input_pojo);
	 Response response = requestType("DELETE", Endpoints.DELETE_ADDRESSES);
	 System.out.println(getResponseCode(response));
	 DeleteAddress_Output_Pojo deleteAddress_output_pojo=response.as(DeleteAddress_Output_Pojo.class);
	 System.out.println(getAsPrettyString(response));
	 Assert.assertEquals(deleteAddress_output_pojo.getMessage(), "Address deleted successfully","Verify address deleted successfully");
	
	 }

}
