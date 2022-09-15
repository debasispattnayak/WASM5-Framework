package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//DECLARATION
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookupimg;
	
	//INITIALIZATION
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION
	
	public WebElement getCreateContactLookupimg() {
		return createContactLookupimg;
	}
	
	//BUSINESS LIBRARY
	
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnContactLookup()
	{
		createContactLookupimg.click();
	}
}
