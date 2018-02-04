package root;



import org.testng.annotations.BeforeSuite;
import root.DriverObjectFactory;

public class DriverManager extends DriverInitialization {	
	//private String data;
	@BeforeSuite
	public void init() {	    
    DriverObjectFactory dof = new DriverObjectFactory();
    dof.returnAndroidDeviceDriverForChrome();
	}
	


}
