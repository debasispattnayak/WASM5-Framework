package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductLookupImg;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookupImg() {
		return createProductLookupImg;
	}
	
	//BUSINESS LIBRARY
	
	/**
	 * This method will navigate to create new product page
	 */
	public void clickOnCreateProductLookupImg()
	{
		createProductLookupImg.click();
	}
}
