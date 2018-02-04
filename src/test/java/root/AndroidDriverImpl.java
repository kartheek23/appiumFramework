package root;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverImpl extends DriverManager implements DriverFactory {
	
	@Override
	public AppiumDriver<MobileElement> returnAndroidChromeDriverOnDevice() {
		try {
			dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			dCap.setCapability("platformName", "Android");
			dCap.setCapability("browserName", "chrome");
			dCap.setCapability("autoAcceptAlerts", "true");
			dCap.setCapability("autoWebView", "true");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),dCap);
		}
		catch(MalformedURLException mfe) {
			System.out.println("You are encountering a Malformed URL Exception");
		}
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnAndroidAppDriverOnDevice() {
		try {
		  dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		  dCap.setCapability("appPackage", "dimysik.new_norm.dnepr.ukraine.goodx");
		  dCap.setCapability("appActivity", "dimysik.new_norm.dnepr.ukraine.goodx.activity.SplashActivity");
		  dCap.setCapability("app", System.getProperty("user.dir") +"/Apps/Android/app-debug.apk");
		  return driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dCap);
			
		}
		catch(MalformedURLException mce) {
			System.out.println("You encountered a Malformed URL Exception in returnAndroidAppDriverOnDevice method. Please check.");
		}
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnAndroidChromeDriverOnEmu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnAndroidAppDriverOnEmu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnIOSSafariDriverOnDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnIOSAppDriverOnDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnIOSSafariDriverForSim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnIOSAppDriverOnSim() {
		// TODO Auto-generated method stub
		return null;
	}



}
