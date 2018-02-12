package root.startAppiumServer;

import java.io.IOException;

public interface AppiumInvocation {
	
	public void startAppiumServerViaTerminal() throws IOException,InterruptedException;
	public boolean checkServerIsRunningOrNot(int port);

}
