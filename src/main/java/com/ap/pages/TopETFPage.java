package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class TopETFPage extends TestBase{
	@FindBy(css="")
	WebElement a;
	
public  TopETFPage(){
	PageFactory.initElements(driver, this);
}	
	
	
	
	
	
}
