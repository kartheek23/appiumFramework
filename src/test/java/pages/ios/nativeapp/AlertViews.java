package pages.ios.nativeapp;



import root.PageMethods;

public class AlertViews extends PageMethods {
	
	public static String alertViews = "Alert Views";
	public static String textEntry = "//*[@value='Text Entry']";
	public static String enterText = "XCUIElementTypeTextField";
	public static String okBtn = "OK";
	
	public void clickAlertView() {
		clickByAccessibilityID(alertViews);
	}
	
	public void clickTextEntry() {
		clickElementByXPath(textEntry);
	}
	public void enterTextInInputField(String text) {
		sendTextByClassName(enterText,text);
	}
	
	public void clickOnOkBtn() {
		clickElementByName(okBtn);
	}
	
	public Steppers navigateBackToAlertView(){
		navigateBack();
		return new Steppers();
	}

}
