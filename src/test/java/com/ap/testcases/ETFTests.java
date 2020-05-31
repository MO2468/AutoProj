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

public class ETFTests extends TestBase {
	HomePage hp;
	TopETFPage etf;
	
	public ETFTests(){
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
	
	@Test(priority=3, enabled=true)//positive
	public void applyETFFilterspos() throws InterruptedException{
		etf =hp.clickonTopETF();
		etf.clickEditButton();
		etf.selectPriceBetween("5","20");
		Thread.sleep(1000);
		String results = etf.estimatedResults();
		System.out.println(results);
		}
	
	@Test(priority=4, enabled=true)//negative
	public void applyETFFiltersneg1() throws InterruptedException{
		etf =hp.clickonTopETF();
		etf.clickEditButton();
		etf.selectPriceBetween("ab","20");
		Thread.sleep(2000);
		String results = etf.estimatedResults();
		Assert.assertEquals(results, "27");/*default will change to 27 due to fields
												not accepting spec char*/
	}
	
	@Test(priority=5, enabled=true)//negative
	public void applyETFFiltersneg2() throws InterruptedException{
		etf =hp.clickonTopETF();
		etf.clickEditButton();
		etf.selectPriceBetween("%!?","20");
		Thread.sleep(2000);
		String results = etf.estimatedResults();
		Assert.assertEquals(results, "27");
	}
	@Test(priority=6, enabled=true)//negative
	public void applyETFFiltersneg3() throws InterruptedException{
		etf =hp.clickonTopETF();
		etf.clickEditButton();
		etf.selectPriceBetween(" ","20");
		Thread.sleep(2000);
		String results = etf.estimatedResults();
		Assert.assertEquals(results, "433");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
