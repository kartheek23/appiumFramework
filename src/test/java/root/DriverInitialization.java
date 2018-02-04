package root;



import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class DriverInitialization {

	protected static AppiumDriver<MobileElement> driver;

	protected static DesiredCapabilities dCap = new DesiredCapabilities();

	public static DesiredCapabilities getdCap() {
		return dCap;
	}
	public static void setdCap(DesiredCapabilities dCap) {
		DriverInitialization.dCap = dCap;
	}
	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
	public static void setDriver(AppiumDriver<MobileElement> driver) {
		DriverInitialization.driver = driver;
	}	

}


