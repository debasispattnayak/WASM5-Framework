package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigers.ObjectRepository.LoginPage;

public class LoginPagePOM {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LoginPage lp=new LoginPage(driver);
		
		lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();
		
		//ALTERNATE WAY BY USING BUSINESS LIBRARY
		
		//lp.loginToApp("admin", "admin");
		
		

	}

}
