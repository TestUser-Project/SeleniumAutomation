package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.testbase.PageBase;

//------------------------------------HDFC Home Page-------------------------------------------//
public class HDFC_Home_Page extends PageBase {

	public HDFC_Home_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}
	
	//PageFactory
	@FindBy(xpath = "//*[@id='navbarDropdown' and text()='checklist & calculators']")
	private WebElement Calculators_Tab;

	@FindBy(xpath = "//*[@id='primary-menu']//a[@href='/home-loan-emi-calculator']/span")
	private WebElement CalculateEmi_Link;
	
//Launches the HDFC application//

	public void launchUrl(String urL) throws Exception {

		enterUrl(urL);

		Thread.sleep(5000);

	}
	
//Clicks on the CheckList and Calculators Tab and selects Calculate EMI from the listed options//
	public void selectCalculator_tab() throws Exception {

		click(Calculators_Tab,"CheckList and Calculators Tab");
		click(CalculateEmi_Link,"Calculate EMI");
		Thread.sleep(3000);

	}


}




