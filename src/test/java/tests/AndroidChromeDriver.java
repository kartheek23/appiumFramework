package tests;


import org.testng.annotations.Test;
import pages.android.chrome.FirstPage;
import root.DriverManager;
import root.logging.YourLogger;


public class AndroidChromeDriver extends DriverManager {

	
	@Test(description = "<b> Login to facebook.com </b>"
	+"</br> 1.Enter User Name" 
	+"</br> 2. Enter Password"
	+"</br> 3. click On SignIn.")
	public void methodOne() {
		FirstPage firstPage = new FirstPage();
		YourLogger.logInfo("Navigate To Facebook.com");
		firstPage.navigateToURL();
		YourLogger.logInfo("Enter your UserName");
		firstPage.sendEmail("demotester@gmail.com");
		YourLogger.logInfo("Enter Your password");
		firstPage.sendPassword("karthik");
		firstPage.clickSignIn();
	}
}
