package com.mop.qa.pageobject;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

public class Flight_Reservation_Page extends PageBase {

	public Flight_Reservation_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public Flight_Reservation_Page(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	//PageFactory
	@FindBy(xpath = "//*[@id='inputName']")
	private WebElement name_Text;
	
	@FindBy(xpath = "//*[@id='address']")
	private WebElement address_Text;
	
	@FindBy(xpath = "//*[@id='city']")
	private WebElement city_Text;

	@FindBy(xpath = "//*[@id='state']")
	private WebElement state_Text;
	
	@FindBy(xpath = "//*[@id='zipCode']")
	private WebElement zipCode_Text;
	
	@FindBy(xpath = "//*[@id='rememberMe']")
	private WebElement rememberMe_CheckBox;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement purchaseFlight_Button;
	
	public void fillForm(String value) throws Exception {
		try {
			 enterText(name_Text,"Admin","First Name");
			 enterText(address_Text,"Mepz","Address");
			 enterText(city_Text,"Chennai","City");
			 enterText(state_Text,"Tamilnadu","State");
			 enterText(zipCode_Text,"600001","ZipCode");
			 click(rememberMe_CheckBox,"Remember Me");
			 click(purchaseFlight_Button,"Purchase Flights");
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.PASS, value + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, value + " not successful;",
					e.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
}




