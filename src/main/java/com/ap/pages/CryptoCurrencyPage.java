package com.ap.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class CryptoCurrencyPage extends TestBase{

	@FindBy(xpath="//input[@type='checkbox'])")
	List <WebElement> CheckBoxes; //creating a list, of webelements(which is a type of object), naming this list as checkbox
	

	
	public  CryptoCurrencyPage(){
		PageFactory.initElements(driver, this);
	}

	
	public void clickBoxes() {
	for (int i = 0; i <=5 ; i++) {  //control + space//
		CheckBoxes.get(i).click();
		
	}

		
	}
}
