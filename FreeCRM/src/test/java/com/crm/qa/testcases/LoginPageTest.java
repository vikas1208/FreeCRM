package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homePage;
	
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginpage = new LoginPage(); 
		
	}
	
	@Test(priority=1)
	
	public void loginPageTitleTest() {
		String titlelogin= loginpage.validateLogin();
		Assert.assertEquals(titlelogin, "CRMPRO - CRM software for customer relationship management, sales, and support.");	
									
	}
	
	@Test(priority=2)
	
	public void crmLogoImageTest() {
	boolean flag =loginpage.validateCRMLogo();
	Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	
	public void loginTest() throws InterruptedException {
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
}
