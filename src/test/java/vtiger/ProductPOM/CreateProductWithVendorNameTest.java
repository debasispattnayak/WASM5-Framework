package vtiger.ProductPOM;

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
import vtigers.ObjectRepository.CreateNewProductPage;
import vtigers.ObjectRepository.CreateNewVendoPage;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.LoginPage;
import vtigers.ObjectRepository.ProductInfoPage;
import vtigers.ObjectRepository.ProductsPage;
import vtigers.ObjectRepository.VendorInfoPage;
import vtigers.ObjectRepository.VendorsPage;

public class CreateProductWithVendorNameTest extends BaseClass {
	@Test
	public void createProductWithVendorNameTest() throws IOException
	{
		
		//READ NECESSARY TEST DATA
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 1, 2)+jUtil.getRandomNumber();
		String VENDORNAME = eUtil.readDataFromExcel("Product", 1, 3);
		
		
		//NAVIGATE TO VENDOR PAGE
		HomePage hp=new HomePage(driver);
		hp.clickOnVendorsLink(driver);
		Reporter.log("clicked on vendor link",true);
		
		//NAVIGATE TO CREATE NEW VENDOR PAGE
		VendorsPage vp=new VendorsPage(driver);
		vp.clickOnCreateVendorLookupImg();
		//CREATE A NEW VENDOR
		CreateNewVendoPage cvp=new CreateNewVendoPage(driver);
		cvp.createNewVendor(VENDORNAME);
		//VERRIFICATION
		VendorInfoPage vip=new VendorInfoPage(driver);
		String vendorHeader = vip.getVendorText();
		if(vendorHeader.contains(VENDORNAME))
		{
			System.out.println("Vendor created sucessfully");
		}
		else
		{
			System.out.println("Vendor not created");
		}
		//NAVIGATE TO PRODUCT PAGE
		hp.clickOnProductLink();
		//NAVIGATE TO CREATE NEW PRODUCT PAGE
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnCreateProductLookupImg();
		//CREATE A NEW PRODUCT WITH VENDOR NAME
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME, driver, VENDORNAME);
		//VERRIFICATION
		ProductInfoPage pip=new ProductInfoPage(driver);
		String productHeader = pip.getProductHeaderText();
		if(productHeader.contains(PRODUCTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}
