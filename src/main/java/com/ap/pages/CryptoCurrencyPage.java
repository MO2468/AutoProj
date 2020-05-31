package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class CryptoCurrencyPage extends TestBase{

	CryptoCurrencyPage ccp;
	
	@FindBy(css="svg[class*='checkbox-unchecked']")
	WebElement clickBox;
	
	public  CryptoCurrencyPage(){
		PageFactory.initElements(driver, this);
	}

	
	
}
