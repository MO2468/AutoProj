package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class CalendarPage    extends TestBase{
	
	@FindBy(css="li[class*='Bgc($lightBlue)']")
	WebElement currentDatehover;
	
	
public CalendarPage(){
PageFactory.initElements(driver,this);
}


public void curentDatedetails(){
	System.out.println(currentDatehover.getText());
	

}
}
