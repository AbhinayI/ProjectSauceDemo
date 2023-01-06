package com.SauceLabUtility;

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SauceLabReports.Report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ITestListenerClass extends Report implements ITestListener {

	ExtentReports extentReports = Report.initialiseExtentReports();
	Utility_ScreenShot screen = new Utility_ScreenShot();

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, "<b>Test Passed</b>");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.fail(result.getThrowable());
//		extentTest.info(MarkupHelper.createLabel("fail", ExtentColor.RED));
		try {
//			Attaching screenshots to extent reports at Test Level
			extentTest.addScreenCaptureFromPath(screen.ScreenShot(result.getName()), result.getName());

//			Attaching screenshots to extent reports at Log Level
			extentTest.log(Status.INFO, MediaEntityBuilder
					.createScreenCaptureFromPath(screen.ScreenShot(result.getName()), result.getName()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Screenshots_For_Failed_Tests
//		try {
//			ScreenShot(result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("ExtentReport\\ExtentAllTests.html").toURI());
			Desktop.getDesktop().browse(new File("ExtentReport\\ExtentFailedTests.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
