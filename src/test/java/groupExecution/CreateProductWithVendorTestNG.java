package groupExecution;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtigers.ObjectRepository.CreateNewProductPage;
import vtigers.ObjectRepository.CreateNewVendoPage;
import vtigers.ObjectRepository.HomePage;
import vtigers.ObjectRepository.ProductInfoPage;
import vtigers.ObjectRepository.ProductsPage;
import vtigers.ObjectRepository.VendorInfoPage;
import vtigers.ObjectRepository.VendorsPage;

public class CreateProductWithVendorTestNG extends BaseClass {
	@Test(groups = "SmokeTesting")
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
		Reporter.log("create vendor look up img clicked",true);
		//CREATE A NEW VENDOR
		CreateNewVendoPage cvp=new CreateNewVendoPage(driver);
		cvp.createNewVendor(VENDORNAME);
		Reporter.log("Vendor created successfully");
		//VERRIFICATION
		VendorInfoPage vip=new VendorInfoPage(driver);
		String vendorHeader = vip.getVendorText();
		Assert.assertTrue(vendorHeader.contains(VENDORNAME));
		
		//NAVIGATE TO PRODUCT PAGE
		hp.clickOnProductLink();
		Reporter.log("clicked on product link",true);
		//NAVIGATE TO CREATE NEW PRODUCT PAGE
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnCreateProductLookupImg();
		
		Reporter.log("clicked on create product look up image",true);
		//CREATE A NEW PRODUCT WITH VENDOR NAME
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME, driver, VENDORNAME);
		Reporter.log("product created successfully",true);
		//VERRIFICATION
		ProductInfoPage pip=new ProductInfoPage(driver);
		String productHeader = pip.getProductHeaderText();
		Assert.assertTrue(productHeader.contains(PRODUCTNAME));
	}

}
