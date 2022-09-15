package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	//DECLARATION
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorLookupImg;
	
	//INITIALIZATION
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION
	public WebElement getCreateVendorLookupImg() {
		return createVendorLookupImg;
	}
	
	//BUSINESS LIBRARY
	
	/**
	 * This method will navigate to create new vendor page
	 */
	public void clickOnCreateVendorLookupImg()
	{
		createVendorLookupImg.click();
	}
	
	
}
