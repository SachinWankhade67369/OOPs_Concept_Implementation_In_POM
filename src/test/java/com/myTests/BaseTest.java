/**
 * 
 */
package com.myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myPages.BasePage;
import com.myPages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author SACHU
 *
 */
public class BaseTest {

	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void EnvSetup(String browser) {
		
		//create driver instance
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); //WebDriverManager class is importing from bonigarcia/webdrivermanager dependency
			driver= new ChromeDriver();
		}else if(browser.contains("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("No browser is defining in xml file.");
		}
		
		
		driver.get("file:///G:/JAVA%20Material/Testing%20Material/Offline%20Website/index.html");
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//very important to initiate the Page abstract class whatever we are using,we are going to call constructor of Page class.
		//Because we have to pass driver to all the page classes so that they can used it.
		
		//page = new Page(); //is not possible because we can not create the object of abstract class
		//so create object of BasePage class by passing parameter as driver to the constructor
		page = new BasePage(driver);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
