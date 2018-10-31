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
//-------------------------------------------Home Page of Book Store Application---------------------------------------------//
public class BookStore_Home_Page extends PageBase {

	public BookStore_Home_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	//PageFactory
	@FindBy(xpath = "//*[@id='navbar-search']")
	private WebElement searchBook_Text;

	@FindBy(xpath = "//button[@class='btn btn-default']/span")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@href='books/selenium-webdriver-book']")
	private WebElement book_Link;

/*
 * This method will launch the Book store application 
 * */
	public void launchUrl(String urL) throws Exception {

		enterUrl(urL);
		Thread.sleep(3000);

	}
/*
 * This method will enter a book name in search book text field and clicks on the search button
 * List of books will be displayed
 * Clicks on the one of the book listed 
 * */
	public void searchBook() throws Exception {

		enterText(searchBook_Text,"selenium webdriver","Search Book Text feild");
		click(searchButton,"Search Button");
		click(book_Link,"Book Link");
		Thread.sleep(3000);

	}


}




