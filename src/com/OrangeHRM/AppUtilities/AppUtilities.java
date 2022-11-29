package com.OrangeHRM.AppUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtilities {
	public static WebDriver driver;
	String url = "http://orangehrm.qedgetech.com/";

	@BeforeTest
	public void LunchApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	@AfterTest
	public void CloseApplication() {
		driver.close();
	}
}
