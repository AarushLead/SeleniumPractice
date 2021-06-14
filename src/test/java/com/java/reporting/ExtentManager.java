package com.java.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports extent;
	static ExtentSparkReporter sparkReport;
	
	public static ExtentReports getInstance()
	{   
		String pattern="dd-MM-yy";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String formatdate = sdf.format(new Date()).toString();
		String curDir=System.getProperty("user.dir");
		String reportPath=curDir+"/reports/ExecutionReport_"+formatdate+".html";
		
		//setting Report Info
		sparkReport=new ExtentSparkReporter(reportPath);
		
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
				
		return extent;
		
	}
	
}
