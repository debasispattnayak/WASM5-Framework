package vtigers.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {
	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorNameLookup;
	
	@FindBy(id="search_txt")
	private WebElement vendorSearchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement vendorSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getVendorNameLookup() {
		return vendorNameLookup;
	}

	public WebElement getVendorSearchBoxEdt() {
		return vendorSearchBoxEdt;
	}

	public WebElement getVendorSearchBtn() {
		return vendorSearchBtn;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//BUSINESS LIBRARY
	
	/**
	 * This method will create a new product with vendor name
	 * @param productName
	 * @param driver
	 * @param vendorName
	 */
	public void createNewProduct(String productName,WebDriver driver,String vendorName)
	{
		productNameEdt.sendKeys(productName);
		vendorNameLookup.click();
		switchToWindow(driver, "Vendors");
		vendorSearchBoxEdt.sendKeys(vendorName);
		vendorSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+vendorName+"']")).click();
		switchToWindow(driver,"Products");
		saveBtn.click();
	}
}
