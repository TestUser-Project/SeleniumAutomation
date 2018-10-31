/*package com.mop.qa.pageobject;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.Utilities.ExtentUtility;
import com.mop.qa.testbase.PageBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

public class NbcPage_Web  extends PageBase {
	Point location;
	Dimension size;
	public NbcPage_Web(RemoteWebDriver remoteDriver) {
		super(remoteDriver);
	}

	public NbcPage_Web(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	@FindBy(xpath = "//*[@id='media-card-link-1637156']/span")
	private WebElement Video;
	
	@FindBy(xpath = "//div[@class='tpVideoBlocker']/a")
	private WebElement VideoPlayer;
	

	@FindBy(xpath = "//canvas[@class='IconPause']")
	private WebElement btnPause;

	@FindBy(xpath = "//canvas[@class='IconPlay']")
	private WebElement btnPlay;
	
	@FindBy(xpath = "//div[@class='PlayerLabelFont']")
	private WebElement time;

	@FindBy(xpath = "//*[@id='player49784.controls']/div/div[1]/div/div[1]/div[1]/div/div/div[6]")
	private List<WebElement> slider;
	
	@FindBy(xpath = "//*[@id='player49784.controls']/div/div[1]/div/div[1]/div[1]/div/div/div[6]")
	private WebElement searchButton;


	
	

	public void enterUrl() throws Exception {
		enterUrl("http://www.nbcsports.com/");
		Thread.sleep(3000);
	}
	
	
	public void searchVideo() throws Exception {
		click(searchButton, "Search Button");
		Thread.sleep(3000);
	}
	
	public void playVideo_pc() throws Exception {

		click(Video, "Play Button");
		Thread.sleep(25000);
		
	}
	public void adValidation_PC() throws Exception {

		Mat img2 = Imgcodecs.imread("preprocess\\NBC_Screenshot.png", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		Thread.sleep(5000);
		if (CheckImageinVideo(img2, 1)) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is not Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is not playing");
		} else {
			ExtentUtility.getTest().log(LogStatus.INFO, "Advertisement is Playing ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Ad is playing");
			CheckImageinVideo(img2, 3);
		}

	}
	public void motionDetect_PC() throws IOException, InterruptedException {
		Thread.sleep(3000);
		location = VideoPlayer.getLocation();
		size = VideoPlayer.getSize();

		AppDetect_VideoPlayDesktop(location, size);
		Thread.sleep(3000);
	}
	public void forward() throws Exception {

		String before = getText(time).replace("Current Time", "").trim();
		System.out.println(before);

		dragAndDropThumb(slider.get(0),20);
		Thread.sleep(2000);
		clickByJse(btnPlay, "Play  Button");
		Thread.sleep(2000);
		clickByJse(btnPause, "Pause  Button");

		String after = getText(time).replace("Current Time", "").trim();
		System.out.println(after);

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);

		if (timeaftr.after(timeB4)) {
			System.out.println("Video is Fast Forwarded from " + before + " to " + after + " Successfully");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Fast Forwarded from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video Fast Forward Failed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Fast Forward Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
	public void rewind() throws Exception {

		String before = getText(time).replace("Current Time", "").trim();
		System.out.println(before);

		dragAndDropThumb(slider.get(0), -30);
		Thread.sleep(2000);
		clickByJse(btnPlay, "Play Button");
		Thread.sleep(1000);
		clickByJse(btnPause, "Pause Button");

		String after = getText(time).replace("Current Time", "").trim();
		System.out.println(after);

		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		Date timeB4 = sdf.parse(before);
		Date timeaftr = sdf.parse(after);
		if (timeaftr.before(timeB4)) {
			System.out.println("Video is Rewound from " + before + " to " + after + " Successfully");
			ExtentUtility.getTest().log(LogStatus.PASS,
					"Video is Rewound from " + before + " to " + after + " Successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			System.out.println("Video Rewind Failed");
			ExtentUtility.getTest().log(LogStatus.FAIL, "Video Rewind Failed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}
	
	public void testClosedCaptionPC() throws Exception {

		//clickByJse(CCIcon, "CC button");
		//clickByJse(CCONIcon, "CC ON Icon");
		clickByJse(btnPlay, "Play Button");
		String cc = extract_Text_Desktop(location, size);
		if (cc.length() > 1) {
			System.out.println(cc.replaceAll("[^A-Za-z]", " ").trim());
			System.out.println("Closed Caption is showing");
			ExtentUtility.getTest().log(LogStatus.PASS, "Closed Caption is showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Closed Caption is not showing",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println("Closed Caption is not showing");
		}

	}


}


*/