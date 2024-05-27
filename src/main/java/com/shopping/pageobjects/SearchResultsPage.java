/**
 * 
 */
package com.shopping.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Collectors;

import com.shopping.actiondriver.SeleniumActions;


/**
 * 
 */
public class SearchResultsPage {
	
	WebDriver driver; 
	
	SeleniumActions action;
	
	@FindBy(xpath ="//*[@id=\"item_2_title_link\"]/div")
	WebElement productResult;
	
	@FindBy(xpath ="//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
	WebElement addToCartBtn;
	
	
	@FindBy(xpath ="//*[@id=\"remove-sauce-labs-onesie\"]")
	WebElement removeBtn;
	
	//*[@id="shopping_cart_container"]/a/span
	
	@FindBy(css ="div#shopping_cart_container>a")
	WebElement shoppingCartLink;

	public  SearchResultsPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return action.isDisplayed(driver, productResult);
	}
	
	public void  clickOnAddToCart() {
		
		action.click(driver, addToCartBtn);
			
	}
	
	@SuppressWarnings("static-access")
	public boolean  validateRemoveBtn() {
		
		 action.isDisplayed(driver, removeBtn);
		 
		 return true;
			
	}
	
	public void clickonShopCartLnk() {
		action.JSClick(driver, shoppingCartLink);
	}
	
	public void selectLowestPriceItem() {
		Double minValue = 0.0;
		boolean isElementClicked = false;
		List<WebElement> priceList = driver.findElements(By.cssSelector("div.pricebar"));
		List<String> listOfPrices = priceList.stream()
			.map(ele -> ele.getText().trim())
			.filter(ele -> ele.length() > 2)
			.collect(Collectors.toList());
		if(listOfPrices.size() > 0) {
		System.out.println("price list");
		listOfPrices.forEach(System.out::println);
		List<Double> list = listOfPrices.stream()
			.map(ele -> ele.replace("Add to cart", "").trim())
			.map(ele -> ele.replace("$", ""))
			.map(ele -> Double.valueOf(ele))
			.collect(Collectors.toList());
		
		List<Double> sortedPrice = list.stream()
			.sorted()
			.collect(Collectors.toList());
		minValue = sortedPrice.get(0);
			for(WebElement element : priceList) {
				if(element.getText().contains(String.valueOf(minValue))) {
					element.findElement(By.tagName("button")).click();
					isElementClicked = true;
					break;
				}
			}
		
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isElementClicked) {
			return;
		}
		if(minValue == 0.0 && priceList.size()> 0) {
			priceList.get(0).click();
		}
		
	}
}
