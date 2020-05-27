package com.ap.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//li[@data-subnav-type='networknav_root-6']/a[1]")
	WebElement MarketsNav;
	
	@FindBy(xpath="//a[contains(@title,'Calendars')]")
	WebElement CalendarDropdown;
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	public CalendarPage clickonCalendar() throws InterruptedException{
		Actions action = new Actions(driver);
		
		action.moveToElement(MarketsNav).build().perform();
		Thread.sleep(4000);
		action.keyDown(Keys.ARROW_DOWN).click().build().perform();
		return new  CalendarPage();
	}
	public CalendarPage clickonMarkets(){
		MarketsNav.click();
		return new CalendarPage();
	}
	
	
	
	
	
	
	
}
