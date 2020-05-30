package com.ap.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class CurrenciesPage extends TestBase{
	
	public CurrenciesPage()
	{
		PageFactory.initElements(driver, this);
	}
	//element of percentage change
	@FindBy(xpath="//span[text()='% Change']")
	WebElement percentageChange;
	//element of table
	@FindBy(xpath="//table[@class='yfinlist-table W(100%) BdB Bdc($tableBorderGray)']")
	WebElement currenciesTable;
	//elements of all rows
	@FindBy(xpath="//table[@class='yfinlist-table W(100%) BdB Bdc($tableBorderGray)']//tr")
	List<WebElement> rowsOfTable;
	@FindBy(xpath="/table[@class='yfinlist-table W(100%) BdB Bdc($tableBorderGray)']//tr//td")
	List<WebElement> tableColumns;
	
	public WebElement getPercentageChange()
	{
		return percentageChange;
	}
	
	public CurrenciesPage clickPercentageChange()
	{
		percentageChange.click();
		return this;
	}
	public List<WebElement> getTableRows()
	{
		return rowsOfTable;
	}
	public List<WebElement> getTableColoumns()
	{
		return tableColumns;
	}
	
}
