package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	LoginPage lpage;
	HomePage hpage;
	ContactsPage cpage;
	TestUtil tutil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialize();
		lpage = new LoginPage();
		tutil = new TestUtil();
		tutil.switchToFrame();
		hpage = lpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title = hpage.validateHomepageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel(){
		Boolean flag = hpage.ValidateUserNameLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void verifyContactsLink(){
		cpage = hpage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}
}
