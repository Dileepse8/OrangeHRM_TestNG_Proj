package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.AppUtilities;
import com.OrangeHRM.Library.LoginPage;

public class AdminLoginInValidData_TC extends AppUtilities {
	@Parameters({ "uid", "pwd" })
	@Test
	public void checkAdminLogin(String email, String pwd) throws InterruptedException {
		LoginPage log = new LoginPage();
		log.adminlogInPageDetails(email, pwd);
		//Thread.sleep(2000);
		boolean errmsg=log.errorMsgDisply();
		Assert.assertTrue(errmsg);
		//log.LogOUTApp();
		
	}
}
