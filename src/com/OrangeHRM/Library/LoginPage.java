package com.OrangeHRM.Library;

import org.openqa.selenium.By;
//import org.testng.Assert;

import com.OrangeHRM.AppUtilities.AppUtilities;

public class LoginPage extends AppUtilities {

	public void adminlogInPageDetails(String email, String pwd) {
		driver.findElement(By.id("txtUsername")).sendKeys(email);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();

	}

	public boolean isAdminDisplyed() {

		String admin = driver.findElement(By.linkText("Admin")).getText();
		if (admin.equalsIgnoreCase("ADMIN")) {
			// Assert.assertTrue(true);
			return true;

		} else {
			// Assert.assertTrue(false);
			return false;

		}

	}

	public boolean errorMsgDisply() {
		if (driver.findElement(By.id("spanMessage")).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isEmpDisplyed() {

		try {
			driver.findElement(By.linkText("Admin")).isDisplayed();

			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public void LogOUTApp() throws InterruptedException {
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();

	}
}
