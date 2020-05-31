
//Premium test page
package com.ap.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;


public class PremiumTest extends TestBase {
	HomePage hp;
	//WebDriver driver;

	public PremiumTest() {
		super();// coming from TestBase constructor
	}

	@BeforeTest
	public void browserInitiazation() {
		initBrowser();// coming from TestBase method
	}

	@Test(priority = 1)
	public void hoverOnPrenium() {
		hp = new HomePage();
		hp.hoverOverPremium1();// coming from Homepage

	}

	@Test(priority = 2)
	public void PremList() {
		hp = new HomePage();
		hp.PremList1();
	}

	@Test(priority = 3)
	public void textPresent() {
		hp = new HomePage();
		hp.Try1();
		hp.textpresent();
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
		driver=null;
	}

}
