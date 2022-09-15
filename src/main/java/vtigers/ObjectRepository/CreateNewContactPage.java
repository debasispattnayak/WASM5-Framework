package vtigers.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//DECLARATION
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgNameLookupImg;
	
	@FindBy(id="search_txt")
	private WebElement orgNameSearchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//INITIALIZATION
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getOrgNameLookupImg() {
		return orgNameLookupImg;
	}

	public WebElement getOrgNameSearchEdt() {
		return orgNameSearchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return orgSearchBtn;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
		//BUSINESS LIBRARY
	
	/**
	 * This method will create contact with organizaton name
	 * @param lastname
	 * @param driver
	 * @param orgName
	 */
	public void createNewContactWithOrg(String lastname,WebDriver driver,String orgName)
	{
		lastnameEdt.sendKeys(lastname);
		orgNameLookupImg.click();
		switchToWindow(driver, "Accounts");
		orgNameSearchBoxEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); //DYNAMIC XPATH
		switchToWindow(driver,"Contacts");
		saveBtn.click();	
	}
	

}
