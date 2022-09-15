package vtiger.ContactPOM;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtigers.ObjectRepository.ContactInfoPage;
import vtigers.ObjectRepository.ContactPage;
import vtigers.ObjectRepository.CreateNewContactPage;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.LoginPage;
import vtigers.ObjectRepository.OrgInfoPage;
import vtigers.ObjectRepository.OrganizationPage;
import vtigers.ObjectRepository.createNewOrgPage;

public class CreateContaactWithOrg extends BaseClass {
	@Test
	public void createContactWithOrg() throws IOException
	{	
		//READ ALL THE REQUIRED TEST DATA
		String ORGNAME = eUtil.readDataFromExcel("Contact",4, 3)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Contact", 4, 4);
		String TYPE = eUtil.readDataFromExcel("Contact", 4, 5);
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		 	
		
		//NVIGATE TO ORGANIZATIONLINK
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("clicked on orglink",true);
		
		//NAVIGATE TO CREATE NEW ORG PAGE
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrganization();
		Reporter.log("clicked on create org look up icon",true);
		
		
		//CREATE NEW ORGANIZATION
		createNewOrgPage cop=new createNewOrgPage(driver);
		cop.createOrganization(ORGNAME, INDUSTRY, TYPE);
		Reporter.log("organization created successfully",true);
		
		//VERRIFICATION
		OrgInfoPage oip=new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("===ORG CREATED===");
		}
		else
		{
			System.out.println("===ORG NOT CREATED");
		}
		
		//NAVIGATE TO CONTACT
		hp.clickOnContactLink();
		
		//NAVIGATE TO CREATE NEW CONTACT PAGE
		
		ContactPage cp=new ContactPage(driver);
		cp.clickOnContactLookup();
		
		//CREATE NEW CONTACT WITH ORGNAME
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContactWithOrg(LASTNAME, driver, ORGNAME);
		
		//VERRIFICATION
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		
		if(contactHeader.contains(LASTNAME))
		{
			Reporter.log("contact created:pass",true);
		}
		else
		{
			Reporter.log("contact not created: fail",true);
		}		
		
	}

}
