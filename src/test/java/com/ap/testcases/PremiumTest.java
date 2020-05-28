
//Premium test page
package com.ap.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;

public class PremiumTest extends TestBase {
	HomePage hp;
	WebDriver driver;

	public PremiumTest() {
		super();// coming from TestBase constructor
	}

	@BeforeMethod
	public void browserInitiazation() {
		initBrowser();// coming from TestBase method
	}

	@Test
	public void hoverOnPrenium() {
		hp=new HomePage();
		hp.hoverOverPremium1();//coming from Homepage
		
		/*Actions action = new Actions(driver);
		action.moveToElement(hp.hoverOverPremium()).build().perform();
		return;*/
	}
}



