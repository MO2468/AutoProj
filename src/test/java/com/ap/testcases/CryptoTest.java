package com.ap.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;

public class CryptoTest extends TestBase{

	HomePage hp;

	
	
	@BeforeMethod
	public void setupDriver(){
		initBrowser();
		hp= new HomePage();
	}

	@Test(priority=1)
	public void CryptoCurrencyPage(){
		hp.clickOnCrypto();
		
	
	
	}
}
