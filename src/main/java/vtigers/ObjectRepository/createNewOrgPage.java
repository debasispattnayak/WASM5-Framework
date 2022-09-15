package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class createNewOrgPage extends WebDriverUtility {
	
	//DECLARATION
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industyDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//INITIALIZATION
	public createNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION

	public WebElement getOrgName() {
		return orgNameEdt;
	}

	public WebElement getIndustyDropdown() {
		return industyDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
		//BUSINESS LIBRARY
	
	/**
	 * This method will create a new organization with orgName,Industry dropdown and Type dropdown
	 * @param orgName
	 * @param industryType
	 * @param type
	 */
	public void createOrganization(String orgName,String industryType,String type)
	{
		orgNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industyDropdown);
		handleDropDown(type, typeDropdown);	
		saveBtn.click();
	}
	/**
	 * This method will create a new organization with orgName,Industry dropdown
	 * @param orgName
	 * @param industryType
	 */
	public void createOrganization(String orgName,String industryType)
	{
		orgNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industyDropdown);
		saveBtn.click();
	}
	
	
	
	

}
