package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.testbase.PageBase;
/**
*
* @author Cognizant
* @version 1.0
* @since 2018-10-30
*/
//---------------------------Cart Page of Book Store Apllication--------------------------------//
public class BookStore_Cart_Page extends PageBase {

	public BookStore_Cart_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	//PageFactory
	@FindBy(xpath = "//input[@value='add to cart']")
	private WebElement addCart_Button;
	
	@FindBy(xpath = "//a[@href='/bookstore/cart']")
	private WebElement cart_Logo;
	
	@FindBy(xpath = "//*[@id='billing-first-name']")
	private WebElement fname_Text;
	
	@FindBy(xpath = "//*[@id='billing-last-name']")
	private WebElement lname_Text;
	
	@FindBy(xpath = "//*[@id='billing-address1']")
	private WebElement address1_Text;
	
	@FindBy(xpath = "//*[@id='billing-address2']")
	private WebElement address2_Text;
	
	@FindBy(xpath = "//*[@id='billing-city']")
	private WebElement city_Text;
	
	@FindBy(xpath = "//*[@id='billing-state']")
	private WebElement state_Text;
	
	@FindBy(xpath = "//*[@id='billing-country']")
	private WebElement country_Text;

	@FindBy(xpath = "//option[@value='IN']")
	private WebElement selectCountry_DropDown;
	
	@FindBy(xpath = "//input[@value='Both']")
	private WebElement both_Radio;
	
	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirm_Button;
	
	@FindBy(xpath = "//*[@id='billing-zip']")
	private WebElement zip_Text;
	
	@FindBy(xpath = "//*[@id='card-number']")
	private WebElement cardNum_Text;
	
	@FindBy(xpath = "//*[@id='card-type']")
	private WebElement cardType_Text;
	
	@FindBy(xpath = "//option[@value='MasterCard']")
	private WebElement selectCardType;
	
	@FindBy(xpath = "//*[@id='card-exp-month']")
	private WebElement cardExpiryMonth;
	
	@FindBy(xpath = "//option[@value='1']")
	private WebElement select_CardExpiryMonth;
	
	@FindBy(xpath = "//*[@id='card-exp-year']")
	private WebElement cardExpiryYear;
	
	@FindBy(xpath = "//option[@value='2022']")
	private WebElement Select_CardExpiryYear;

/*
 * This method clicks on the add cart button and opens the cart by clicking on the cart logo
 * */
	public void addCart() throws Exception {

		click(addCart_Button, "Add Cart Button");
		click(cart_Logo, "Cart Logo");
		Thread.sleep(3000);

	}
/*
 * This method fills the billing information and clicks on confirm button 
 * Navigates to Thank You Page*/	
	public void billingInfo() throws Exception {
		enterText(fname_Text,"Sowmya","First Name");
		enterText(lname_Text,"Yellakara","Last Name");
		enterText(address1_Text,"Mepz","Street Address1");
		enterText(address2_Text,"Tambaram","Street Address2");
		enterText(city_Text,"Chennai","City");
		enterText(state_Text,"Tamilnadu","State");
		enterText(zip_Text,"600001","ZIP Code");
		click(country_Text,"Billing Country");
		click(selectCountry_DropDown,"Country DropDwon");
		click(cardType_Text,"Card Type");
		click(selectCardType,"Card Type DropDwon");
		enterText(cardNum_Text,"1234567891234567891","Card Number");
		click(cardExpiryMonth,"Card Expiry Month");
		click(select_CardExpiryMonth,"Card Expiry Month Drop Down");
		click(cardExpiryYear,"Card Expiry Year");
		click(Select_CardExpiryYear,"Card Expiry Year Drop Down");
		click(both_Radio,"Both Radio Button");
		click(confirm_Button,"Confirm Button");
		Thread.sleep(3000);

	}
}




