package com.mop.qa.pageobject;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.mop.qa.testbase.PageBase;

import io.appium.java_client.AppiumDriver;
public class MMT_search_Page extends PageBase {
	
	public MMT_search_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
		
	}

	//@FindBy(xpath = "//*[@id=\"aln_9W_dep\"]")
	@FindBy(xpath = "//span[@class='make_blockElm airline_name append_bottom4 ng-binding' and text()='Jet Airways']")
	
	private WebElement selectAirline;
	
	//*[@id="departure"]
	
	@FindBy(xpath = "//a[text()='DEPARTURE']")
	private WebElement departure;
	
	@FindBy(xpath = "//span[contains(text(),'flights found')]")
	private WebElement flightCount;
	
	//@FindBy(xpath = "'//div[contains(text(), \"{0}\") and @class=\"inner\"]'.format(text)")
	private WebElement filterFlights;
	
	public void countFlight() throws Exception
	{
		
		String a = flightCount.getText();
		StringTokenizer sc =  new StringTokenizer(a," ");
		String b = sc.nextToken();
		System.out.println("The number of flights displayed on page"+b);
		List<WebElement> allElements = remoteDriver.findElements(By.xpath("//a[text()='Book']"));
		int count = allElements.size();
		System.out.println("The number of flights displayed in script"+count);
		int c = Integer.parseInt(b);
		if(c==count)
		{
			System.out.println("---------------------FLIGHT COUNT VALIDATED-------------------");
		}
	}
	
	public void selectAirline() throws Exception
	{
		//selectAirline.click();
		click(selectAirline,"Apply filters for airlines");
		Thread.sleep(2000);
	
	}
	
	public void departureArrange() throws Exception
	{
		//departure.click();
		click(departure,"Departure");
		Thread.sleep(2000);
	
	}
	
	
	public void filterFlights() throws Exception
	{
		List<WebElement> allElements = remoteDriver.findElements(By.xpath("(//span[contains(text(),'18:')])"));
		int count = allElements.size();
		System.out.println("The flights from 6PM-7PM are "+count);
		//WebElement lastFlight = driver.findElement(By.xpath("(//span[contains(text(),'18:')])["+count+"]"));
		WebElement lastFlight = remoteDriver.findElement(By.xpath("(//span[contains(text(),'18:')])["+count+"]//following::*[contains(text(),'Book')][1]"));
		 JavascriptExecutor js = (JavascriptExecutor) remoteDriver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", lastFlight);
		 //lastFlight.click();
		 click(lastFlight,"Flight between 6-7");
		 System.out.println("Highlighted the last flight for 6PM-7PM");

		 
		 
	}
	
	
	
	
}
