package root;



import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import root.DriverObjectFactory;
import root.reporting.ReportingListener;
import root.startAppiumServer.InvocationServerFactory;
@Listeners(ReportingListener.class)
public class DriverManager extends DriverInitialization {	
	private String data;
	
	@BeforeSuite
	public void init() {	    
		InvocationServerFactory isf = new InvocationServerFactory();
		data = ReadProperties.getConfigDetails();
		String platform=data.split("::")[0];
		String deviceType = data.split("::")[1];
		String appOrBrowser = data.split("::")[2];
		
		DriverObjectFactory dof = new DriverObjectFactory();
		
		if(platform.equalsIgnoreCase("Android") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("Browser"))
		{
			isf.startAppiumGenericServer();
			dof.returnAndroidDeviceDriverForChrome();
		}
		else if(platform.equalsIgnoreCase("Android") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("App")) {
			isf.startAppiumGenericServer();
			dof.returnAndroidDeviceDriver();	
		}	
		else if(platform.equalsIgnoreCase("IOS") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("App")) {
			isf.startAppiumGenericServer();
			dof.returnIOSAppDriverOnDevice();
		}
		else if(platform.equalsIgnoreCase("IOS") && deviceType.equalsIgnoreCase("Device") && appOrBrowser.equalsIgnoreCase("Browser")) {
			isf.startAppiumGenericServer();
			dof.returnSafariDriverOnDevice();
		}
		else if(platform.equalsIgnoreCase("IOS") && deviceType.equalsIgnoreCase("Simulator") && appOrBrowser.equalsIgnoreCase("App")) {
			isf.startAppiumGenericServer();
			dof.returnIOSAppDriverOnSim();
		}
	}
}
