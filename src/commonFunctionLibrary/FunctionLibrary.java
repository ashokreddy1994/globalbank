package commonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PropertyfileUtil; 

public class FunctionLibrary 
{
	public static WebDriver openBrowser(WebDriver driver) throws Throwable
	{
		if(PropertyfileUtil.getPropertyValueForKey("Browser").equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(PropertyfileUtil.getPropertyValueForKey("Browser").equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(PropertyfileUtil.getPropertyValueForKey("Browser").equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		return driver;
	}
	public static void startApplication(WebDriver driver) throws Throwable
	{
		driver.manage().window().maximize();
		driver.get(PropertyfileUtil.getPropertyValueForKey("URL"));
	}
	public static void clickAction(WebDriver driver,String locatorType,String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("cssselector"))
		{
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("linktext"))
		{
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
	}
     public static void typeAction(WebDriver driver,String locatorType,String locatorValue,String data)
     {
    	 if(locatorType.equalsIgnoreCase("id"))
    	 {
    		 driver.findElement(By.id(locatorValue)).clear();
    		 driver.findElement(By.id(locatorValue)).sendKeys(data);
    	 }
    	 else if(locatorType.equalsIgnoreCase("name"))
    	 {
    		 driver.findElement(By.name(locatorValue)).clear();
    		 driver.findElement(By.name(locatorValue)).sendKeys(data);
    	 }
    	 else if(locatorType.equalsIgnoreCase("xpath"))
    	 {
    		 driver.findElement(By.xpath(locatorValue)).clear();
    		 driver.findElement(By.xpath(locatorValue)).sendKeys(data);
    	 }
    	 else if(locatorType.equalsIgnoreCase("cssselector"))
    	 {
    		 driver.findElement(By.cssSelector(locatorValue)).clear();
    		 driver.findElement(By.cssSelector(locatorValue)).sendKeys(data);
    	 }
     }
     public static void closeBrowser(WebDriver driver)
     {
    	 driver.close();
     }
     public static void waitAction(WebDriver driver,String locatorType,String loactorValue,String waittime)
     {
    	 WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(waittime));
    	 if(locatorType.equalsIgnoreCase("id"))
    	 {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loactorValue)));
    	 }
    	 else if(locatorType.equalsIgnoreCase("xpath"))
    	 {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loactorValue)));
    	 }
    	 else if(locatorType.equalsIgnoreCase("name"))
    	 {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(loactorValue)));
    	 }
    	 else if(locatorType.equalsIgnoreCase("linktext"))
    	 {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(loactorValue)));
    	 }
     }
}
