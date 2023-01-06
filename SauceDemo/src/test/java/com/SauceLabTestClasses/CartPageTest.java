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
import com.SauceLabTestData.DataSupplier;

public class CartPageTest extends TestBase {
	LoginPage login;
	HomePage home;
	CartPage cart;
	Logger log;

	public CartPageTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void set() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		cart = new CartPage(driver);
		home = login.doLogin("standard_user", "secret_sauce");
		cart = home.clickAddToCart();
		home.clickCartBtn();
		log = LogManager.getLogger(CartPageTest.class.getName());
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void VerifyCartPageTitle() {
		log.info("Test - VerifyCartPageTitle");
		String Title = cart.getCartPageTitle();
		log.info("Cart Page Title is:" + Title);
		Assert.assertEquals(Title, "Swag Labs");
		log.info("Test - Assertion Passed");
	}

	@Test(groups = { "Regression" })
	public void VerifyCartPageHeader() {
		log.info("Test - VerifyCartPageHeader");
		String Header = cart.getCartPageHeader();
		log.info("Cart Page Header is:" + Header);
		Assert.assertEquals(Header, "YOUR CART");
		log.info("Test - Assertion Passed");
	}

	@Test(groups = { "Regression" },dataProvider = "info", dataProviderClass = DataSupplier.class)
	public void verifyBuyProduct(String firstName,String lastName,String zipCode) {
		log.info("Test - verifyBuyProduct");
		cart.clickCheckOut();
		cart.CheckOutInfo(firstName, lastName, zipCode);
		String Text = cart.getOrderPlacedMsg();
		log.info("Successful Order Page Message is:" + Text);
		Assert.assertEquals(Text, "THANK YOU FOR YOUR ORDER");
		log.info("Test - Assertion Passed");

	}

}
