package com.mop.qa.pageobject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.mop.qa.testbase.ServiceBase;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class SampleApiPage {

	ServiceBase restService = new ServiceBase();

	public String userNameStr = null;
	public String passwordStr = null;
	public String swidStr = null;
	public String tokenStr = null;
	public String guidStr = null;

	public String getAPIKey() throws Exception {

		Map<String, String> headerParams = new HashMap<>();

		String API = "https://stage.profilesvc4.nap7.wdpro.disney.com/profile-service/v4/clients/WDPRT-DISNEYWORLD.GC-STAGE/api-key";
		String requestType = "POST";

		headerParams.put("Connection", "keep-alive");
		headerParams.put("X-Conversation-Id", "BeepBeep123456");
		headerParams.put("Content-Type", "application/json");

		// Functional API Call for API Creation
		Response response = restService.executeAPI(requestType, API, "", headerParams, "Generate API key");

		return response.getHeader("api-key");

	}

	public void getWeatherDetails(String apiURL, String request_Type, String cityName) throws Exception {
		Map<String, String> headerParams = new HashMap<>();
		String API = apiURL + "/" + cityName;
		String requestType = request_Type;

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, API, "", headerParams, "Get Weathet details of City ");

		restService.HttpStatusCodeValidation(response);

		JSONObject createTestResp = new JSONObject(response.body().prettyPrint());
		if (createTestResp.getString("City").contains(cityName)) {
			ExtentUtility.getTest().log(LogStatus.PASS, " City Details Validated ",
					" City Details Validated Successfully");
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, " City Details Validated ",
					" City Details Validated UnSuccessfully");
		}
		System.out.println("Temperature of " + cityName + " : " + createTestResp.getString("Temperature"));
	}

	public void getCircuitDetails(String apiURL, String request_Type) throws Exception {
		Map<String, String> headerParams = new HashMap<>();
		String requestType = request_Type;

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, apiURL, "", headerParams,
				"Get Circuit details of City ");

		restService.HttpStatusCodeValidation(response);

		JSONObject createTestResp = new JSONObject(response.body().prettyPrint());

		System.out.println("Temperature of Circuit details : " + createTestResp.getString("circuitId"));
	}

	public void createUser(String apiURL, String request_Type, String requestFilePath, String userName)
			throws Exception {
		Map<String, String> bodyParameters = new HashMap<>();
		Map<String, String> headerParams = new HashMap<>();

		String requestType = request_Type;

		headerParams.put("Content-Type", "application/json");

		bodyParameters.put("FirstName", userName);
		bodyParameters.put("LastName", "Jill");
		bodyParameters.put("UserName", userName);
		bodyParameters.put("Password", userName);
		bodyParameters.put("Email", userName + "@ngetestmail.com");

		String body = restService.generateRequestBody(requestFilePath, bodyParameters);

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, apiURL, body, headerParams,
				" Register Guest With Details");

		restService.HttpStatusCodeValidation(response);

		JSONObject createTestResp = new JSONObject(response.body().prettyPrint());
		try {
			if (createTestResp.getString("SuccessCode").contains("OPERATION_SUCCESS")) {
				ExtentUtility.getTest().log(LogStatus.PASS, " User DEtails Added ", " User Details Added Successfully");
			} else {
				ExtentUtility.getTest().log(LogStatus.FAIL, " User DEtails Added ",
						" User Details Added UnSuccessfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, " User Details Added ", " User Details Added UnSuccessfully");
			throw new Exception(e.getMessage());
		}

	}

	public void deleteUser(String apiURL, String request_Type, String requestFilePath, String userName)
			throws Exception {
		Map<String, String> bodyParameters = new HashMap<>();
		Map<String, String> headerParams = new HashMap<>();

		String requestType = request_Type;

		headerParams.put("Content-Type", "application/json");

		bodyParameters.put("FirstName", userName);
		bodyParameters.put("LastName", "Jill");
		bodyParameters.put("UserName", userName);
		bodyParameters.put("Password", userName);
		bodyParameters.put("Email", userName + "@ngetestmail.com");

		String body = restService.generateRequestBody(requestFilePath, bodyParameters);

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, apiURL, body, headerParams,
				" Register Guest With Details");

		restService.HttpStatusCodeValidation(response);

		/*
		 * JSONObject createTestResp = new JSONObject(response.body().prettyPrint());
		 * try {
		 * if(createTestResp.getString("SuccessCode").contains("OPERATION_SUCCESS")) {
		 * ExtentUtility.getTest().log(LogStatus.PASS, " User DEtails Added ",
		 * " User Details Added Successfully"); }else {
		 * ExtentUtility.getTest().log(LogStatus.FAIL, " User DEtails Added ",
		 * " User Details Added UnSuccessfully"); } } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace();
		 * ExtentUtility.getTest().log(LogStatus.FAIL, " User Details Added ",
		 * " User Details Added UnSuccessfully"); throw new Exception(e.getMessage()); }
		 */

	}

	public String getToken() throws Exception {

		Map<String, String> headerParams = new HashMap<>();

		String API = "https://stg.authorization.go.com/token";
		String requestType = "POST";

		headerParams.put("Connection", "keep-alive");
		headerParams.put("Content-Type", "application/x-www-form-urlencoded");

		String body = "grant_type=password&client_id=TPR-DLR_2016.IOS-STAGE&username=" + userNameStr + "&password="
				+ passwordStr + "&scope=RETURN_ALL_CLIENT_SCOPES";

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, API, body, headerParams, "Generate Token");

		// Response File parse

		// ************** Validation Using Other API ************************//

		// Get AccessToken for Above Created Account via API
		JSONObject createTestResp = new JSONObject(response.body().prettyPrint());
		String accessToken = createTestResp.getString("access_token");
		tokenStr = accessToken;
		return accessToken;

	}

	public void activateProfile() throws Exception {

		Map<String, String> headerParams = new HashMap<>();

		String API = "http://guestkeys-stage.wdpr.disney.com:8080/keyring/guest/id;swid=%7B" + swidStr + "%7D/profile";
		String requestType = "GET";

		headerParams.put("Connection", "keep-alive");
		headerParams.put("Content-Type", "application/json");
		headerParams.put("X-Conversation-Id", "BeepBeep123456");
		headerParams.put("Authorization", "BEARER " + getToken());
		headerParams.put("Accept", "application/json;apiversion=1");
		headerParams.put("X-Disney-Internal-PoolOverride-WDPROAPI", "XXXXXXXXXXXXXXXXXXXXXXXXX");

		String body = "grant_type=password&client_id=TPR-DLR_2016.IOS-STAGE&username=" + userNameStr + "&password="
				+ passwordStr + "&scope=RETURN_ALL_CLIENT_SCOPES";

		// Functional API Call for Account Creation
		Response response = restService.executeAPI(requestType, API, body, headerParams, "Activate Created Profile");

		// Response File parse

		// ************** Validation Using Other API ************************//

		// Get Account ID for Above Created Account via API
		JSONObject createTestResp = new JSONObject(response.body().prettyPrint());
		restService.HttpStatusCodeValidation(response);

	}

}
