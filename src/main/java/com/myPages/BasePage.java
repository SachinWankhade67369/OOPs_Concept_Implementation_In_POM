package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	//wrapper method created.
	@Override
	public WebElement getElement(By locator) {
		//Exception handing in frameworks
		WebElement element= null;
		try {
			element= driver.findElement(locator);
			return element;
			
		} catch (Exception e) {
			System.out.println("some error occured while creating element "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementIsPresent(By locator) {

		try {
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
		} catch (Exception e) {
			System.out.println("some exception/error occured while waiting for the element "+ locator.toString());
			e.printStackTrace();
		}
		
		
		
	}
 
	@Override
	public void waitForPageTitle(String title) {

		try {
			
			wait.until(ExpectedConditions.titleContains(title));
			
		} catch (Exception e) {
			System.out.println("some exception/error occured while waiting for the title "+ title);
			e.printStackTrace();
		}
 	}

}
