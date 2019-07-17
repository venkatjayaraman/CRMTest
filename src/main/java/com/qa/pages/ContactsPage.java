package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(.,'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Savebtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactslabel(){
		return ContactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void ValidateCreateNewContact(String title, String Fname, String LName, String Cmpny){
	   Select select = new Select(driver.findElement(By.name("title")));
	   select.selectByVisibleText(title);
	   firstName.sendKeys(Fname);
	   lastName.sendKeys(LName);
	   company.sendKeys(Cmpny);
	   Savebtn.click();
	}

}
