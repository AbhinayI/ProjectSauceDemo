package com.SauceLabBase;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public  WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	


	public static Logger log = LogManager.getLogger(TestBase.class.getName());

//		@Parameters("browserName")
//		@BeforeMethod
//		public void setUp(String browserName)
//		{
//			if(browserName.equalsIgnoreCase("chrome"))
//					{
//				WebDriverManager.chromedriver().setup();
//			
//			driver=new ChromeDriver();
//					}
//			else
//			{
//				WebDriverManager.firefoxdriver().setup();
////				System.setProperty("webdriver.gecko.driver", 
////						"C:\\Users\\One\\Downloads\\Edu\\Class\\Selenium\\Selenium Exe\\chromedriver_win32\\geckodriver.exe");
//				
//				driver=new FirefoxDriver();
//			}
//			
//			driver.manage().window().maximize();
//			System.out.println("Browser is maximized");
//			driver.get("https://www.saucedemo.com/");
//			System.out.println("URL is Opened");
//			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//			
//		}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\One\\Downloads\\Edu\\Class\\Selenium\\Selenium Exe\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		log.info("Browser is Opened");
		driver.manage().window().maximize();
		log.info("Browser is maximized");
		driver.get("https://www.saucedemo.com/");
		log.info("URL is Opened");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		log.info("Broswer is closed");
	}

}
