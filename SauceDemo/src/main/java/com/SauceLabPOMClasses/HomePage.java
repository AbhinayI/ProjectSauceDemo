package com.SauceLabPOMClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.SauceLabBase.BaseActions;

public class HomePage extends BaseActions {
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	By header = By.xpath("//span[@class='title']");
	By menuBtn = By.xpath("//button[text()='Open Menu']");
	By logout = By.xpath("//a[text()='Logout']");
	By addToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By CartValue = By.xpath("//span[@class='shopping_cart_badge']");
	By addAllToCart = By.xpath("//button[text()='Add to cart']");
	By Cart = By.xpath("//a[@class='shopping_cart_link']");
	By DropDown = By.xpath("//select[@class=\"product_sort_container\"]");

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeader() {
		return dogetText(header);
	}

	public void clickMenuBtn() {
		Click(menuBtn);
	}

	public void clickLogout() {
		Click(logout);
	}

	public CartPage clickAddToCart() {
		Click(addToCart);
		return new CartPage(driver);
	}

	public String getHomePageCartValue() {
		return dogetText(CartValue);
	}

	public CartPage clickAllAddToCart() {
		List<WebElement> allProduct = driver.findElements(addAllToCart);
		ClickListElement(allProduct);
		return new CartPage(driver);
	}

	public void clickCartBtn() {
		Click(Cart);
	}

	public void SelectDropDown() {
//		doSelectByVisibleText(DropDown,"Name (Z to A)");
		SelectDropDownValues(DropDown, "value", "lohi");
	}

}
