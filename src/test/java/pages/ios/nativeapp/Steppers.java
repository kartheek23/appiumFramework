package pages.ios.nativeapp;

import org.openqa.selenium.By;

import root.PageMethods;

public class Steppers extends PageMethods {
	
	public String steppersId = "Steppers";
	public String incrementId = "Increment";
	public String getTextFromIncrement = "XCUIElementTypeStaticText";
	public String decrementId = "Decrement";
	
	
	public void scrollToMiddle() {
		scrollDown();
	}
	
	public void clickOnIncrement() {
		
		clickByAccessibilityID(incrementId);
	}
	
	public void clickOnSteppersID() {
		fluentWait(By.id("Steppers"),10);
		clickByAccessibilityID(steppersId);
	}
	
	public String returnTextFromFirstIncrement() {
		return findElementsByClassNameAndIndexAndReturnText(getTextFromIncrement,1);
	}
	
	public String returnTextFromSecondIncrement() {
		return findElementsByClassNameAndIndexAndReturnText(getTextFromIncrement,2);
	}
	
	public void clickOnDecrement() {
		clickByAccessibilityID(decrementId);
	}
	
	public Picker navigateBackToHome() {
		navigateBack();
		return new Picker();	
		
	}
	
	

}
