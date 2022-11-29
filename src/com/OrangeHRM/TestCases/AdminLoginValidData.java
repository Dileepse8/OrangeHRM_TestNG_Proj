package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.AppUtilities;
import com.OrangeHRM.Library.LoginPage;

public class AdminLoginValidData extends AppUtilities {
	@Parameters({"uid","pwd"})
	@Test
	public void AdminLogin(String email,String password) throws InterruptedException {

		LoginPage lp = new LoginPage();
		lp.adminlogInPageDetails(email,password);
		Boolean res = lp.isAdminDisplyed();
		Assert.assertTrue(res);
		lp.LogOUTApp();

	}

}
