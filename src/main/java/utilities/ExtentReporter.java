package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter
{
	static ExtentReports extentreport;
	
	public static ExtentReports  getExtentReport()
	{
		String extentpath=System.getProperty("user.dir")+"\\Reports\\extentReport.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentpath);
		reporter.config().setReportName("Automation lab login test");
		reporter.config().setDocumentTitle("Test Report");
		
	    extentreport=new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("OS", "Win 11");
		extentreport.setSystemInfo("Tested By", "Teja");
		
		return extentreport;
		
	}

}
