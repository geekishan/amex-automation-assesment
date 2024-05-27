package com.shopping.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.pageobjects.HomePage;
import com.shopping.pageobjects.LoginPage;
import com.shopping.pageobjects.SearchResultsPage;
import com.shopping.pageobjects.YourCartPage;
import com.shopping.utility.Log;

import junit.framework.Assert;

public class SelectProductTest extends BaseClass {

	LoginPage loginpage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	YourCartPage yourCartPage;

	@Test
	public void verifyTitle() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		String actTitle = homePage.getTitle();
		String expTitle = "Swag Labs";
		Assert.assertEquals(actTitle, expTitle);
		Log.info("Title displyed Sucessfully");
	}

	@Test
	public void sortPriceTest() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		homePage.selectValue("Price (low to high)");

		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectLowestPriceItem();
		boolean result = searchResultsPage.isProductAvailable();
		Assert.assertTrue(result);

	}

	@Test
	public void addToCartTest() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		homePage.selectValue("Price (low to high)");
		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.clickOnAddToCart();
		yourCartPage = new YourCartPage(driver);
		boolean result = searchResultsPage.validateRemoveBtn();
		Assert.assertTrue(result);
	}
}
