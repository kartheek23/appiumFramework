package root.reporting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CountNumberOfTests {

	int passed;
	int failed;
	int skipped;
	static ArrayList<String> methodName = new ArrayList<String>();
	static ArrayList<String> methodDesc = new ArrayList<String>();
	static ArrayList<String> throwab = new ArrayList<String>();
	static ArrayList<String> testStatus = new ArrayList<String>();
	static ArrayList<String> testTimeTaken = new ArrayList<String>();
	
	public int getTestPassed() {
		return this.passed;
	}
	public int getTestFailed() {
		return this.failed;
	}
	public int getTestSkipped() {
		return this.skipped;
	}
	public int getTotalNumberOfTests() {
		return this.passed + this.failed + this.skipped;
	}
	
	public void incrementTestsPassed() {
		this.passed++;
	}
	public void incrementFailedTests() {
		this.failed++;
	}
	public void incrementSkippedTests() {
		this.skipped++;
	}
	public void addErrorLog(String error) {
		throwab.add(error);
	}
	public void addMethodName(String methodNam) {
		methodName.add(methodNam);	
	}
	public void addMethodDesc(String methodDescr) {
		methodDesc.add(methodDescr);
	}
	public void addtestStatus(String testStat) {
		testStatus.add(testStat);
	}
	public void addTimeTaken(String timeTake) {
		testTimeTaken.add(timeTake);
	}
	
	public void writeHTMLReport() throws IOException {
		   File file = new File("myTests.html");
		   try(FileWriter fw = new FileWriter(file)){
		   
		   fw.write("<html><head><title>Test Results</title><style>h1{color:green;background-color:lightblue;text-align:center;}table,th,td {\n" + 
		   		"    border-collapse: collapse;\n" + 
		   		"    border: 1px solid black;\n" + 
		   		"}</style></head>");
		   fw.write("<body>");
		   fw.write("<h1>Demo Automation Results</h1>");
		   fw.write("<table style=\"width:100%\",align=\"left\">");
		   fw.write("<tr><th bgcolor=\"green\" align=\"left\">Passed Tests:"+this.getTestPassed()+"</th><th bgcolor = \"red\" align =\"left\">Failed Tests:"+this.getTestFailed()+"</th><th bgcolor=\"yellow\" align=\"left\">Skipped Tests:"+this.getTestSkipped()+"</th><th bgcolor=\"grey\" align=\"left\">Total Tests:"+this.getTotalNumberOfTests()+"</th></tr>");
		   fw.write("</table>");
		   
		   fw.write("<table style=\"width:100%\">");
		   fw.write("<br><tr><th><b>Test Case Name</b></th><th><b>Test Case Description</b></th><th><b>Test Status</b></th><th><b>Error Message</b></th><th><b>Time Taken</b></th></tr></br>");
		   Iterator<String> itrMname = methodName.iterator();
		   Iterator<String> itrMDesc = methodDesc.iterator();
		   Iterator<String> itrThrErr = throwab.iterator();
		   Iterator<String> itrTestSta = testStatus.iterator();
		   Iterator<String> itrTimeTak = testTimeTaken.iterator();
		  
		   while(itrTestSta.hasNext()) {
	          String testStatus = itrTestSta.next();
			  if(testStatus.equalsIgnoreCase("PASSED")) {
	        	  fw.write("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"green\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
			   }
	          if(testStatus.equalsIgnoreCase("FAILED")) {
	        	  fw.write("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"red\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
	          }
	         if(testStatus.equalsIgnoreCase("SKIPPED")) {
	        	 fw.write("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"yellow\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
	          }
	          
		   }
		   fw.write("</table>");
		   fw.write("</body>");
		   fw.write("</html>");
		   //boeing_testuser@clh.com
		   }
	   }

	
}
