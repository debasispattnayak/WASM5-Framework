package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	//DECLARATION
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;
	
	//INITIALIZATION
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILISATION
	
	public WebElement getOrgHeaderTxt() {
		return orgHeaderTxt;
	}
	
		//BUSINESS LIBRARY
	
	/**
	 * This method will return orgHeader Text
	 * @return
	 */
	public String getOrgHeaderText()
	{
		return orgHeaderTxt.getText();
	}
	
	
}
