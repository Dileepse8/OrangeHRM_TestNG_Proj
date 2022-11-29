package com.OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.OrangeHRM.AppUtilities.AppUtilities;

public class UserData extends AppUtilities {

	public boolean UserCreationDataInfo(String empfullname, String username, String password)
			throws InterruptedException {

		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();

		driver.findElement(By.id("btnAdd")).click();

		WebElement drpval = driver.findElement(By.id("systemUser_userType"));
		Select sa = new Select(drpval);
		sa.selectByVisibleText("Admin");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empfullname);
		Thread.sleep(1000);
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		//String username1 = driver.findElement(By.id("systemUser_userName")).getAttribute("value");

		WebElement drpuser = driver.findElement(By.id("systemUser_status"));
		Select sa1 = new Select(drpuser);
		sa1.selectByVisibleText("Enabled");

		driver.findElement(By.id("systemUser_password")).sendKeys(password);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
		Thread.sleep(2000);
		//System.out.println("User creation completed");
		driver.findElement(By.id("btnSave")).click();
		

		// validating User qwerty

		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).click();

		List<WebElement> rownum, colnum;
		WebElement usertable = driver.findElement(By.id("resultTable"));
		rownum = usertable.findElements(By.tagName("tr"));
		boolean isuser = false;

		for (int i = 1; i < rownum.size(); i++) {
			colnum = rownum.get(i).findElements(By.tagName("td"));
			if (colnum.get(1).getText().equalsIgnoreCase(username)) {
				// Assert.assertTrue(true);
				isuser = true;
				break;
			}

		}
		if (isuser) {
			return true;
		} else {
			return false;
		}

	}

}
