package com.ap.testcases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.CurrenciesPage;
import com.ap.pages.HomePage;

public class CurrenciesTest extends TestBase{
	
	HomePage hp;
	Actions action;
	
	public CurrenciesTest()
	{
		super();
	}
	
	@BeforeTest
	public void initialization()
	{
		initBrowser();
		hp = new HomePage();
		action= new Actions(driver);
	}
	
	@Test
	public void validateFiveWorstCurrencies()
	{
		action.moveToElement(hp.getMarkets()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(hp.getCurrencies()));
		CurrenciesPage cp = hp.clickCurrencies();
		wait.until(ExpectedConditions.elementToBeClickable(cp.getPercentageChange()));
		cp.clickPercentageChange();
		//get the value from table
		for (int i=0; i<cp.getTableRows().size(); i++)
		{
		
		}
	}

}
