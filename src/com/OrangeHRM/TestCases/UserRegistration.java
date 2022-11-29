package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.AppUtilities.AppUtilities;
import com.OrangeHRM.Library.LoginPage;
import com.OrangeHRM.Library.UserData;

public class UserRegistration extends AppUtilities {
	@Parameters({"uid","pwd","empfullname","username","password"})
	@Test
	public void userRegistration(String email,String pwd,String empfullname,String username,String password) throws InterruptedException {
		
		LoginPage log=new LoginPage();
		log.adminlogInPageDetails(email, pwd);
		UserData user=new UserData();
		boolean res=user.UserCreationDataInfo(empfullname, username, password);
		Assert.assertTrue(res);
		System.out.println("User created");
		
	}
}
