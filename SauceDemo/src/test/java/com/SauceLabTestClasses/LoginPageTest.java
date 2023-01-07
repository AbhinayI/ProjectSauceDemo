package com.SauceLabTestClasses;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceLabBase.TestBase;
import com.SauceLabPOMClasses.HomePage;
import com.SauceLabPOMClasses.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage home;
	Logger log;

	@BeforeMethod(alwaysRun = true)
	public void set(Method m) {
		login = new LoginPage(driver);
		log = LogManager.getLogger(LoginPageTest.class.getName());
	}

	@Test(groups = { "Smoke", "Regression" })
	public void VerifyLoginPageURL() {
		log.info("Test - VerifyLoginPageURL");
		String url = login.getLoginPageUrl();
		log.info("Login Page URL is:" + url);
		Assert.assertEquals(url, "https://www.saucedemo.com/");
		log.info("Test - Assertion Passed");
	}

	@Test(priority = 1, groups = { "Sanity" })
	public void VerifyLoginPageTitle() {
		log.info("Test - VerifyLoginPageTitle");
		String Title = login.getLoginPageTitle();
		log.info("Login Page Title is:" + Title);
		Assert.assertEquals(Title, "Swag Labs");
		log.info("Test - Assertion Passed");
	}

	
	@Test(groups = { "Smoke", "Regression" })
	public void VerifyLogin() throws IOException {
		log.info("Test - VerifyLogin");
		home = login.doLogin("standard_user", "secret_sauce");
		log.info("Test - Assertion Passed");
	}
}
