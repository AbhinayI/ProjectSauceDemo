package com.SauceLabTestClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceLabBase.TestBase;
import com.SauceLabPOMClasses.CartPage;
import com.SauceLabPOMClasses.HomePage;
import com.SauceLabPOMClasses.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage login;
	HomePage home;
	CartPage cart;
	Logger log;

	public HomePageTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void set() {
		login = new LoginPage(driver);
		cart = new CartPage(driver);
		home = login.doLogin("standard_user", "secret_sauce");
		log = LogManager.getLogger(HomePageTest.class.getName());
	}

	@Test(groups = { "Smoke", "Regression" })
	public void VerifyHomePageTitle() {
		log.info("Test - VerifyHomePageTitle");
		String Title = home.getHomePageTitle();
		log.info("Home Page Title is:" + Title);
		Assert.assertEquals(Title, "Swag Labs");
		log.info("Test - Assertion Passed");
	}

	@Test(groups = { "Sanity", "Regression" })
	public void VerifyHomePageHeader() {
		log.info("Test - VerifyHomePageHeader");
		String Header = home.getHomePageHeader();
		log.info("Home Page Header is:" + Header);
		Assert.assertEquals(Header, "PRODUCTS");
		log.info("Test - Assertion Passed");
	}

	@Test(groups = { "Regression" })
	public void VerifyHomePageMenuBtn() throws InterruptedException {
		log.info("Test - VerifyHomePageMenuBtn");
		home.clickMenuBtn();
		home.clickLogout();
		log.info("Test - Assertion Passed");
		Thread.sleep(5000);
	}

	@Test(groups = { "Regression" })
	public void VerifyAddToCart() {
		log.info("Test - VerifyAddToCart");
		cart = home.clickAddToCart();
		String cartValue = home.getHomePageCartValue();
		Assert.assertEquals(cartValue, "1");
		home.clickCartBtn();
		log.info("Test - Assertion Passed");
	}

//	@Test
//	public void VerifyAllAddToCart() 
//	{
//		log.info("Test - VerifyLoginPageURL");
//		cart = home.clickAllAddToCart();
//		home.clickCartBtn();
//		log.info("Test - Assertion Passed");
//	}

	@Test(groups = { "Regression" })
	public void VerifyDropDown() {
		log.info("Test - VerifyDropDown");
		home.SelectDropDown();
		log.info("Test - Assertion Passed");
	}

}
