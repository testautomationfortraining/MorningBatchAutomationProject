package com.banking.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.HomePage;
import com.banking.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=0)
	public void verifyTitle() {	
		Assert.assertEquals(loginPage.verifyLoginPageTitle(), "Guru99 Bank Home Page"); 
	}

	@Test(priority=1)
	public void verifyLogo() {
		Assert.assertTrue(loginPage.verifyLoginPageLogo());
	}
	
	
	@Test(priority=2)
	public void loginToApp() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
