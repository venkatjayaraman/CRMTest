package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory- Object Repository(OR)
	
	@FindBy(xpath="//td[contains(.,'Venkataramani')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement contactslink;
	
	@FindBy(xpath="//a[.='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath="//a[.='Tasks']")
	WebElement taskslink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomepageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateUserNameLabel(){
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		taskslink.click();
		return new TasksPage();
	}

	public ContactsPage clickOnNewContactsLink(){
		Actions act = new Actions(driver);
		act.moveToElement(contacts).perform();
		act.moveToElement(contactslink).click().perform();
		return new ContactsPage();
	}
}
