package com.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	Logger logger;
	public static WebDriver driver;
	ReadConfig read=new ReadConfig();
	public String baseURL=read.getApplicationURL();
	public String email=read.getEmailID();
	public String password=read.getPassword();
	
	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(@Optional ("chrome") String browserName) {
		logger=logger.getLogger("Urban_Ladder");
		PropertyConfigurator.configure("Log4j.properties");
		switch(browserName){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		default:
			System.err.println("Invalid Browser name"+browserName);
		}
		
		logger.info("Browser is opened");
		driver.get(baseURL);
		logger.info("URL is entered");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Browser is closed");
	}
	 public void captureScreen(WebDriver driver, String tname) throws Exception {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
}
