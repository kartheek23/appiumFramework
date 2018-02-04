package pages.ios.safari;

import root.PageMethods;

public class GmailSignInPage extends PageMethods {
	
	public String userName ="Email";
	public String passWord = "Passwd";
	public String clickElementByName = "signIn";
	
	public void enterUserName(String un) {
		sendTextByName(userName,un);
	}
	
	public void enterPassword(String pwd) {
		sendTextByName(passWord,pwd);
	}
	
	public void clickSignIn() {
		clickElementByName(clickElementByName);
	}
	
	public void getGmailURL(String url) {
		getURL(url);
	}

}
