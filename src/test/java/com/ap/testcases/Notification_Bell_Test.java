package com.ap.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;

public class Notification_Bell_Test extends TestBase {
	HomePage hp;
	//WebDriver driver;

	public  Notification_Bell_Test() {
		super();// coming from TestBase constructor
	}

	@BeforeTest
	public void browserInitiazation() {
		initBrowser();// coming from TestBase method
	}
@Test(priority=1)
public void Bellvalid(){
	hp=new HomePage();
	hp.bellClick();
}
@Test(priority=2)
public void displayPanel(){
	hp=new HomePage();
	hp.panelDisplay();
}
@AfterTest
public void closeBrowser(){
	driver.close();
	driver=null;
}


}
