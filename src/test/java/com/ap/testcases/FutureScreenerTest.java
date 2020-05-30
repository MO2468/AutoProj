package com.ap.testcases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.FutureScreenerResultPage;
import com.ap.pages.HomePage;
import com.ap.pages.futureScreenerPage;

public class FutureScreenerTest extends TestBase{
	
	Actions action;
	HomePage hp;
	futureScreenerPage fs;
	FutureScreenerResultPage fsr;
	
	public FutureScreenerTest()
	{
		super();
	}
	
	@BeforeTest
	public void initialize()
	{
		initBrowser();
		hp = new HomePage();
		fs =new futureScreenerPage();
		action = new Actions(driver);
	}
	
	@Test
	public void validateUSandCanadaStocks()
	{
		action.moveToElement(hp.getScreeners()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(hp.getFutureScreener()));
		hp.clickOnFutureScreener().pageloadTimeout().clickCoutnryAddButton().addCanada().clickCloseButton().clickFindFutureButton().pageloadTimeout();
		fsr = new FutureScreenerResultPage();
		boolean stockChart = fsr.getResultTable().isDisplayed();
		Assert.assertTrue(stockChart);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
