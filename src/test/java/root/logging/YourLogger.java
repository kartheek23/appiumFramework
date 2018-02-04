package root.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class YourLogger {

	private static Logger logger = Logger.getLogger(YourLogger.class) ;
	static {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
	}
	
	public static void logInfo(String message) {
		logger.log(YourLogger.class.getCanonicalName(), Level.INFO, message, null);
	}
	
	public static void logError(String message) {
		logger.log(YourLogger.class.getCanonicalName(), Level.ERROR,message,null);
	}
}
