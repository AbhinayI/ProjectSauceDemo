package com.SauceLabReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	public static ExtentReports initialiseExtentReports() {
		String path_All = ".\\ExtentReport\\ExtentAllTests.html";
		String path_Fail = ".\\ExtentReport\\ExtentFailedTests.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path_All);
		ExtentSparkReporter sparkReporter_Fail = new ExtentSparkReporter(path_Fail);
		sparkReporter.config().setReportName("Web Automation SauceLab Reports");
		sparkReporter.config().setDocumentTitle("SauceLab Test Results");

		sparkReporter_Fail.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter, sparkReporter_Fail);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		return extentReports;
	}

}
