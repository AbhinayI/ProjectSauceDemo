package com.SauceLabPOMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SauceLabBase.BaseActions;

public class LoginPage extends BaseActions {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By username = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public HomePage doLogin(String userName, String pwd) {
		sendKeys(username, userName);
		sendKeys(password, pwd);
		Click(loginBtn);

		return new HomePage(driver);
	}

}
