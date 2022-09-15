package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderTxt;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeaderTxt() {
		return productHeaderTxt;
	}
	
	//BUSINESS LIBRARY
	
	/**
	 * This method will return product header text
	 * @return
	 */
	public String getProductHeaderText()
	{
		return productHeaderTxt.getText();
	}
}
