package com.SauceLabUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.SauceLabBase.TestBase;

public class Utility_ScreenShot extends TestBase {

//	public void ScreenShot(String fileName) throws IOException {
//		File SrcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(SrcShot, new File(".\\ScreenShot\\" + fileName + " " + withDate() + ".jpg"));
//	}

//	Below method for Sequential Execution through XML file
	public String ScreenShot(String fileName) throws IOException {
		File SrcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desShot = new File(".\\ScreenShot\\" + fileName + " " + withDate() + ".jpg");
		FileUtils.copyFile(SrcShot, desShot);
		return desShot.getAbsolutePath();
	}

	public static String withDate() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "-");
	}

}
