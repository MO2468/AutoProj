package com.ap.testcases;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.TopETFPage;

public class HomePageTests extends TestBase {
	HomePage hp;
	TopETFPage etf;
	
	public HomePageTests(){
		super();
	}
	
	@BeforeMethod
	public void startUp(){
		initBrowser();
		hp=new HomePage();
	}
	
	@Test(priority=1, enabled=true)
	public void landingPage(){
		String title=driver.getTitle();
		Assert.assertEquals(title, "Yahoo Finance - Stock Market Live, Quotes, Business & Finance News");
	}
	
	@Test(priority=2, enabled=true)
	public void clickonTopETFButton(){
		hp.clickonTopETF();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe("https://finance.yahoo.com/etfs"));
		String title=driver.getTitle();
		Assert.assertEquals(title, "Top ETFs Today - Yahoo Finance");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
