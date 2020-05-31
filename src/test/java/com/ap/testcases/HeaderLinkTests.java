package com.ap.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;

public class HeaderLinkTests extends TestBase{
	HomePage hp;
	
	public HeaderLinkTests(){
		super();
	}
	
	@BeforeMethod
	public void startUp(){
		initBrowser();
		hp=new HomePage();
	}
	
	@Test
	public void validateHeaderLinks() throws InterruptedException{
			hp.clickAllHeaderLinks();
			
			}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
