package pages.android.nativeapp;

import org.openqa.selenium.By;

import root.PageMethods;



public class SignUp1stPage extends PageMethods {
	public static final By signUpBtn=By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/tv_signup");
	public static final By userName =By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_name");
	public static final By surName =By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_surname");
	public static final By nickName=By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_login");
	public static final By day = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_day_of_mounth");
	public static final By month = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_mounth");
	public static final By year = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_year");
	public static final By phoneNum = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_phone_number");
	public static final By regEmail=By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_reg_email");
	public static final By next = By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/bt_next");
	
    public void clickSignUpBtn() {
    	PageMethods pageMethod = new PageMethods();
    	pageMethod.fluentWait(signUpBtn,10);
    	driver.findElement(signUpBtn).click();
    }
    public void enterName(String name) {
    	driver.findElement(userName).sendKeys(name);
    }
    public void enterSurName(String suName) {
    	driver.findElement(surName).sendKeys(suName);
    }
    public void enterNickName(String niName) {
    	driver.findElement(nickName).sendKeys(niName);
    	driver.hideKeyboard();
    }
    public void enterDay(String da) {
    	driver.findElement(day).sendKeys(da);
    }
    public void enterMonth(String mo) {
    	driver.findElement(month).sendKeys(mo);
    }
    public void enterYear(String ye) {
    	driver.findElement(year).sendKeys(ye);
    	try {
    		driver.hideKeyboard();
    	}
    	catch(Exception e) {
    		System.out.println("Keyboard is not present");
    	}
    }
    public void enterPhoneNum(String phNm) {
    	driver.findElement(phoneNum).clear();
    	driver.findElement(phoneNum).sendKeys(phNm);
    	driver.hideKeyboard();
    }
    public void enterRegEmail(String email) {
    	driver.findElement(regEmail).sendKeys(email);
    	driver.hideKeyboard();
    }
    public SignUp2ndPage clickNext() {
    	driver.findElement(next).click();
    	return new SignUp2ndPage();
    }
}
