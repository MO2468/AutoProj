package com.ap.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.CalendarPage;
import com.ap.pages.HomePage;

public class CalendarTest extends TestBase {

	
	HomePage hp;
	CalendarPage calp;
	public CalendarTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setupDriver(){
		initBrowser();
		hp= new HomePage();
		calp= new CalendarPage();
	}
	
	@Test(priority=2)
	public void verifycurrentDate() throws InterruptedException{
		hp.clickonCalendar();
	}
	@Test(priority=1)
	public void verifycurrentDate2(){
		hp.clickonMarkets();
	}
	@Test(priority=3)
	public void verifydetails(){
		hp.clickonMarkets();
		calp.curentDatedetails();
	}

}
