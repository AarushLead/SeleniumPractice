package com.java.reporting1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager 
{
	static ExtentReports extent;
	final static String dirPath=System.getProperty("user.dir")+"/reports";
    final static String reportPath=dirPath+"/Automation_"+getCurrentDate();
    static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer,ExtentTest>();
	
	public synchronized static ExtentReports getReporter()
	{
		if(extent==null)
		{   
			ExtentSparkReporter sparkReport=new ExtentSparkReporter(reportPath);
			sparkReport.config().setDocumentTitle("Execution report");
			sparkReport.config().setReportName("Extent Report");
			sparkReport.config().setEncoding("Utf-8");
			sparkReport.config().setTheme(Theme.DARK);
			sparkReport.config().setTimeStampFormat("dd-MM-yyyy");
			
			//setting system Info
			extent=new ExtentReports();
			extent.setSystemInfo("Test Engineer", "Shobhit");
			extent.setSystemInfo("Company Name","Zivame");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Platform", System.getProperty("os.name"));
			
			extent.attachReporter(sparkReport);		
			
		}
		return extent;
	}
	 public static synchronized ExtentTest getTest()
	 {
	        return(ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	 }
	 
	 public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = getReporter().createTest(testName, desc);
	        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
	        return test;
	    }
	public static String getCurrentDate()
	{
		String pattern="dd-MM-yy";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String formatdate = sdf.format(new Date()).toString();
		return formatdate;
	}

}
