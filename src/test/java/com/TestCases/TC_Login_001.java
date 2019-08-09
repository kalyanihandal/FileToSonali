package com.TestCases;

import org.testng.annotations.Test;

import com.PageObject.LoginPage;

public class TC_Login_001 extends BaseClass {
	@Test(priority=1)
	public void verifyLogin() throws Exception {
		LoginPage lp=new LoginPage(driver);
		lp.clickLoginText();
		logger.info("Clicked on Login text");
		lp.enterEmail(email);
		logger.info("Entered Email ID");
		//Assert.assertTrue(false);
		lp.enterPassword(password);
		logger.info("Entered Password");
		lp.clickOnLoginButton();
		logger.info("Clicked on Login Button");
		
	}

	
}
