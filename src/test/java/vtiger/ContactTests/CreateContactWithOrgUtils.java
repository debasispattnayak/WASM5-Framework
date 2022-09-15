package vtiger.ContactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * 
 * @author DEV
 *
 */
public class CreateContactWithOrgUtils {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
		
		//STEP1: CREATE OBJECT OF GENERIC UTILITIES
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//STEP2: READ ALL NECESSARY DATA 
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String UN = pUtil.readDataFromPropertyFile("username");
		String PWD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		
		//STEP3: LAUNCH BROWSER
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("---chrome browser launched-------");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("----firefox browser launched----");
		}
		else
		{
			System.out.println("---invalid browser,chrome browser launched by default---");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		wUtil.maximizeBrowser(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
		//STEP4: LOGIN TO APPLICATION
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//STEP5: NAVIGATE TO ORGANIZATION
		driver.findElement(By.linkText("Organizations")).click();
		
		//STEP6:CLICK ON CREATE ORGANIZATION
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//STEP7: CREATE ORGANIZATION WITH MANDATORY FIELD AND SAVE
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
		System.out.println(orgHeader);
		System.out.println("PASS:---ORGANIZATION CREATED-----");
		}
		else
		{
			System.out.println("FAIL:---ORGANIZATION NOT CREATED-----");
		}
		
		//STEP8: NAVIGATE TO CONTACT
		driver.findElement(By.linkText("Contacts")).click();
		
		//STEP9: CLICK ON CREATE CONTACT
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//STEP10: CREATE CONTACT WITH MANDATORY FIELD AND ORGANIZATION
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
		
		//SWITCH CONTROL TO CHILD WINDOW AND SELECT ORG
		wUtil.switchToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//SWITCH CONTROL BACK TO PARENT WINDOW
		wUtil.switchToWindow(driver,"Contacts");
		
		//STEP11: CLICK ON SAVE
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME))
		{
		System.out.println(contactHeader);
		System.out.println("PASS:---CONTACT CREATED----");
		}
		else
		{
			System.out.println("FAIL:---CONTACT NOT CREATED----");
		}
		
		//STEP12:LOGOUT
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}

}
