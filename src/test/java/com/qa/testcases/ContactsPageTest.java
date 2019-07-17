package com.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage lpage;
	HomePage hpage;
	ContactsPage cpage;
	TestUtil tutil;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialize();
		lpage = new LoginPage();
		cpage = new ContactsPage();
		tutil = new TestUtil();
		hpage = lpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		tutil.switchToFrame();
		hpage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabel(){
		Assert.assertTrue(cpage.validateContactslabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		cpage.selectContactsByName("test test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		cpage.selectContactsByName("test test2");
		cpage.selectContactsByName("track set");
	}
	
//	@Test(priority=4)
//	public void verifyCreateNewContact(){
//		hpage.clickOnNewContactsLink();
//		cpage.ValidateCreateNewContact("Mr.", "Nick", "Gotham", "Google");
//	}
	
	@DataProvider
	public Object[][] getExcelData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=5, dataProvider="getExcelData")
	public void VerifyNewContactAdd(String title, String firstName, String lastName, String company){
		hpage.clickOnNewContactsLink();
		cpage.ValidateCreateNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}
}
