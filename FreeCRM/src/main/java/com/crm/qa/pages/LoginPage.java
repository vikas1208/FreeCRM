package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="//div[@class='navbar-header']//img[@class='img-responsive']")
	WebElement crmLogo;	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLogin() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		 return crmLogo.isDisplayed();
	}
	
	public HomePage login(String user,String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		Thread.sleep(4000);
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
}
