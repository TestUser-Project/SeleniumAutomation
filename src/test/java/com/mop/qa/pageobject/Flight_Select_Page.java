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

public class Flight_Select_Page extends PageBase {

	public Flight_Select_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public Flight_Select_Page(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	//PageFactory
	@FindBy(xpath = "//td[text()='43']/preceding-sibling::td/input")
	private WebElement chooseFlight_Button;
	
	
	
	
	public void selectFlight(String value) throws Exception {
		try {
			click(chooseFlight_Button,value);
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




