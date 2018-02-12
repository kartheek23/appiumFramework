package root;



import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import root.DriverObjectFactory;
import root.reporting.ReportingListener;
@Listeners(ReportingListener.class)
public class DriverManager extends DriverInitialization {	
	private String data;
	@BeforeSuite
	public void init() {	    
		data = ReadProperties.getConfigDetails();
		String platform=data.split("::")[0];
		String deviceType = data.split("::")[1];
		String appOrBrowser = data.split("::")[2];
		
		DriverObjectFactory dof = new DriverObjectFactory();
		
		if(platform.equalsIgnoreCase("Android") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("Browser"))
		{
			dof.returnAndroidDeviceDriverForChrome();
		}
		else if(platform.equalsIgnoreCase("Android") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("App")) {
			dof.returnAndroidDeviceDriver();	
		}	
		else if(platform.equalsIgnoreCase("IOS") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("App")) {
			dof.returnIOSAppDriverOnDevice();
		}
		else if(platform.equalsIgnoreCase("IOS") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("Browser")) {
			dof.returnSafariDriverOnDevice();
		}
	}
}
