package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendoPage {
	//DECLARATION
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//INITIALIZATION
	
	public CreateNewVendoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
		//BUSINESS LIBRARY
	
	/**
	 * This method will create a new vendor with vendor name
	 * @param vendorName
	 */
	public void createNewVendor(String vendorName)
	{
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
	}
}
