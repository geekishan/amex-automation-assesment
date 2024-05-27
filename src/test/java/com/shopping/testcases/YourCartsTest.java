package com.shopping.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopping.pageobjects.HomePage;
import com.shopping.pageobjects.LoginPage;
import com.shopping.pageobjects.SearchResultsPage;
import com.shopping.pageobjects.YourCartPage;
import com.shopping.pageobjects.YourInformationPage;
import com.shopping.utility.Log;

public class YourCartsTest extends BaseClass {
	LoginPage loginpage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	YourCartPage yourCartPage;
	YourInformationPage yourInformationPage;

	@Test
	public void continueShooping() throws Throwable {
		loginpage = new LoginPage(driver);
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage(driver);
		homePage.selectValue("Price (low to high)");

		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectLowestPriceItem();
		searchResultsPage.clickonShopCartLnk();
		Log.info("clicked on  cart ");

		yourCartPage = new YourCartPage(driver);
		yourCartPage.clickOncheckout();

		yourInformationPage = new YourInformationPage(driver);
		yourInformationPage.validateYourInfoLbl();
		yourInformationPage.yourInformation(prop.getProperty("fname"), prop.getProperty("lname"),
				prop.getProperty("zip"));
		yourInformationPage.clickContinueBtn();

	}

}
