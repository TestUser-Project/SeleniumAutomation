package com.mop.qa.pageobject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.AppiumDriver;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class BMP_Page extends PageBase {
	
	public BMP_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public BMP_Page(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	
	//To  launch Url
	public void enterUrl(String urL,String value) throws Exception {
		try {
			proxy.newHar("Har File");
			System.out.println(toolName);
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
	
	//To enter value to the Har/Txt File
	public void harEntry(String strPath) throws IOException
	{
		System.out.println("Proxy out"+proxy.getHar().getLog().getEntries());
		Har har = proxy.getHar();
		FileOutputStream fos = new FileOutputStream(strPath);
		System.out.println("Har File Written");
		har.writeTo(fos);
		System.out.println("File Written");
		List<HarEntry> entries = har.getLog().getEntries();
		System.out.println("File Written"+entries.size());
		for (HarEntry entry : entries) {
			System.out.println("Request URL: " + entry.getRequest().getUrl());
			System.out.println("Entry response status: " + entry.getResponse().getStatus());
			System.out.println("Entry response text: " + entry.getResponse().getStatusText());
		}
	}
	
	//To validate whether the Url is present
	public void validateHar(String strPath,String validateStr) throws IOException
	{
		 File file = new File(strPath);
		 Scanner scanner = new Scanner(file);
		 try {
			while (scanner.hasNextLine()) {
			    final String lineFromFile = scanner.nextLine();
			    if(lineFromFile.contains(validateStr)) { 			       
			    	ExtentUtility.getTest().log(LogStatus.PASS, validateStr + "is present",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			        break;
			    }
			    
			 }
		} catch (Exception e) {
			ExtentUtility.getTest().log(LogStatus.FAIL, validateStr + "is not  present",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			e.printStackTrace();
		}
	}
}



