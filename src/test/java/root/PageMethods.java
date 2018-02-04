package root;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PageMethods extends DriverManager{
	
	public static void clickByAccessibilityID(String id) {
		driver.findElementByAccessibilityId(id).click();
	}
	
	public static String getTextByAccessibilityID(String id) {
		return driver.findElementByAccessibilityId(id).getText();
	}
	
	public static void clickElementByXPath(String xpath) {
		try {
		driver.findElementByXPath(xpath).click();
		}
		catch(NoSuchElementException nce) {
			System.out.println("Unable to locate element with locator::"+ xpath);
		}
	}
	
	public static String returnTextByXpath(String xpath) {
		return driver.findElementByXPath(xpath).getText();
	}
	public static void sendTextByXpath(String xpath,String text) {
		driver.findElementByXPath(xpath).sendKeys(text);
	}
	public static void clickElementByName(String name) {
		driver.findElementByName(name).click();
	}
	
	public static String getTextByName(String name) {
		return driver.findElementByName(name).getText();
	}
	
	public static void sendTextByName(String name,String text) {
		driver.findElementByName(name).sendKeys(text);
	}
	
	public static void sendTextByClassName(String className,String text) {
		driver.findElementByClassName(className).sendKeys(text);
		
	}
	public static void sendTextByClassNameAndIndex(String className,int index,String text) {
		
		driver.findElementsByClassName(className).get(index).sendKeys(text);
		
	}
	
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	public static void scrollDown() {
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() /2;
		int starty = (int) (size.getHeight()*0.60);
		int endY = (int) (size.getHeight() *0.10);
		driver.swipe(x, starty, x, endY, 2000);
	}
	
	public static String findElementsByClassNameAndIndexAndReturnText(String className,int index) {
		return driver.findElementsByClassName(className).get(index).getText();
	}
	
	public static void closeApp() {
		driver.closeApp();
	}
	
	public void fluentWait(By locator,int Seconds) {

		try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Seconds, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		 
		}
		catch(Exception e) {
			System.out.println("You are in the exception block of fluent wait method check the locator once.");
		}

	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public static void quitBrowser(){
		driver.quit();
	}
   
}
