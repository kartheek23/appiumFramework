package tests;

import org.testng.annotations.Test;

import pages.android.nativeapp.StartPage;
import pages.android.nativeapp.SignUp1stPage;
import pages.android.nativeapp.SignUp2ndPage;
import root.DriverManager;
import root.GenericMethods;

public class AndroidNativeTest extends DriverManager {
	
	@Test
	public void methodOne() {
		int arr[] = GenericMethods.generateRandomNumbers();
		StartPage startPage = new StartPage();
		startPage.clickOnStartButton();
        SignUp1stPage signUp1 = new SignUp1stPage();
        signUp1.clickSignUpBtn();
        signUp1.enterName("Test - " +arr[0]);
        signUp1.enterSurName("Test - " + arr[1]);
        signUp1.enterNickName("Test - ");
        signUp1.enterDay("30");
        signUp1.enterMonth("04");
        signUp1.enterYear("1984");
        signUp1.enterPhoneNum("94123456789");
        signUp1.enterRegEmail("challakartheek@gmail.com");
        SignUp2ndPage signUp2 = signUp1.clickNext();
        signUp2.enterPassword("\"TEst+=12\"");
        signUp2.enterConfirmPassword("\"TEst+=12\"");
        signUp2.clickSignUpBtn();
	}

}
