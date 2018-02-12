package tests;

import org.testng.annotations.Test;
import pages.ios.safari.GmailSignInPage;
import root.DriverManager;
import root.PageMethods;

public class IOSGmailTestForSafari extends DriverManager {
	
	@Test(priority=1)
	public void gmailLogin() {
		GmailSignInPage gsp = new GmailSignInPage();
		gsp.getGmailURL("http://gmail.com");
		gsp.enterUserName("demo");
		gsp.enterPassword("demo");
		gsp.clickSignIn();
		PageMethods.quitBrowser();
	}

}
