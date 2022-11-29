package com.OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.AppUtilities.AppUtilities;

public class EmployeeReg extends AppUtilities {

	public boolean EmployeeRegData(String empfname, String emplname) {

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		//driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys(empfname);
		driver.findElement(By.id("lastName")).sendKeys(emplname);
		String EmpID = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(EmpID);
		driver.findElement(By.id("searchBtn")).click();

		// Table validation
		WebElement emptable = driver.findElement(By.id("resultTable"));

		List<WebElement> rows, cols;
		rows = emptable.findElements(By.tagName("tr"));
		boolean isempExists = false;

		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			if (cols.get(1).getText().equalsIgnoreCase(EmpID)) {

				isempExists = true;
				break;
			}

		}
		if (isempExists) {
			return true;
		} else {
			return false;
		}

	}

}
