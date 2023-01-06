package com.SauceLabPOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SauceLabBase.BaseActions;

public class CartPage extends BaseActions {
	public CartPage(WebDriver driver) {
		super(driver);
	}

	By header = By.xpath("//span[@class='title']");
	By CartCheckOut = By.xpath("//button[@id='checkout']");
	By F_Name = By.xpath("//input[@id=\"first-name\"]");
	By L_Name = By.xpath("//input[@id=\"last-name\"]");
	By Zip_code = By.xpath("//input[@id=\"postal-code\"]");
	By Continue = By.xpath("//input[@id=\"continue\"]");
	By Finish = By.xpath("//button[@id=\"finish\"]");
	By OrderPlacedMsg = By.xpath("//h2[@class=\"complete-header\"]");

	public String getCartPageTitle() {
		return driver.getTitle();
	}

	public String getCartPageHeader() {
		return dogetText(header);
	}

	public void clickCheckOut() {
		Click(CartCheckOut);
	}

	public void CheckOutInfo(String fname, String lname, String zip) {
		sendKeys(F_Name, fname);
		sendKeys(L_Name, lname);
		sendKeys(Zip_code, zip);
		Click(Continue);
		Click(Finish);
	}

	public String getOrderPlacedMsg() {
		return dogetText(OrderPlacedMsg);
	}
}
