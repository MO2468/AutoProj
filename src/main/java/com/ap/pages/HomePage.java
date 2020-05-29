package com.ap.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ap.base.TestBase;

import Data.HeaderTitleArrays;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//li[@data-subnav-type='networknav_root-6']/a[1]")
	WebElement MarketsNav;
	@FindBy(xpath="//a[contains(@title,'Calendars')]")
	WebElement CalendarDropdown;
	@FindBy(css="a[title='Top ETFs']")
	WebElement etfButton;
	@FindBy(css="li[class='nr-applet-main-nav-item Pend(navPaddings) Whs(nw) Fl(start) H(itemHeight) H(itemHeight_uhMagDesign)! Pend(30px)! closed-subnav']")
	List<WebElement> headerLinks;
	
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
	
	public TopETFPage clickonTopETF(){
		Actions a = new Actions(driver);
		a.moveToElement(MarketsNav).build().perform();
		a.moveToElement(etfButton).click().build().perform();
		return new TopETFPage();
	}
	
	public void clickAllHeaderLinks() throws InterruptedException{
		HeaderTitleArrays htarray = new HeaderTitleArrays();
		for(int i=0;i<9;i++){
			if(i==7){//skips personal finance header since it opens in new tab
				continue;
			}
			headerLinks.get(i).click();
			Thread.sleep(3000);
			String title=driver.getTitle();
			System.out.println(title);
			Thread.sleep(3000);
			Assert.assertEquals(htarray.HeaderTitles[i], title);
			driver.navigate().to(propt.getProperty("url"));
	
		}
	}

	
}
