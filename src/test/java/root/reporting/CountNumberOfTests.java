package root.reporting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import root.ReadProperties;

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
		   StringBuilder out = new StringBuilder();
		   
			   out.append("<html><head><title>Test Results</title><style>h1{color:green;background-color:lightblue;text-align:center;}table,th,td {\n" + 
		   		"    border-collapse: collapse;\n" + 
		   		"    border: 1px solid black;\n" + 
		   		"}</style></head>");
			   out.append("<body>");
			   out.append("<h1>Demo Automation Results</h1>");
			   out.append("<table style=\"width:100%\",align=\"left\">");
			   out.append("<tr><th bgcolor=\"green\" align=\"left\">Passed Tests:"+this.getTestPassed()+"</th><th bgcolor = \"red\" align =\"left\">Failed Tests:"+this.getTestFailed()+"</th><th bgcolor=\"yellow\" align=\"left\">Skipped Tests:"+this.getTestSkipped()+"</th><th bgcolor=\"grey\" align=\"left\">Total Tests:"+this.getTotalNumberOfTests()+"</th></tr>");
			   out.append("</table>");
		   
			   out.append("<table style=\"width:100%\">");
			   out.append("<br><tr><th><b>Test Case Name</b></th><th><b>Test Case Description</b></th><th><b>Test Status</b></th><th><b>Error Message</b></th><th><b>Time Taken</b></th></tr></br>");
		   Iterator<String> itrMname = methodName.iterator();
		   Iterator<String> itrMDesc = methodDesc.iterator();
		   Iterator<String> itrThrErr = throwab.iterator();
		   Iterator<String> itrTestSta = testStatus.iterator();
		   Iterator<String> itrTimeTak = testTimeTaken.iterator();
		  
		   while(itrTestSta.hasNext()) {
	          String testStatus = itrTestSta.next();
			  if(testStatus.equalsIgnoreCase("PASSED")) {
				  out.append("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"green\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
			   }
	          if(testStatus.equalsIgnoreCase("FAILED")) {
	        	  out.append("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"red\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
	          }
	         if(testStatus.equalsIgnoreCase("SKIPPED")) {
	        	 out.append("<tr><td>"+itrMname.next()+"</td><td>"+itrMDesc.next()+"</td><td bgcolor=\"yellow\">"+testStatus+"</td><td>"+itrThrErr.next()+"</td><td>"+itrTimeTak.next()+"</td></tr>");
	          }
	          
		   }
		   out.append("</table>");
		   out.append("</body>");
		   out.append("</html>");
		   
		   sendEmailWithHTMLReport(out.toString());
		   
		   FileWriter fileWriter = new FileWriter(file);
		   fileWriter.write(out.toString());
		   fileWriter.close();
		   }
	
	   

	public void sendEmailWithHTMLReport(String htmlReportCode) {
		String to="challakartheek12@gmail.com";//change accordingly 
		String from="challakartheek@gmail.com";//change accordingly 
		String password="Karthik34";//change accordingly 

		//Get the session object 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class", 
		"javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "465"); 

		Session session = Session.getDefaultInstance(props, 
		new javax.mail.Authenticator() { 
		protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(from,password);
		} 
		}); 

		//compose message 
		try { 
		MimeMessage message = new MimeMessage(session); 
		message.setFrom(new InternetAddress(from)); 
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
		message.setSubject("Nothing Special.."); 
		message.setContent(message, "text/html");
		message.setContent(htmlReportCode, "text/html");
		 

		//send message 
		Transport.send(message); 

		System.out.println("message sent successfully"); 

		} catch (MessagingException e) {throw new RuntimeException(e);} 

		} 
	}

