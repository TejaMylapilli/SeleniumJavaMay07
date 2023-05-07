package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener
{

	WebDriver driver=null;
	ExtentReports extreport = ExtentReporter.getExtentReport();
	ExtentTest extent;
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)
	{
		 extent = extreport.createTest(result.getName()+"Execution started");
		 extentTestThread.set(extent);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTestThread.get().log(Status.PASS, result.getName()+" got passed ");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		
		String testMethodName = result.getName();
		extentTestThread.get().fail(result.getThrowable());
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotpath = takeScreenshot(testMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void onFinish(ITestContext context)
	{
		extreport.flush();
	}
	
	
	
	

}
