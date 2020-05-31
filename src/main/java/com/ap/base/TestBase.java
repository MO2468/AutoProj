package com.ap.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.utilities.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;
	public static WebEventListener eventListener;
	
public TestBase(){
	FileInputStream fis;
	try {
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/config/config.properties");
	
	propt= new Properties();
	propt.load(fis);
	} catch (FileNotFoundException e) {
		System.out.println("config file not found");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("unable to load config file");
		e.printStackTrace();
	}
}

public static String machineType()
{
	String machine = propt.getProperty("machine");
	if (machine.equalsIgnoreCase("mac"))
	{
		String macMachine = System.getProperty("user.dir") +"/src/main/resources/chromedriver";
		return macMachine;
	}
	else 
	{
		String windowMachine = System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe";
		return windowMachine;
	}	
}

public static void initBrowser(){
	String browser= propt.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", machineType() );
		driver=new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox")){
		
		driver= new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("ie")){
		//ie
	}
	en_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	en_driver.register(eventListener);
	
	driver= en_driver;
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	driver.get(propt.getProperty("url"));

}
	
}
