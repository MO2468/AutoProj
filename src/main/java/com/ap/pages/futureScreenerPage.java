package com.ap.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ap.base.TestBase;

public class futureScreenerPage extends TestBase{
	
	public futureScreenerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@data-test='label-filter-list']//div[@data-test='dropdown']")
	WebElement countryAddButton;
	
	@FindBy(xpath="//span[text()='Canada']")
	WebElement canada;
	
	@FindBy(xpath="//div[@data-test='region-filter-dd-menu']//button[contains(@class,'close')]")
	WebElement closeButton;
	
	@FindBy(xpath="//span[text()='Find ']//span[text()='Futures']")
	WebElement findFutureButton;
	
	public futureScreenerPage pageloadTimeout()
	{
		String currentURL = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(currentURL));
		return this;
	}
	
	public futureScreenerPage clickCoutnryAddButton() //synchornize wait for pageload
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		wait.until(ExpectedConditions.elementToBeClickable(countryAddButton)); 
		countryAddButton.click();
		return this;
	}
	public futureScreenerPage addCanada()
	{
		/*for (int i=0; i>countryName.size(); i++)
		{
			String countryText = countryName.get(i).getText();//comeback here to make canada(country) dynamic
					System.out.println(countryText);
			int j =0;
			if (countryText.equalsIgnoreCase("Canada"))
			{
				countryName.get(i).click();
			
				//if (j>arraysiz)
				//break
			}
		}*/
		canada.click();
		return this;
		
	}
	public futureScreenerPage clickCloseButton()
	{
		closeButton.click();
		return this;
	}
	public FutureScreenerResultPage clickFindFutureButton() 
	{
		findFutureButton.click();
		return new FutureScreenerResultPage();
	}

}
