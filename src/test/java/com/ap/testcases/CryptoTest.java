package com.ap.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.base.TestBase;
import com.ap.pages.HomePage;
import com.ap.pages.CryptoCurrencyPage;
public class CryptoTest extends TestBase{

	HomePage hp;
	CryptoCurrencyPage ccp;

	
	
	
	public CryptoTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setupDriver(){
		initBrowser();
		hp= new HomePage();
	}

	
	@Test(priority=1)
	public void LandonCryptoCurrencyPage(){
	hp.clickOnCrypto();
	}

	@Test(priority=2)
	public void ClickCryptoBoxes(){
		ccp=hp.clickOnCrypto();
		ccp.clickBoxes();	
	}

	@AfterMethod
	public void closeDriver() {
	driver.quit();	
	}
	
	


}
