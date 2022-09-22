package calendorPopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {
	
	@Test
	public void bookTicket() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		
		//driver.findElement(By.id("//a[@class='close']")).click();
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("chennai");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("mumbai");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Sep 28 2022']")).click();
		
		//to click on future date
//		while(true)
//		{
//			try
//			{
//				driver.findElement(By.xpath("//div[@aria-label='Fri Dec 02 2022']")).click();
//				break;
//			}
//			catch(Exception e)
//			{
//				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//			}
//		}
	}

}
