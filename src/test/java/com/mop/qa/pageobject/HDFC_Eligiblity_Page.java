package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

//-------------------------------HDFC Eligibility Calculator Page--------------------------------//
public class HDFC_Eligiblity_Page extends PageBase {

	public HDFC_Eligiblity_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	
	//PageFactory
	@FindBy(xpath = "//a[text()='Eligiblity Calculator']")
	private WebElement SelectEligiblity_Tab;
	
	@FindBy(xpath = "//a[text()='EMI Calculator']")
	private WebElement EMI_Tab;
	
	@FindBy(xpath = "//a[text()='Eligiblity Calculator']")
	private WebElement Eligiblity_Tab;
	
	@FindBy(xpath = "//a[text()='Affordablity Calculator']")
	private WebElement Affordablity_Tab;
	
	@FindBy(xpath = "//a[text()='Conversion Calculator']")
	private WebElement Conversion_Tab;
	
	/*Clicks on the Eligibility Calculator Tab and
	 * Validates whether Eligibility Calculator Page is Selected and 
	 *  EMI, Affordability, Conversion tabs are present
	 */
	public void validateEligiblityPage() throws Exception {
		
			click(SelectEligiblity_Tab,"Eligiblity Calculator");
			if(Eligiblity_Tab.isEnabled())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "Eligiblity Calculator Tab is Selected",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "Eligiblity Calculator Tab is not Selected",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			if(EMI_Tab.isDisplayed())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "EMI Calculator Tab is Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "EMI Calculator Tab is not Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			if(Affordablity_Tab.isDisplayed())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "Affordablity Calculator Tab is Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "Affordablity Calculator Tab is not Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			if(Conversion_Tab.isDisplayed())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "Conversion Calculator Tab is Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "Conversion Calculator Tab is not Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			
			Thread.sleep(3000);
			
	}



}




