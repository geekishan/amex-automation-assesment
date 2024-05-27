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
public class YourInformationPage {
	WebDriver driver;
	 SeleniumActions action;
	

	 
	@FindBy(xpath = " //span[text()='Checkout: Your Information' ] ")
	WebElement lblCheckout;
	

	@FindBy(xpath = " //*[@id=\'first-name\'] ")
	WebElement firstName;
	

	@FindBy(xpath = " //*[@id=\'last-name\'] ")
	WebElement lastName;
	

	@FindBy(xpath = "//*[@id=\'postal-code\']")
	WebElement postalCode;
	

	@FindBy(xpath = "//*[@id='cancel'] ")
	WebElement cancelBtn;
	

	@FindBy(xpath = " //*[@id=\"continue\"] ")
	WebElement continueBtn;
	
	public YourInformationPage(final WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateYourInfoLbl() {
		action.isDisplayed(driver, lblCheckout);
	}
	
	public OrderOverviewPage yourInformation(String lname, String fname, String zip) throws Throwable {
		action.type(lastName, lname);
		action.type(firstName, fname);
		action.type(postalCode, zip);
		return new OrderOverviewPage(driver);
	}
public void clickContinueBtn() {
	action.click(driver, continueBtn);
}
}
