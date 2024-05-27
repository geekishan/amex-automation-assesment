package com.shopping.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.actiondriver.SeleniumActions;

public class OrderOverviewPage {
	WebDriver driver;
	SeleniumActions action;

	@FindBy(xpath = " //span[text()='Checkout: Overview']")
	WebElement lblOveriview;

	@FindBy(xpath = " //span[text()='Checkout: Overview']")
	WebElement paymentInfo;

	@FindBy(xpath = " //span[text()='Checkout: Overview']")
	WebElement shippingInfo;

	@FindBy(xpath = " //span[text()='Checkout: Overview']")
	WebElement priceTotal;

	@FindBy(xpath = " //*[@id=\"finish\"]")
	WebElement finishBtn;

	@FindBy(xpath = "//div[@id=\"checkout_complete_container\"]/h2")
	WebElement orderSuccessMsg;

	public OrderOverviewPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void cliconkFinishBtn() {

		action.click(this.driver, finishBtn);
	}

	public void validateLblOvervw() {

		action.isDisplayed(driver, lblOveriview);
	}
	
	public String getSuccessMsg() {
		action.isDisplayed(driver, orderSuccessMsg);
		return orderSuccessMsg.getText();
		
	}

}
