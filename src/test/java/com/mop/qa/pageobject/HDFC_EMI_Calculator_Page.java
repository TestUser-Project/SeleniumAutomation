package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

//------------------------------HDFC EMI Calculator Page----------------------------//
public class HDFC_EMI_Calculator_Page extends PageBase {

	public HDFC_EMI_Calculator_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	
	//PageFactory
	@FindBy(xpath = "//*[@id='loan-amount-text-value']")
	private WebElement LoanAmount_Text;
	
	@FindBy(xpath = "//*[@id='tenure-text-value']")
	private WebElement Tenure_Text;
	
	@FindBy(xpath = "//*[@id='interest-text-value']")
	private WebElement Interest_Text;
	
	@FindBy(xpath = "//*[@id='emi-monthly']")
	private WebElement MonthlyEMI_Text;
	
	@FindBy(xpath = "//a[text()='EMI Calculator']")
	private WebElement EMI_Tab;
	
	@FindBy(xpath = "//a[text()='Eligiblity Calculator']")
	private WebElement Eligiblity_Tab;
	
	@FindBy(xpath = "//a[text()='Affordablity Calculator']")
	private WebElement Affordablity_Tab;
	
	@FindBy(xpath = "//a[text()='Conversion Calculator']")
	private WebElement Conversion_Tab;
	
/*Enters
 * Loan Amount =25,00,000
 * Tenure(in Years) =20
 * Interest=8.8%
 * and validates the displayed total Monthly EMI
*/	
	
	public void calculateEMI(String loanAmount, String tenureAmount, String roi, String emi) throws Exception {
		
			enterText(LoanAmount_Text,loanAmount,"Loan Amount");
			enterText(Tenure_Text,tenureAmount,"Tenure Years");
			enterText(Interest_Text,roi,"Tenure Years");
			System.out.println("Expected EMI : "+emi +" Actual EMI : "+getText(MonthlyEMI_Text,"Monthly EMI"));
			Thread.sleep(3000);
			
	}

	/*Validates whether EMI Calculator Page is Selected and 
	 * Eligibility, Affordability, Conversion tabs are present
	 */
	
	public void validateEMIPage() throws Exception {
		
			if(true)
			{
				scrollPage("DOWN",500);
				/*JavascriptExecutor js = (JavascriptExecutor) remoteDriver;
				js.executeScript("arguments[1].scrollIntoView(true);",EMI_Tab);*/
				System.out.println("Scrolled to EMI_Tab");
			}
			if(EMI_Tab.isEnabled())
			{
				ExtentUtility.getTest().log(LogStatus.PASS, "EMI Calculator Tab is Selected",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			}
			else
			{
				ExtentUtility.getTest().log(LogStatus.FAIL, "EMI Calculator Tab is not Selected",
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




