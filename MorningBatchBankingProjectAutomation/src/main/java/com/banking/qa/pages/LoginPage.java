package com.banking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Added comment to push the changes to repository
	
	//Object Repository
    @FindBy(xpath="//input[@name='uid']")
    WebElement username;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='btnLogin']")
    WebElement btnLogin;

    @FindBy(xpath="//h2[text()='Guru99 Bank']")
    WebElement logo;
    
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    //Actions
    public String verifyLoginPageTitle() {
    	return driver.getTitle();
    }
    
    public boolean verifyLoginPageLogo() {
    	return logo.isDisplayed();
    }
    
    public HomePage login(String un, String pwd) {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	btnLogin.click();
    	return new HomePage();
    }
    
}
