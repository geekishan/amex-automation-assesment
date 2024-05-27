package com.shopping.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.pageobjects.HomePage;
import com.shopping.pageobjects.LoginPage;
import com.shopping.pageobjects.OrderOverviewPage;
import com.shopping.pageobjects.SearchResultsPage;
import com.shopping.pageobjects.YourCartPage;
import com.shopping.pageobjects.YourInformationPage;
import com.shopping.utility.Log;

import junit.framework.Assert;

public class OrderOverviewTest extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	YourCartPage yourCartPage;
	YourInformationPage yourInformationPage;
	OrderOverviewPage orderOverviewPage;

	@Test
	public void processCheckout() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		homePage.selectValue("Price (low to high)");

		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectLowestPriceItem();
		//searchResultsPage.clickOnAddToCart();
		searchResultsPage.clickonShopCartLnk();
		Log.info("clicked on  cart ");

		yourCartPage = new YourCartPage(driver);
		yourCartPage.clickOncheckout();

		yourInformationPage = new YourInformationPage(driver);
		yourInformationPage.validateYourInfoLbl();
		yourInformationPage.yourInformation(prop.getProperty("fname"), prop.getProperty("lname"),
				prop.getProperty("zip"));
		yourInformationPage.clickContinueBtn();

		orderOverviewPage = new OrderOverviewPage(driver);
		orderOverviewPage.validateLblOvervw();
		orderOverviewPage.cliconkFinishBtn();
	    Assert.assertEquals(orderOverviewPage.getSuccessMsg().trim(), "Thank you for your order!");
		
		

	}
}
