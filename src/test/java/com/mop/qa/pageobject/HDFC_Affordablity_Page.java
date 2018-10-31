package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

//------------------------------------HDFC Affordability Page-------------------------------//
public class HDFC_Affordablity_Page extends PageBase {

	public HDFC_Affordablity_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	//PageFactory
	
	@FindBy(xpath = "//a[text()='EMI Calculator']")
	private WebElement EMI_Tab;
	
	@FindBy(xpath = "//a[text()='Eligiblity Calculator']")
	private WebElement Eligiblity_Tab;
	
	@FindBy(xpath = "//a[text()='Affordablity Calculator']")
	private WebElement Affordablity_Tab;
	
	@FindBy(xpath = "//a[text()='Conversion Calculator']")
	private WebElement Conversion_Tab;
	
	/*Clicks on the Affordability Calculator Tab and
	 * Validates whether Affordability Calculator Page is Selected and 
	 *  EMI, Eligibility, Conversion tabs are present
	 */
	
	public void validateAffordablityPage() throws Exception {
		
			click(Affordablity_Tab,"Affordablity Calculator");
			if(Affordablity_Tab.isEnabled())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "Affordablity Calculator Tab is Selected",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "Affordablity Calculator Tab is not Selected",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			if(Eligiblity_Tab.isDisplayed())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "Eligiblity Calculator Tab is Present",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "Eligiblity Calculator Tab is not Present",
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




