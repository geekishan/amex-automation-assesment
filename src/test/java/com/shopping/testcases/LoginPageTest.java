package com.shopping.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.pageobjects.HomePage;
import com.shopping.pageobjects.LoginPage;
import com.shopping.utility.Log;
import junit.framework.Assert;

public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homePage;

	@Test
	public void loginTest() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = homePage.getcurrentURL();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");
	}

}
