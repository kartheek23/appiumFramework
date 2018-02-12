package root.startAppiumServer;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class GenericAppiumServerImpl implements AppiumInvocation {
	
	AppiumDriverLocalService service;
	Socket serverSocket = null;

	@Override
	public void startAppiumServerViaTerminal() {
		if(!checkServerIsRunningOrNot(4723)) {
			String appiumURL = "appium" + " -a 0.0.0.0 -p 4723";
			try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/appium.sh");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(appiumURL);
			bufferedWriter.close();
			String precommand[] = { "chmod", "u+x", System.getProperty("user.dir")+"/appium.sh" };
			String postCommand[] = {"/usr/bin/open","-a","Terminal",System.getProperty("user.dir")+"/appium.sh"};
			ProcessBuilder processBuilder = new ProcessBuilder(precommand);
			Process process = processBuilder.start();
			process.waitFor(120,TimeUnit.SECONDS);
			ProcessBuilder processBuilder2 = new ProcessBuilder(postCommand);
			process = processBuilder2.start();
			process.waitFor(5,TimeUnit.MINUTES);
			Thread.sleep(20000);
			}
			catch(IOException io) {
				System.out.println("The Shell file might not be present. Please check");
			}
			catch(InterruptedException ie) {
				System.out.println("Your Thread may be interrupted.Please check.");
			}
			
		}
		
	}

	
	@Override
	public boolean checkServerIsRunningOrNot(int port) {
		boolean isServerRunning = false;
		
		try {
			serverSocket = new Socket("localhost",port);
			isServerRunning = true;
			return isServerRunning;
			
		}
		catch(IOException e) {
			return false;
		}
		finally {
			serverSocket=null;
		}
		
		
	}

}
