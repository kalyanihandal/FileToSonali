package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObject.LoginPage;
import com.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void loginDDT(String email,String password) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		lp.clickLoginText();
		lp.enterEmail(email);
		logger.info("User Name Entered");
		lp.enterPassword(password);
		logger.info("Password Entered");
		lp.clickOnLoginButton();
		logger.info("Successfully login");
		Thread.sleep(2000);
		WebElement text=driver.findElement(By.xpath("//div[@class='flash ulmessage error  ']"));
//		if (text.getText()=="The email or password you entered is incorrect. Please try again.") {
//		Assert.assertTrue(false);
//		logger.info("Invalid Credentials");
//	}else{
//		Assert.assertTrue(true);
//		logger.info("Valid Credentials");
//	}
		String title=driver.getTitle();
	}
	
	@DataProvider(name="loginData")
	String [][] getData() throws Exception{
		String path=System.getProperty("user.dir")+"/src/test/java/com/TestData/HybridUrbanLadderData1.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for (int i = 1; i <=rownum; i++) {
			for (int j = 0; j <colcount; j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
