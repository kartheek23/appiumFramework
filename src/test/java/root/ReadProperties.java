package root;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
private static final String configPath = System.getProperty("user.dir") + "/config.properties";
private static Properties props = null;

static {
	try {
	FileInputStream fis = new FileInputStream(new File(configPath));
	props = new Properties();
	props.load(fis);
	}
	catch(FileNotFoundException fnfe) {
		System.out.println("Config file is not loaded please check.");
	}
	catch(IOException io) {
	System.out.println("There was an issue loading the props file please check.");	
	}
}
   
public static String getConfigDetails() {
	return props.getProperty("configDetails");
}
}
