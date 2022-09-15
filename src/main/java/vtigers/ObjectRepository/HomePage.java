package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility  { 
	
			/*WEBELEMENT ATTRIBUTES*/
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText   =   "Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opprtunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath = "//a[text()='Sign Out']")})
	private WebElement signoutLnk;
	
	@FindBy(xpath = "//a[.='More']")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLnk;
	
			/*CONSTRUCTOR*/
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
		/*GETTER METHODS*/
	
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getLeadLnk() {
		return leadLnk;
	}

	public WebElement getOpprtunitiesLnk() {
		return opprtunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}


	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	public WebElement getMoreLnk()
	{
		return moreLnk;
	}
	public WebElement getVendorsLnk()
	{
		return vendorsLnk;
	}

	              /*BUSINESS LIBRARY*/

	/**
	 * This method will perform Sign-out from application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, adminImg);
		signoutLnk.click();
	}
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrgLink()
	{
		organizationLnk.click();
	}
	/**
	 * This method will click on contact link
	 */
	public void clickOnContactLink()
	{
		contactLnk.click();
	}
	/**
	 * This method will click on vendors link
	 * @param driver
	 */
	public void clickOnVendorsLink(WebDriver driver)
	{
		mouseHoverOn(driver,moreLnk);
		vendorsLnk.click();
	}
	/**
	 * This method will click on products link
	 */
	public void clickOnProductLink()
	{
		productsLnk.click();
	}

}
