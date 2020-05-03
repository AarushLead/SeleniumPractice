package com.java.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{   
		String pattern="dd-MM-yy";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String formatdate = sdf.format(new Date());
		String curDir=System.getProperty("user.dir");
		String reportPath=curDir+"/report/"+"ExecutionReport_"+formatdate+".html";
		
		//setting Report Info
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(reportPath);
		sparkReport.config().setDocumentTitle("ExtentReport");
		sparkReport.config().setEncoding("UTF-8");
		sparkReport.config().setReportName("Web Automation Report");
		sparkReport.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
		sparkReport.config().setTheme(Theme.DARK);
		
		//setting system Info
		extent=new ExtentReports();
		extent.setSystemInfo("Test Engineer", "Shobhit");
		extent.setSystemInfo("Company Name","Zivame");
		extent.setSystemInfo("Environment", "QA");
		
		extent.attachReporter(sparkReport);		
				
		return extent;
		
	}
	
}
