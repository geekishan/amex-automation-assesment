/**
 * 
 */
package com.shopping.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.actiondriver.SeleniumActions;


/**
 * 
 */
public class YourCartPage {
	
	WebDriver driver;
	SeleniumActions action;
  
	@FindBy(xpath ="//span[text()='Your Cart']")
	WebElement yourCart;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Onesie']")
	WebElement itemName;
	
	@FindBy(xpath = "//*[@id=\"continue-shopping\"]")
	WebElement ctnShoppingBtn;
	
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	WebElement checkoutBtn;
	
	public YourCartPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateAddToCart() {
		
	}
	
	public void clickOncheckout() throws Throwable {
		action.JSClick(driver, checkoutBtn);
	}
	
	public YourInformationPage checkout() {
		action.JSClick(driver, checkoutBtn);
		action.pageLoadTimeOut(driver, 30);
		return new YourInformationPage(driver);
	}
}
