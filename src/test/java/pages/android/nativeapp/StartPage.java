package pages.android.nativeapp;

import root.PageMethods;

public class StartPage extends PageMethods {
	
	public static final String startButton = "android.widget.TextView";
	
	public LoginPage clickOnStartButton() {
		driver.findElementByClassName(startButton).click();
		return new LoginPage();
	}

}
