package com.myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myPages.HomePage;
import com.myPages.LoginPage;

/**
 * 
 */

/**
 * @author SACHU
 *
 */
public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		String title = page.getInstance(LoginPage.class).getTheLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "AdminLTE 2 | Log in");
	}
	
	
	@Test(priority=2)
	public void verifyLoginPageHeader() {
		String header=page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Sign in to start your session");
	}
	
	@Test(priority=3)
	public void doLoginTest() {
		HomePage homepage=page.getInstance(LoginPage.class).doLogin("kiran@gmail.com", "123456");
		String header=homepage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Dashboard Control panel\n" + 
				"Home Dashboard");
	}
	
	@Test(priority=4)
	public void doLoginTestWithInvalidCredential() {
		page.getInstance(LoginPage.class).doLogin("kiran@gmail.com:");
		System.out.println("Error msg should be displayed.");
		
	}
	

}
