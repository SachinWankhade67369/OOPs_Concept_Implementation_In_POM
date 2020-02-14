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
public class LoginPage extends BasePage{

	//Evaluating the Encapsulation concepts by making variables private and having access it through public methods.
	//Page locator
	private By emailId = By.id("email");
	private By password= By.id("password");
	private By loginButton = By.xpath("//button[@type='submit']"); 
	private By pageHeader = By.className("login-box-msg");
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}


	//getters

	/**
	 * @return the emailId
	 * It return WebElement so that we can directly perform .click or .sendkeys operations.
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}


	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}


	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
	
		return getElement(loginButton);
	}


	/**
	 * @return the pageHeader
	 */
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	//one more wrapper method for getPageTitle().
	public String getTheLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(pageHeader);//getPageHeader(By locator) method from Base class.
	}
	
	
	public HomePage doLogin(String username,String pwd) {
		
		getEmailId().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
		
		
	}
	
	//To achieve method Overloading,I have written some negative test cases for login method
	
	
	/**
	 * method Overloading-method name is same but the parameter is different.
	 * @return
	 */
	
	//doLogin with blank Username and password
	public void doLogin() {
		
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click();
		
	}
	
	//doLogin with correct username and blank password.
	//username:kiran@gmail.com
	public void doLogin(String userCredentials) {
		
		if(userCredentials.contains("username")) {
			getEmailId().sendKeys(userCredentials.split(":")[1].trim());
			
		}else if(userCredentials.contains("password")) {
			getPassword().sendKeys(userCredentials.split(":")[1].trim());
			
		}
		getLoginButton().click();	
		
	}

}
