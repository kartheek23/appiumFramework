package root;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDriverImpl  extends DriverManager implements DriverFactory {
	
	@Override
	public AppiumDriver<MobileElement> returnIOSSafariDriverOnDevice(){
		
		try {
			dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "kartheekc's iPhone");
			dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			dCap.setCapability(MobileCapabilityType.UDID,"4657252e73fc5da06acdbc0a54c068cd0dc2d1d5");
			dCap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
			dCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
			driver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dCap);
			return driver;
		
		}
		catch(MalformedURLException mfe) {
			System.out.println("You might have encountered Malformed URL Exception.");
		}
		return null;	
	}
	
	@Override
	public AppiumDriver<MobileElement> returnIOSSafariDriverForSim() {
		
		try {
			dCap.setCapability("deviceName", "iPhone 5s");
			dCap.setCapability("xcodeOrgId", "CB25TE7HF4");
			dCap.setCapability("xcodeSigningId", "iPhone Developer");
			dCap.setCapability("automationName", "XCUITest");
			dCap.setCapability("udid","8A04F45E-FCFC-473E-A66C-A22E6BB8D0CE");
			dCap.setCapability(CapabilityType.BROWSER_NAME, "Safari");
			dCap.setCapability("safariInitialUrl", "http://www.google.com");
			driver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dCap);
			return driver;
		
		}
		catch(MalformedURLException mfe) {
			System.out.println("You might have encountered MalFormedURLException. Please check.");
		}
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnIOSAppDriverOnDevice() {
		
		
		try {
			dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "kartheekc's iPhone");
			dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			dCap.setCapability(MobileCapabilityType.UDID, "4657252e73fc5da06acdbc0a54c068cd0dc2d1d5");
			dCap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +"/Apps/IOS/UICatalog.app");
			
			driver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dCap);
			return driver;
			
		}
		catch(MalformedURLException mue) {
			System.out.println("There is a malformed exception in returnIOSAppDriverOnDevice method of IOSSafariDriver class.Please check");
		}
		return null;
	}
	
	@Override
	public AppiumDriver<MobileElement> returnIOSAppDriverOnSim() {
		
		
		try {
			dCap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
			dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			dCap.setCapability(MobileCapabilityType.NO_RESET, true);
			dCap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +"/Apps/IOS/UICatalog.app");
			driver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dCap);
			
			return driver;
			
		}
		catch(MalformedURLException mue) {
			System.out.println("There is a malformed exception in returnIOSAppDriverOnSim method of IOSSafariDriver class.Please check");
		}
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnAndroidChromeDriverOnDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppiumDriver<MobileElement> returnAndroidAppDriverOnDevice() {
		// TODO Auto-generated method stub
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

}
