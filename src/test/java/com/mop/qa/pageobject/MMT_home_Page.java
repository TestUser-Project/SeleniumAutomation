package com.mop.qa.pageobject;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase;

import io.appium.java_client.AppiumDriver;





public class MMT_home_Page extends PageBase
{
	
	public MMT_home_Page(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}
	
	@FindBy(id = "hp-widget__sfrom")
	private WebElement fromLoc;
	
	//public WebDriver driver;
	

	@FindBy(id = "hp-widget__sTo")
	private WebElement toLoc;
	
	@FindBy(id = "hp-widget__depart")
	private WebElement fromDate;
	
/*	@FindBy(xpath = "(//*[normalize-space(text())='Mon']//following::a)[1]")
	private WebElement currDate;
	*/
	//driver.findElement(By.xpath("(//td[@data-month="+month+"]/a[text()="+date1+"])[1]")).click(); 
	@FindBy(xpath = "(//*[normalize-space(text())='Mon']//following::a)[3]")
	private WebElement dateSel;
	
	@FindBy(xpath = "//li[contains(@aria-label,'Search Result')]//span[contains(.,'Chennai')]")
	private WebElement resultFromPopup;
	
	@FindBy(xpath = "//li[contains(@aria-label,'Search Result')]//span[contains(.,'Mumbai')]")
	private WebElement resultToPopup;
	
	@FindBy(id = "searchBtn")
	private List<WebElement> searchBtn;

	public void enterURL(String url) throws Exception
	{
		enterUrl(url);
	
	}

	public void fromLoc(String txt) throws Exception
	
	{
		click(fromLoc,"Enter From Location");
		System.out.println("Clicked on from loc");
		fromLoc.clear();
		fromLoc.sendKeys(txt);
		Thread.sleep(2000);
		
		/*if(resultFromPopup.isDisplayed()){
			resultFromPopup.click();
		}
		else{
			System.out.println("--------------Entered FROM location not found-------------");
		}*/
			

		fromLoc.sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void toLoc(String txt) throws Exception
	{
		click(toLoc,"Enter To Location");
		toLoc.clear();
		Thread.sleep(2000);
		toLoc.sendKeys(txt);
		Thread.sleep(2000);
		/*if(resultToPopup.isDisplayed()){
			resultToPopup.click();
		}
		else{
			System.out.println("--------------Entered TO location not found-------------");
		}*/
		toLoc.sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void fromDate() throws Exception
	{
		click(fromDate,"Enter From Date");
		remoteDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 click(dateSel,"Select the date");
		 remoteDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	 /*public void dateSelect() throws Exception {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 int curDate=0;
		 curDate=Integer.parseInt(date1);
		 
                		 //if(gettext(curDate).equalsIgnoreCase(date1))
		 {
			 click(dateSel);
			 
		 }
		 
	
		 
		 }*/
	
	@SuppressWarnings("null")
	public void dateSelect() {
        try {
              // WebDriver driver = null;
               
               /*driver = new ChromeDriver();
               driver.get("https://www.makemytrip.com/");
               driver.manage().window().maximize();*/
          remoteDriver.findElement(By.cssSelector("div.inputM.depart_input.inputHlp.inputDateFilter")).click();
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M-d");  
                  LocalDateTime now = LocalDateTime.now().plusDays(2); 
                  System.out.println(dtf.format(now));
                  String date = dtf.format(now);
                  String data[] = date.split("-");
               int month = Integer.parseInt(data[0])-1;
               int date1 = Integer.parseInt(data[1]);
               Thread.sleep(3000);
                  remoteDriver.findElement(By.xpath("(//td[@data-month="+month+"]/a[text()="+date1+"])[1]")).click();
               
               
              // Thread.sleep(10000);
              // driver.quit();
        } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }

 }


	 public void searchBtn() throws Exception
		{
		 
			click(searchBtn.get(0),"Click on search button");
			
			System.out.println("Clicked on search button");
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
		}

}
