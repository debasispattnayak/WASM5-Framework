package vtiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class CreatingOrgTest {

	@Test
	public void createOrgTest() throws IOException, InterruptedException
	{
		
		
		WebDriver driver;
		
		//GENERATE RANDOM NUMBER TO AVOID DUPLICATE
		Random r=new Random();
		int random = r.nextInt(1000);
		
		//STEP1: READ FILE FROM EXTERNAL SOURCES
	
		//------FROM PROPERTY FILE-->COMMON DATA---
		FileInputStream fisp=new FileInputStream(".\\src\\main\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fisp);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String UN = pobj.getProperty("username");
		String PWD = pobj.getProperty("password");
		
		//-------FROM EXCEL FILE-->TEST DATA---------
		FileInputStream fise=new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sheet = wb.getSheet("Organization");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String orgname = cell.getStringCellValue();
		
		//STEP2: LAUNCH THE BROWSER --->RUN TIME PLOYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("Chrome browser launched successfully.");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			 driver=new FirefoxDriver();
			System.out.println("Firefox browser launched successfully");
		}
		else
		{
			System.out.println("invalid browser");
			//LAUNCH DEFAULT BROWSER
			driver=new ChromeDriver();
			System.out.println("Default chrome browser launched sucessfully");		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//STEP3: LOGIN TO APP
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//STEP4: NAVIGATE TO ORGANIZATION
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//STEP5: NAVIGATE TO CREATE ORGANIZATION
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//STEP6: CREATE ORGANIZATION WITH MANDATORY FIELD
		driver.findElement(By.name("accountname")).sendKeys(orgname+random);
		
		//STEP7: SAVE
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		//LOGOUT
		Thread.sleep(4000);
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 	Actions a=new Actions(driver);
	 	a.moveToElement(logout).perform();
	 	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
