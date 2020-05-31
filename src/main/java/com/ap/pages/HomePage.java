package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//li[@data-subnav-type='networknav_root-6']/a[1]")
	WebElement MarketsNav;
	@FindBy(xpath="//*[@id='Nav-0-DesktopNav']/div/div[3]/div/nav/ul/li[6]/a")
	WebElement CalendarDropdown;
	@FindBy(css="a[title='Top ETFs']")
	WebElement etfButton;
	
	@FindBy(css="a[title='Cryptocurrencies']")
	WebElement Crypto; 
	
	@FindBy(css="a[title='checkbox-unchecked']")
	WebElement Boxes;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		}
	
	
	public CalendarPage clickonCalendar() throws InterruptedException{
		Actions action = new Actions(driver);
		
		action.moveToElement(MarketsNav).build().perform();
		Thread.sleep(4000);
		action.moveToElement(CalendarDropdown).click().build().perform();
		return new  CalendarPage();
	}
	public CalendarPage clickonMarkets(){
		MarketsNav.click();
		return new CalendarPage();
	}
	
	public TopETFPage clickonTopETF(){
		Actions a = new Actions(driver);
		a.moveToElement(MarketsNav).build().perform();
		a.moveToElement(etfButton).click().build().perform();
		return new TopETFPage();
	}
	
	public CryptoCurrencyPage clickOnCrypto() {
		Actions a = new Actions (driver);
		a.moveToElement(MarketsNav).build().perform();
		a.moveToElement(Crypto).click().build().perform();
		return new CryptoCurrencyPage();
	}
	
	
	
	
	
}
