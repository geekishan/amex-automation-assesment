package com.shopping.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.shopping.actiondriver.SeleniumActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;

	public WebDriver driver;

	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void launchApp() {
		loadConfig();
		WebDriverManager.chromedriver().setup();
		// String browserName = prop.getProperty("browser");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\radha\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * if (browserName.contains("Chrome")) { driver = new ChromeDriver(); }else if
		 * (browserName.contains("FireFox")){ driver = new FirefoxDriver(); } else if
		 * (browserName.contains("IE")) { driver = new InternetExplorerDriver(); }
		 */

		SeleniumActions.implicitWait(driver, 10);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
