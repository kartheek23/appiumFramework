package tests;

import org.testng.annotations.Test;
import pages.ios.nativeapp.AlertViews;
import pages.ios.nativeapp.Picker;
import pages.ios.nativeapp.Steppers;
import root.DriverManager;

public class IOSNativeTest extends DriverManager{
	
	@Test(description = "<b> Test Different functionalities of UICatalog app.</b>"
	+"<br> 1. Open UI Catalog app." 
	+"<br> 2. Check Alert View Functionality."
	+"<br> 3. Check Picker View Functionality.")
	public void methodOne() {
		AlertViews alertViews = new AlertViews();
		alertViews.clickAlertView();
		alertViews.clickTextEntry();
		alertViews.enterTextInInputField("hello");
		alertViews.clickOnOkBtn();
		Steppers steppers =alertViews.navigateBackToAlertView();
		steppers.scrollToMiddle();
		steppers.clickOnSteppersID();
		steppers.clickOnIncrement();
		steppers.clickOnIncrement();
		//The below two lines of code are not working as expected.
		System.out.println(steppers.returnTextFromFirstIncrement());
		System.out.println(steppers.returnTextFromSecondIncrement());
		steppers.clickOnDecrement();
		//The below line of code is not working as expected.
		System.out.println(steppers.returnTextFromFirstIncrement());
		Picker pickers=steppers.navigateBackToHome();
		pickers.clickPickerID();
		pickers.sendTextFirstComp("220");
		pickers.sendTextSecondComp("55");
		//The below line of code is not working as expected.
		pickers.sendTextThirdComp("130");
		AlertViews.closeApp();
       		
	}

}
