package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.LoginPage;
/**
 * This class contains basic configuration annotations for common functionalities like
 * connect to database ,launch the browser etc.
 * @author DEV
 *
 */
public class BaseClass {
	
	public DataBaseUtility dUtil=new DataBaseUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	
	@BeforeSuite(groups = {"SmokeTesting","RegressionTesting"})
	public void bsConfig() throws SQLException
	{
		//dUtil.connectToDB();
		Reporter.log("---Database suceessfully connected----",true);
	}
	
	
	//@Parameters("BROWSER")    //ONLY FOR CROSS BROWSER EXECUTION
	//@BeforeTest     
	@BeforeClass(groups = {"SmokeTesting","RegressionTesting"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("---Browser "+BROWSER+" launched successfully",true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("---Browser "+BROWSER+" launched successfully",true);		
		}
		else
		{
			Reporter.log("Invalid browser name,Browser launch failed",true);
		}	
		sdriver=driver;
		wUtil.maximizeBrowser(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups = {"SmokeTesting","RegressionTesting"})
	public void bmConfig() throws IOException
	{
		String UN = pUtil.readDataFromPropertyFile("username");
		String PWD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UN,PWD);
		Reporter.log("Successfully logged in to application",true);
	}
	
	@AfterMethod(groups = {"SmokeTesting","RegressionTesting"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("successfully signed out from application",true);
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeTesting","RegressionTesting"})
	public void acConfig()
	{
		driver.close();
		Reporter.log("browser closed successfully",true);
	}
	@AfterSuite(groups = {"SmokeTesting","RegressionTesting"})
	public void asConfig() throws SQLException
	{
		//dUtil.closeDB();
		Reporter.log("database connection closed",true);
	}
}
