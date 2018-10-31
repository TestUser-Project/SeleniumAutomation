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

public class Flight_Home_Page extends PageBase {

	public Flight_Home_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public Flight_Home_Page(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	//PageFactory
	@FindBy(xpath = "//select[@name='fromPort']")
	private WebElement departureCity_DropDown;
	
	@FindBy(xpath = "//select[@name='fromPort']/option[@value='Boston']")
	private WebElement select_departureCity;
	
	@FindBy(xpath = "//select[@name='toPort']")
	private WebElement destinationCity_DropDown;
	
	@FindBy(xpath = "//select[@name='toPort']/option[@value='Rome']")
	private WebElement select_destinationCity;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement findFlights_Button;
	
	
	public void launchUrl(String urL,String value) throws Exception {
		try {
			enterUrl(urL);
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.PASS, value + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, value + " not successful;",
					e.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
	public void clickDepartureCity(String value) throws Exception {
		try {
			click(departureCity_DropDown,"Departure City");
			click(select_departureCity,"Departure City");
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.PASS, value + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, value + " not successful;",
					e.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
	public void clickDestinationCity(String value) throws Exception {
		try {
			click(destinationCity_DropDown,"Destination City");
			click(select_destinationCity,"Destination City");
			Thread.sleep(3000);
			ExtentUtility.getTest().log(LogStatus.PASS, value + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, value + " not successful;",
					e.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
	
	public void clickFindFlights_Button(String value) throws Exception {
		try {
			click(findFlights_Button,value);
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




