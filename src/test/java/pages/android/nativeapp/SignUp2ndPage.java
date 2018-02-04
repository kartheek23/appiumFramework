package pages.android.nativeapp;

import org.openqa.selenium.By;

import root.PageMethods;



public class SignUp2ndPage extends PageMethods {
	public static final By enterPwd = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_pass");
	public static final By enterCnfmPwd = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_conf_pass");
	public static final By signUpBtn = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/bt_registration");
	
	public void enterPassword(String ePwd) {
		driver.findElement(enterPwd).sendKeys(ePwd);
		driver.hideKeyboard();
	}
	public void enterConfirmPassword(String cPwd) {
		driver.findElement(enterCnfmPwd).sendKeys(cPwd);
		driver.hideKeyboard();
	}
	public void clickSignUpBtn() {
		driver.findElement(signUpBtn).click();
	}
	
   
}
