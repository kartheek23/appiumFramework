package root.reporting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ReportingListener extends TestListenerAdapter{
    static CountNumberOfTests cTests = new CountNumberOfTests();
	@Override
	public void onTestSuccess(ITestResult itestResult) {
	cTests.incrementTestsPassed();
	cTests.addErrorLog(" ");
	cTests.addMethodName(itestResult.getMethod().getMethodName());
	cTests.addMethodDesc(itestResult.getMethod().getDescription());
	cTests.addtestStatus("PASSED");
	String timeTaken = convertMilliSecondsToMinutes(itestResult.getStartMillis(),itestResult.getEndMillis());
	cTests.addTimeTaken(timeTaken);
	}
	@Override
	public void onTestFailure(ITestResult itestResult) {
		cTests.incrementFailedTests();
		cTests.addErrorLog(itestResult.getThrowable().toString());
		cTests.addMethodName(itestResult.getMethod().getMethodName());
		cTests.addMethodDesc(itestResult.getMethod().getDescription());
		cTests.addtestStatus("FAILED");
		String timeTaken = convertMilliSecondsToMinutes(itestResult.getStartMillis(),itestResult.getEndMillis());
		cTests.addTimeTaken(timeTaken);
	}
	@Override
	public void onTestSkipped(ITestResult itestResult) {
		cTests.incrementSkippedTests();
		cTests.addErrorLog(" ");
		cTests.addMethodName(itestResult.getMethod().getMethodName());
		cTests.addMethodDesc(itestResult.getMethod().getDescription());
		cTests.addtestStatus("SKIPPED");
		String timeTaken = convertMilliSecondsToMinutes(itestResult.getStartMillis(),itestResult.getEndMillis());
		cTests.addTimeTaken(timeTaken);
	}
	@Override
	public void onFinish(ITestContext context) {
		try {
			
			cTests.writeHTMLReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String convertMilliSecondsToMinutes(long startMilliSec,long endMilliSec) {
		long startMinutes = TimeUnit.MILLISECONDS.toMinutes(startMilliSec);
		long endMinutes = TimeUnit.MILLISECONDS.toMinutes(endMilliSec);
		long startSeconds = TimeUnit.MILLISECONDS.toSeconds(startMilliSec);
		long endSeconds = TimeUnit.MILLISECONDS.toSeconds(endMilliSec);
		long timeTakenMin = endMinutes-startMinutes;
		long timeTakenSec = endSeconds - startSeconds;
		String totalTimeTaken = Long.toString(timeTakenMin) + ":" + Long.toString(timeTakenSec);
		return totalTimeTaken;
		
	}
	
	}
