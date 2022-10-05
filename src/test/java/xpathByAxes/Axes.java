package xpathByAxes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Axes {
	public static void main(String[] args) {
		
		
		String country="South Africa";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
		String rating=driver.findElement(By.xpath("//span[text()='"+country+"']/../following-sibling::td[3]")).getText();
		System.out.println("Rating is "+rating);
		
		driver.quit();
	}

}
