package createOrgWithTestNGDataProvider;
/**
 * This class will run one test script multiple times with multiple set of data
 * By using DataProvider in TestNG 
 */
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.LoginPage;
import vtigers.ObjectRepository.OrgInfoPage;
import vtigers.ObjectRepository.OrganizationPage;
import vtigers.ObjectRepository.createNewOrgPage;

public class CreateMulOrgWithIndustry {
	
	WebDriver driver=null;
	
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	
	@Test(dataProvider = "orgNameAndIndustry")
	public void CreateOrgTest(String orgNAme,String industryType) throws IOException
	{
		//READ NECESSARY DATA
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=orgNAme+jUtil.getRandomNumber();
		//LAUNCH BROWSER
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome launched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("firefox launched successfully");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		wUtil.maximizeBrowser(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
		//LOGIN TO APPLICATION
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		//NAVIGATE TO ORGANIZATION PAGE
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		//NAVIGATE TO CREATE NEW ORG PAGE
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrganization();;
		//CREATE ORG WITH INDUSTRY TYPE
		createNewOrgPage cop=new createNewOrgPage(driver);
		cop.createOrganization(ORGNAME,industryType);
		//VERRIFICATION
		OrgInfoPage oip=new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		//LOGOUT
		hp.signOutOfApp(driver);
		}
	
	@DataProvider(name="orgNameAndIndustry")
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
		Object[][] data=eUtil.readMultipleDataFromExcel("MulOrgName");
		return data;
	}

}
