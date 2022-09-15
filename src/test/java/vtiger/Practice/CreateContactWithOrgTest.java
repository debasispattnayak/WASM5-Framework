package vtiger.Practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactWithOrgTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		//LOGIN
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//CLICK ON CONTACT MODULE
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
		//CLICK ON + ICON
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//SELECTING CONTACT TITLE FROM DROPDOWN
		WebElement ele = driver.findElement(By.name("salutationtype"));
		Select drop=new Select(ele);
		List<WebElement> elements=drop.getOptions();
		elements.get(1).click();
	
		//ENTER CONTACT FIRST AND LAST NAME
		driver.findElement(By.name("firstname")).sendKeys("Durga");
		driver.findElement(By.name("lastname")).sendKeys("Pal");
		
		//CLICK ON ORGNAME LOOK UP ICON AND HANDLE BOTH WINDOWS
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Set<String> windows = driver.getWindowHandles();
	 	Iterator<String> it = windows.iterator();
	 	String parentwindowid = it.next();
	 	String childwindowid = it.next();
	 	
	 	driver.switchTo().window(childwindowid);
	 	driver.findElement(By.xpath("//a[text()='TESLA']")).click();
	 	driver.switchTo().window(parentwindowid);
	 	
	 	//SAVE CONTACT
	 	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
	 	
	 	//LOGOUT
	 	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 	Actions a=new Actions(driver);
	 	a.moveToElement(logout).perform();
	 	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	 	
	 	//CLOSE BROWSER
	 	driver.close();
	 	System.out.println("Contact added successfully");

	}

}
