package groupExecution;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.OrgInfoPage;
import vtigers.ObjectRepository.OrganizationPage;
import vtigers.ObjectRepository.createNewOrgPage;

public class CreateOrgTest extends BaseClass {
	
	
	
	@Test(groups = "SmokeTesting")
	public void createOrg() throws EncryptedDocumentException, IOException
	{
		//READ TEST DATA
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcel("Organization",1, 3);
		
		//NAVIGATE TO ORG PAGE
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("clicked on org link",true);
		
		//NAVIGATE TO ORG PAGE
		
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrganization();
		//NAVIGATE TO NEW ORG PAGE
		createNewOrgPage cnp=new createNewOrgPage(driver);
		cnp.createOrganization(ORGNAME, INDUSTRY);
		Reporter.log("ORG CREATED",true);
		
		//VERRICATION
		OrgInfoPage oip=new OrgInfoPage(driver);
		String orgHeaderText = oip.getOrgHeaderText();
		Assert.assertTrue(orgHeaderText.contains(ORGNAME));
	
	}
	
//	@Test(groups = "RegionaRegression")
//	public void DemoTesting()
//	{
//		Reporter.log("Demo testing done",true);
//	}

}
