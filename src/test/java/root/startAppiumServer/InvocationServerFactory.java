package root.startAppiumServer;

public class InvocationServerFactory {
	
	GenericAppiumServerImpl gsi;
	public InvocationServerFactory(){
		gsi = new GenericAppiumServerImpl();
	}
	
	public void startAppiumGenericServer() {
		gsi.startAppiumServerViaTerminal();
	}
      
}
