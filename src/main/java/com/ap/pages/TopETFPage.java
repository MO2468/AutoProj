package com.ap.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.base.TestBase;

public class TopETFPage extends TestBase{
	@FindBy(css="button[class='Bgc($c-fuji-blue-1-b) Bgc($actionBlueHover):h C(white) Fw(500) Px(20px) Py(9px) Bdrs(3px) Bd(0) Fz(s) D(ib) Whs(nw) Miw(110px)']")
	WebElement editbttn;
	@FindBy(css="span[data-test='intradayprice-select-selected']")
	WebElement pricedropdown;
	@FindBy(xpath="//span[contains(text(),'between')]")
	WebElement betweenoption;
	@FindBy(xpath="//input[@class='Fz(s) Pstart(8px) H(28px) Mend(8px) W(80px) Bdc($c-fuji-grey-c) Bdc($c-fuji-blue-1-b):f']")
	WebElement price1stfield;
	@FindBy(xpath="//input[@class='Fz(s) Pstart(8px) H(28px) Mstart(10px) W(80px) Bdc($c-fuji-grey-c) Bdc($c-fuji-blue-1-b):f']")
	WebElement price2ndfield;
	@FindBy(xpath="//div[@class='Fw(b) Fz(36px)']")
	WebElement estresults;
	
public  TopETFPage(){
	PageFactory.initElements(driver, this);
}	
	
public void clickEditButton(){
	editbttn.click();
}

public void selectPriceBetween(String field1, String field2){
	pricedropdown.click();
	betweenoption.click();
	price1stfield.clear();//1st field has a default 10 value
	price1stfield.sendKeys(field1);
	price2ndfield.sendKeys(field2);
	
}

public String estimatedResults(){
	return estresults.getText();

}	
}
