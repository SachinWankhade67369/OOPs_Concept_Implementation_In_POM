package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;

	// create contractor of abstract class.

	public Page(WebDriver driver) {
	
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, 15);
		
	}

	//Abstracts Methods
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);//so we will create the getElement at run time.
	
	public abstract void waitForElementIsPresent(By locator);//wait for/until element present.
	
	public abstract void waitForPageTitle(String title);//wait for/until page title is displayed.
	
	
	//By using java generic
	//non abstract method
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
			
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	 
	
	
	
	
	
	
}
