package com.ap.pages;

import java.util.List;

=======
import org.junit.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.ap.base.TestBase;
import Data.HeaderTitleArrays;


public class HomePage extends TestBase {

	@FindBy(xpath = "//li[@data-subnav-type='networknav_root-6']/a[1]")
	WebElement MarketsNav;
	@FindBy(xpath = "//a[contains(@title,'Calendars')]")
	WebElement CalendarDropdown;
	@FindBy(css = "a[title='Top ETFs']")
	WebElement etfButton;
  
  @FindBy(xpath = "//a[contains(text(),'Premium')]")
	WebElement PremiumNav;
	@FindBy(xpath = "//a[contains(@class,'nr-applet-nav-item Td(n) rapidnofollow nr-subnav-link D(ib) Lh(subNavItemHeight) W(100%) Ell Td(n)  Tt(n)! C($primaryColor) C(white)!:h Maw(200px)! C($finNavBlueText):h Maw(140px) Px(20px) C(darkTheme) Fz(13px)! Fw(b)!')]")
	List<WebElement> PremNavList;
	@FindBy(xpath = "//a[@href='/premium-marketing?ncid=userprofil_vzgptzawx38']")
	WebElement tryFree;
	@FindBy(xpath = "//strong[contains(text(),'During this difficult time, get an additional 20%')]")
	WebElement text;
	@FindBy(xpath="//button[@id='header-notification-button']")
	WebElement bell;
	@FindBy(xpath="//div[@id='header-notification-panel']")
	WebElement panel;
  @FindBy(css="li[class='nr-applet-main-nav-item Pend(navPaddings) Whs(nw) Fl(start) H(itemHeight) H(itemHeight_uhMagDesign)! Pend(30px)! closed-subnav']")
	List<WebElement> headerLinks;
	
	
  public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public CalendarPage clickonCalendar() throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(MarketsNav).build().perform();
		Thread.sleep(4000);
		action.keyDown(Keys.ARROW_DOWN).click().build().perform();
		return new CalendarPage();
	}

	public CalendarPage clickonMarkets() {
		MarketsNav.click();
		return new CalendarPage();
	}

	public TopETFPage clickonTopETF() {
		Actions a = new Actions(driver);
		a.moveToElement(MarketsNav).build().perform();
		a.moveToElement(etfButton).click().build().perform();
		return new TopETFPage();
	}

	public void hoverOverPremium1() {
		Actions action = new Actions(driver);
		action.moveToElement(PremiumNav).build().perform();

	}

	public void PremList1() {
		for (WebElement list : PremNavList) {
			Actions act = new Actions(driver);
			String strlinkText = list.getText();
			System.out.println(strlinkText);
			act.moveToElement(list).build().perform();
		}

	}

	public void Try1() {
		tryFree.click();
	}

	public void textpresent() {
		SoftAssert ass = new SoftAssert();
		String str = text.getText();
		ass.assertEquals(str,
				"During this difficult time, get an additional 20% off 3 months following the trial period.");
		ass.assertAll();
	}
	

	public void bellClick(){
		Actions act=new Actions(driver);
		act.moveToElement(bell).build().perform();;
	}
	public void panelDisplay(){
		panel.isDisplayed();
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
