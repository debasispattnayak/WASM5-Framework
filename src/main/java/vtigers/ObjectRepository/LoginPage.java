package vtigers.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1: create separate class for every page
	
	//identify the elements using @FindBy,@FindBys,@FindAll and store it and declare
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//rule 3: create a constructor for initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//rule4: provide getter methods to access elements
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//step5: business library
	
	/** This method will perform login to application
	 * @author DEV
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	
	
	
	


}
