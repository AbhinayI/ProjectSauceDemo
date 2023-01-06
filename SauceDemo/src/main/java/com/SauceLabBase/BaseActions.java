package com.SauceLabBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseActions extends TestBase {

	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}

	public void Click(By locator) {
		driver.findElement(locator).click();
	}

	public List<WebElement> ClickListElement(List<WebElement> list) {
		for (WebElement val : list) {
			val.click();
		}
		return list;
	}

	public List<WebElement> getTextListElement(List<WebElement> list) {
		for (WebElement val : list) {
			System.out.println(val.getText());
		}
		return list;
	}

	public void sendKeys(By locator, String Text) {
		driver.findElement(locator).sendKeys(Text);
	}

	public String dogetText(By locator) {
		return driver.findElement(locator).getText();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void doselectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doselectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void SelectDropDownValues(By locator, String type, String value) {
		Select select = new Select(getElement(locator));

		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);
			break;

		case "visibleText":
			select.selectByVisibleText(value);
			break;

		default:
			System.out.println("plz enter correct selection");
			break;
		}
	}
}
