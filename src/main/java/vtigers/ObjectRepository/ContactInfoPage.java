package vtigers.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//DECLARATION
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderTxt;
	
	//INITIALISATION
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//UTILISATION
	
	public WebElement getContactHeaderTxt() {
		return contactHeaderTxt;
	}
	
	//BUSINESS LIBRARY
	/**
	 * This method will return contact header text
	 * @return
	 */
	 public String getContactHeaderText()
	 {
		 return contactHeaderTxt.getText();
	 }
}
