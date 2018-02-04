package pages.ios.nativeapp;

import root.PageMethods;

public class Picker extends PageMethods	 {

	public String pickerID = "Picker View";
	public String firstComp = "Green color component value";
	public String secondComp = "XCUIElementTypePickerWheel";
	public String thirdComp = "//*[@name='Blue color component value']";
	
	public void clickPickerID() {
		clickByAccessibilityID(pickerID);
	}
	
	public void sendTextFirstComp(String text) {
		sendTextByName(firstComp,text);
	}
	public void sendTextSecondComp(String text) {
		
		sendTextByClassNameAndIndex(secondComp,0,text);
	}
	public void sendTextThirdComp(String text) {
		clickElementByXPath(thirdComp);
		sendTextByXpath(thirdComp,text);
	}
	
	public void navigateBackFromPicker() {
		navigateBack();
	}
}
