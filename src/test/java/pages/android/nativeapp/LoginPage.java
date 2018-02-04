package pages.android.nativeapp;

import org.openqa.selenium.By;


import root.PageMethods;

public class LoginPage extends PageMethods {
public static final String userName = "android.widget.EditText";
public static final By passWord = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_password");
public static final By signIn = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/bt_login");

public void enterUserName(String usrNam) {
	driver.findElementByClassName(userName).sendKeys(usrNam);
}
public void enterPwd(String pwd) {
	driver.findElement(passWord).sendKeys(pwd);
}
public void clickOnSignInButton() {
	driver.findElement(signIn).click();
}
}
