package com.banking.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.banking.qa.base.TestBase;
import com.banking.qa.pages.DeleteCustomerPage;
import com.banking.qa.pages.HomePage;
import com.banking.qa.pages.LoginPage;

public class DeleteCustomerPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	public DeleteCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		deleteCustomerPage=homePage.navigateToDeleteCustomerPage();
	}
	
	@Test(priority=0)
	public void validateTitle() {
		Assert.assertEquals(deleteCustomerPage.validateDeleteCustomerTitle(), "Guru99 Bank Delete Customer Page");
	}
	
	@Test(priority=1)
	public void deleteCustomer() {
		deleteCustomerPage.deleteCustomer(prop.getProperty("customerId"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
