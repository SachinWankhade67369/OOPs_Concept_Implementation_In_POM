/**
 * 
 */
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author SACHU
 *
 */
public class HomePage  extends BasePage{
	
	//Page Object
	private By homePageHeader = By.className("content-header");
		

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	
	public WebElement getPageHeader() {
		return getElement(homePageHeader);
	}
	
	//Page Actions
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return getPageHeader(homePageHeader);
	}

}
