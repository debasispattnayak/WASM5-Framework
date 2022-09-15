package vtiger.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
		WebElement ele = driver.findElement(By.name("salutationtype"));
		Select drop=new Select(ele);
		List<WebElement> elements=drop.getOptions();
		elements.get(1).click();
		driver.findElement(By.name("firstname")).sendKeys("Rajath");
		driver.findElement(By.name("lastname")).sendKeys("H M");
	
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//LOGOUT
	 	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 	Actions a=new Actions(driver);
	 	a.moveToElement(logout).perform();
	 	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	 	
	 	//CLOSE BROWSER
	 	driver.close();
	 	System.out.println("Contact created");
		

	}

}
