package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//DECLARATION
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupIcon;
	
	//INTIALIZATION
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//UTILISATION
	
	public WebElement getCreateOrgLookupIcon() {
		return createOrgLookupIcon;
	}
	
		//BUSINESS LIBRARY
	
	/**
	 * This method will click on create organization look up icon
	 */
	
	public void  createOrganization()
	{
		createOrgLookupIcon.click();
	}
	
	
	
	

}
