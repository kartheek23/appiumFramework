package root;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverObjectFactory extends DriverInitialization {
private IOSDriverImpl iosSafariDriver;
private AndroidDriverImpl androidDriver;
public DriverObjectFactory() {
	iosSafariDriver = new IOSDriverImpl();
	androidDriver = new AndroidDriverImpl();
}
public AppiumDriver<MobileElement> returnSafariDriverOnDevice() {
	return iosSafariDriver.returnIOSSafariDriverOnDevice();
}

public AppiumDriver<MobileElement> returnSafariDriverOnSim() {
	return iosSafariDriver.returnIOSSafariDriverForSim();
}

public AppiumDriver<MobileElement> returnIOSAppDriverOnSim(){
	return iosSafariDriver.returnIOSAppDriverOnSim();
}

public AppiumDriver<MobileElement> returnIOSAppDriverOnDevice(){
	return iosSafariDriver.returnIOSAppDriverOnDevice();
}

public AppiumDriver<MobileElement> returnAndroidDeviceDriver(){
	return androidDriver.returnAndroidAppDriverOnDevice();
}

public AppiumDriver<MobileElement> returnAndroidDeviceDriverForChrome(){
	return androidDriver.returnAndroidChromeDriverOnDevice();
}

}
