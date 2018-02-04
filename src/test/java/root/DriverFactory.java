package root;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

interface DriverFactory {
	
	public abstract AppiumDriver<MobileElement> returnIOSSafariDriverOnDevice();
	public abstract AppiumDriver<MobileElement> returnIOSAppDriverOnDevice();
	public abstract AppiumDriver<MobileElement> returnIOSSafariDriverForSim();
	public abstract AppiumDriver<MobileElement> returnIOSAppDriverOnSim();
	public abstract AppiumDriver<MobileElement> returnAndroidChromeDriverOnDevice();
	public abstract AppiumDriver<MobileElement> returnAndroidAppDriverOnDevice();	
	public abstract AppiumDriver<MobileElement> returnAndroidChromeDriverOnEmu();
	public abstract AppiumDriver<MobileElement> returnAndroidAppDriverOnEmu();

}
