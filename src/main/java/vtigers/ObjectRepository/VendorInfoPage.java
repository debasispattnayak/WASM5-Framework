package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderTxt;
	
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorHeaderTxt() {
		return vendorHeaderTxt;
	}
	
	//BUSINESS LIBRARY
	/**
	 * This method will return vendor header text
	 * @return
	 */
	public String getVendorText()
	{
		return vendorHeaderTxt.getText();
	}
}

