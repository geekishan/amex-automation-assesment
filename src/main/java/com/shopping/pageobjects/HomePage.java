/**
 * 
 */
package com.shopping.pageobjects;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.actiondriver.SeleniumActions;

/**
 * 
 */

public class HomePage {

	public WebDriver driver;
	SeleniumActions action;

	@FindBy(xpath = "//div[text()= 'Swag Labs']")
	WebElement title;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement products;

	@FindBy(xpath = "//span/select")
	WebElement Sort;

	@FindBy(xpath = "//span/select")
	WebElement selectValue;

	public HomePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean validateTitle() throws Throwable {
		return action.isDisplayed(driver, title);
	}

	public boolean validateLblProducts() throws Throwable {
		return action.isDisplayed(driver, products);

	}

	public void selectValue(String value) throws Throwable {
		action.selectByVisibleText(value, selectValue);
	}

	public String getcurrentURL() {
		return driver.getCurrentUrl();
	}


}
