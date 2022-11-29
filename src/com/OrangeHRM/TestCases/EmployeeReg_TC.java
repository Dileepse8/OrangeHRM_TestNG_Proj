package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.AppUtilities;
import com.OrangeHRM.Library.EmployeeReg;
import com.OrangeHRM.Library.LoginPage;

public class EmployeeReg_TC extends AppUtilities {
	@Parameters({"uid","pwd","empname","emplname"})
	@Test
	public void EmpRegistration(String logemail,String logpwd,String empfname,String emplname) throws InterruptedException {
		LoginPage log=new LoginPage();
		log.adminlogInPageDetails(logemail, logpwd);
		EmployeeReg addemp=new EmployeeReg();
		boolean res=addemp.EmployeeRegData(empfname, emplname);
		Assert.assertTrue(res);
		log.LogOUTApp();
		
		
		
		
	}
	

	
}
