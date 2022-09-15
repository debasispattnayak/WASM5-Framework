package vtiger.ContactTests;
/**
 * @author DEV
 */
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

public class CreateContactTestByUtils {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		/*STEP1: Create Object for all utilities*/
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		/*STEP2: Read All the necessary data*/
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String UN = pUtil.readDataFromPropertyFile("username");
		String PWD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
		
		
		/*STEP3: Launch the browser*/
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("----chrome browser launched-------");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("----firefox browser launched------");
		}
		else
		{
			System.out.println("--Invalid Browser Name,Hence launched chrome bydefault----");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		wUtil.maximizeBrowser(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
		/*STEP4: Login to application*/
		
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		/*STEP5: Navigate to contacts*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*STEP6: click on create contact*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		/*STEP7: create contact with mandatory info*/
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		/*STEP8: save*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*STEP9: Logout*/
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
