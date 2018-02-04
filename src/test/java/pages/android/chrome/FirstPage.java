package pages.android.chrome;

import org.openqa.selenium.By;

import root.PageMethods;

public class FirstPage extends PageMethods {
	
	public final String email = "//input[@type='email']"; 
	public final String password = "//input[@type='password']";
	public final String signIn = "//button[@name='login']";
	
	public void navigateToURL() {
		getURL("http://facebook.com");
	}
	
	public void sendEmail(String emailID) {
		fluentWait(By.xpath(email),10);
		sendTextByXpath(email,emailID);
	}
	
	public void sendPassword(String pass) {
		sendTextByXpath(password,pass);
	}
	
	public void clickSignIn() {
		clickElementByXPath(signIn);
	}

}
