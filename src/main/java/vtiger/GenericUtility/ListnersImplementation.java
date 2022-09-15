package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListnersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); //test is created which will initialize the individual tests
		
		//Reporter.log(methodName+" => test script execution started",true);		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"---> passed");
		//Reporter.log(methodName+" => is passed",true);
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil= new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
	
		//EXCEPTION MESSAGE
		String msg = result.getThrowable().toString();
		
		//METHOD/SCRIPT NAME
		
		String methodName = result.getMethod().getMethodName();
		String screenshotName = methodName+"_"+jUtil.getSystemDateInFormat();
		test.log(Status.FAIL,methodName+"----> failed");
		test.log(Status.FAIL,result.getThrowable());
		
		
		
		//Reporter.log(methodName+" => is failed because => "+msg,true);
		
		//TAKING SCREEN SHOT
		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver,screenshotName);
			test.addScreenCaptureFromPath(path);	 //navigate to screen shot path and attach to report		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();	
		test.log(Status.SKIP,methodName+"---> skipped");
		test.log(Status.SKIP,result.getThrowable());
		//Reporter.log(methodName+" => is skipped",true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//START OF SUITE EXECUTION
		/**
		 * config the extent report
		 */
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-vtiger extent report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vtiger execution report");
		
		 report=new ExtentReports();
		 report.attachReporter(htmlReport);
		 report.setSystemInfo("Base-Browser","chrome");
		 report.setSystemInfo("Base-platform","windows");
		 report.setSystemInfo("Base-URL","http://localhost.8888");
		 report.setSystemInfo("Reporter Name","Dev");		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

	
	

}
