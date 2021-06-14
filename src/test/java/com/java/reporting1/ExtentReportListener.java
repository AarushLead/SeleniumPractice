package com.java.reporting1;

import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.java.screenshotways.AShotScreenShot;

public class ExtentReportListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>TEST CASE :- " + methodName.toUpperCase()+"  PASSED</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentReportManager.getTest().log(Status.PASS, m);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		String methodName=result.getMethod().getMethodName();
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		String logText="<b>"+"TEST CASE :- "+methodName.toUpperCase()+"  FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentReportManager.getTest().log(Status.FAIL,m);
		
		ExtentReportManager.getTest().log(Status.FAIL, "<details>"+"<summary>"+"<b>"+"<font color=red>"+"Exception Occured : Click to see details"+"</font>"+"</b>"
		+"</summary>"+exceptionMessage.replaceAll(",", "<br>")+"</details> \n");
		
		MediaEntityModelProvider mediaModel;
		Object testObject = result.getInstance();
		Class<?> className = result.getTestClass().getRealClass();
		 try {
			driver=(WebDriver)className.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		
		try {
			String imgPath=AShotScreenShot.screenShot(driver,methodName);
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build();
			
			ExtentReportManager.getTest().log(Status.FAIL,"<b><font color=red>"+"ScreenShot of failure :"+"</font></b>", mediaModel);
		} 
		catch (IOException e)
		{
			ExtentReportManager.getTest().log(Status.FAIL, "Test Failed ,can not attach Sceenshot");
		}		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>TEST CASE :- " + methodName.toUpperCase()+"  SKIPPED</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		ExtentReportManager.getTest().log(Status.PASS, m);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
	ExtentReportManager.getReporter().flush();
		
	}

}
