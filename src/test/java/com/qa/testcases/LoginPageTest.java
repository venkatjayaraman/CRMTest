package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lpage;
	HomePage hpage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialize();
		lpage = new LoginPage();
	}
	
	@Test
	public void verifyLoginPageTitle(){
		String title = lpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void verifycrmLogo(){
		Boolean flag = lpage.validateCRMLogoTest();
		Assert.assertTrue(flag);
    }
	
	@Test
	public void LoginTest(){
		hpage = lpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
}
