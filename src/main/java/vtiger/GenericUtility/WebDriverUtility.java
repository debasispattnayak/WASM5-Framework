package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains WebDriver specific generic methods
 * @author DEV
 *
 */
public class WebDriverUtility {

		/**
		 * This method will maximize the browser window
		 * @param driver
		 */
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void waitForElementsToLoadInDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for a particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToLoad(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This is a custom wait method.
	 * If element found it will click else it will wait 1 second until loop ends
	 * @param element
	 * @throws InterruptedException
	 */
	 public void customWaitAndClickOnElement(WebElement element) throws InterruptedException
	 {
		 int i=0;
		 while(i<10)
		 {
			 try
			 {
				 element.click();
				 break;
			 }
			 catch(Exception e)
			 {
				 Thread.sleep(1000);
				 i++;
			 }
		 }
	 }
	 /**
	  * This method will handle drop down by select class using index
	  * @param element
	  * @param index
	  */
	 public void handleDropDown(WebElement element,int index)
	 {
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
	 }
	 /**
	  * This method will handle drop down by select class using value
	  * @param element
	  * @param index
	  */
	 public void handleDropDown(WebElement element,String value)
	 {
		 Select sel=new Select(element);
		 sel.selectByValue(value);
	 }
	 /**
	  * This method will handle drop down by select class using visibleText
	  * @param element
	  * @param index
	  */
	 public void handleDropDown(String visibleText,WebElement element)
	 {
		 Select sel=new Select(element);
		 sel.selectByVisibleText(visibleText);
	 }
	 /**
	  * This method will perform double click over a page
	  * @param driver
	  */
	 public void doubleClickOn(WebDriver driver)
	 {
		 Actions a=new Actions(driver);
		 a.doubleClick().perform();
	 }
	 /**
	  * This method will perform double click on particular element
	  * @param driver
	  * @param element
	  */
	 public void doubleClickOn(WebDriver driver,WebElement element)
	 {
		 Actions a=new Actions(driver);
		 a.doubleClick(element).perform();
	 }
	 /**
	  * This method will perform mousehover action on particular element
	  * @param driver
	  * @param element
	  */
	 public void mouseHoverOn(WebDriver driver,WebElement element)
	 {
		 Actions a=new Actions(driver);
		 a.moveToElement(element).perform();	 
	 }
	 /**
	  * This method will perform mousehover action over the offset
	  * @param driver
	  * @param x
	  * @param y
	  */
	 public void mouseHoverOn(WebDriver driver,int x,int y)
	 {
		 Actions a=new Actions(driver);
		 a.moveByOffset(x, y).perform();;
	 }
	 /**
	  * This method will perform right click on page
	  * @param driver
	  */
	 public void rightClickOn(WebElement element,WebDriver driver)
	 {
		 Actions a=new Actions(driver);
		 a.contextClick(element).perform();
	 }
	 /**
	  * This method will perform right click on a particular element
	  * @param driver
	  * @param element
	  */
	 public void rightClickOn(WebDriver driver,WebElement element)
	 {
		 Actions a=new Actions(driver);
		 a.contextClick(element).perform();
	 }
	 /**
	  * This method will perform drag and drop action from src element to target element
	  * @param driver
	  * @param source
	  * @param target
	  */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();		
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will get the text from alert popup and return to caller
	 * @param driver
	 * @return
	 */
	public String getTextInAlert(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	/**
	 * This method will switch to the window with respect to the window title
	 * @param driver
	 * @param PartialTitle
	 */
	public void switchToWindow(WebDriver driver,String PartialTitle)
	{
		//STEP1: get all handles
		Set<String> windowIds = driver.getWindowHandles();
		//STEP2: iterate through all the windows
		Iterator<String> it = windowIds.iterator();
		//STEP3: navigate inside windows
		while(it.hasNext())
		{
			//capture all window id's
			String windid = it.next();
			//switch to the window and capture the title
			String currentTitle = driver.switchTo().window(windid).getTitle();
			if(currentTitle.contains(PartialTitle))
			{
				break;
			}
			}
		}
	/**
	 * switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * switch to frame based on name or id
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	/**
	 * switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will take screen shot and return destination path
	 * @param driver
	 * @param screenShotName
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshots\\"+screenShotName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();// used for reporting in listeners
	}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	/**
	 * This method will perform  scroll until the particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();",element);
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
}
