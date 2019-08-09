package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest log1;
	
	
	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Kalyani");
		
		htmlReporter.config().setDocumentTitle("Urban Ladder");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);	
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		log1=extent.createTest(tr.getName());
		log1.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		log1=extent.createTest(tr.getName());
		log1.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"//ScreenShots//"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if (f.exists()) {
			try {
				log1.fail("Screenshot is below"+log1.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
//		try {
//			//BaseClass.captureScreen(BaseClass.driver, "TestCase_Failed");
//		} catch (Exception e) {
//			System.out.println("Failed Screenshot captured");
//			e.printStackTrace();
//		}
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		log1=extent.createTest(tr.getName());
		log1.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
	 extent.flush();
	}
		
	}
	

