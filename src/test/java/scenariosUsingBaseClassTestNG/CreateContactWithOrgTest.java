package scenariosUsingBaseClassTestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateContactWithOrgTest extends BaseClass{
	
	@Test
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException
	{	
		//READ TEST DATA	
	String ORGNAME = eUtil.readDataFromExcel("Contact",4, 3)+jUtil.getRandomNumber();
	String INDUSTRY = eUtil.readDataFromExcel("Contact", 4, 4);
	String TYPE = eUtil.readDataFromExcel("Contact", 4, 5);
	String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
	 	
	//NVIGATE TO ORGANIZATIONLINK
	HomePage hp=new HomePage(driver);
	hp.clickOnOrgLink();
	
	
	//NAVIGATE TO CREATE NEW ORG PAGE
	OrganizationPage op=new OrganizationPage(driver);
	op.createOrganization();
	
	//CREATE NEW ORGANIZATION
	createNewOrgPage cop=new createNewOrgPage(driver);
	cop.createOrganization(ORGNAME, INDUSTRY, TYPE);
	
	//VERRIFICATION
	OrgInfoPage oip=new OrgInfoPage(driver);
	String orgHeader = oip.getOrgHeaderText();
	if(orgHeader.contains(ORGNAME))
	{
		Reporter.log("Organization created successfully",true);
	}
	else
	{
		Reporter.log("Organization not created",true);
	}
	
	//NAVIGATE TO CONTACT
	hp.clickOnContactLink();
	Reporter.log("clicked in contact link",true);
	
	//NAVIGATE TO CREATE NEW CONTACT PAGE
	
	ContactPage cp=new ContactPage(driver);
	cp.clickOnContactLookup();
	Reporter.log("clicked on create contact look up img",true);
	
	//CREATE NEW CONTACT WITH ORGNAME
	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.createNewContactWithOrg(LASTNAME, driver, ORGNAME);
	
	
	//VERRIFICATION
	ContactInfoPage cip=new ContactInfoPage(driver);
	String contactHeader = cip.getContactHeaderText();
	
	if(contactHeader.contains(LASTNAME))
	{
		Reporter.log("contact created successfully",true);
	}
	else
	{
		Reporter.log("contact not created",true);
	}	
	
  }
	
}

