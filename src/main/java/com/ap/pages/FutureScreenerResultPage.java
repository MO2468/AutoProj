package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ap.base.TestBase;

public class FutureScreenerResultPage extends TestBase {

public FutureScreenerResultPage()
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//table[@class='W(100%)']")
WebElement resultTable;

public FutureScreenerResultPage pageloadTimeout()
{
	String currentURL = driver.getCurrentUrl();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.urlMatches(currentURL));
	return this;
}

public WebElement getResultTable()
{
	return resultTable;
}

}
