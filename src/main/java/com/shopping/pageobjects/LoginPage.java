package com.shopping.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.actiondriver.SeleniumActions;
//import com.shopping.testcases.BaseClass;


public class LoginPage {
	WebDriver driver;
	HomePage homePage;
	SeleniumActions action;
	
	@FindBy(id="user-name")
	 WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	//Constructor
	
	public LoginPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}

	public HomePage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, loginBtn);
		Thread.sleep(2000);
		homePage = new HomePage(driver);
		return  homePage;
	}
}

