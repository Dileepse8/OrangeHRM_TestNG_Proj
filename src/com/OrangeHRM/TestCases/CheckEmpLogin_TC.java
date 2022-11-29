package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.AppUtilities;
import com.OrangeHRM.Library.LoginPage;

public class CheckEmpLogin_TC extends AppUtilities {
	@Parameters({"Empuid","Emppwd"})
	@Test
	public void checkEmpModule(String uname,String pwd) {
		LoginPage log=new LoginPage();//abdul123 Tata@182021
		log.adminlogInPageDetails(uname, pwd);
		boolean empcheck=log.isEmpDisplyed();
		Assert.assertTrue(empcheck);
		
		
		
	}
}
