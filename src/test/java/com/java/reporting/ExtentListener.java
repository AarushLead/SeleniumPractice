package com.java.reporting;

import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.java.screenshotways.ScreenShots;

public class ExtentListener  implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getClass().getSimpleName()+ "  @Test case :"+" "+ result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE :- " + methodName.toUpperCase()+"  PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,m);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		
		WebDriver driver=null;
		String methodName=result.getMethod().getMethodName();
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		String logText="<b>"+"TEST CASE :- "+methodName.toUpperCase()+"  FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL,m);
		
		extentTest.get().log(Status.FAIL, "<details>"+"<summary>"+"<b>"+"<font color=red>"+"Exception Occured : Click to see details"+"</font>"+"</b>"
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
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ScreenShots.screenShot1(driver,result.getMethod().getMethodName())).build();
			
			extentTest.get().log(Status.FAIL,"<b><font color=red>"+"ScreenShot of failure"+"</font></b>", mediaModel);
		
		} 
		catch (IOException e)
		{
			extentTest.get().log(Status.FAIL, "Test Failed ,can not attach Sceenshot");
		}		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE :- " + methodName.toUpperCase()+"  SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		extentTest.get().log(Status.SKIP, m);
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
		if(extent!=null)
		{
			extent.flush();
		}
	}
}
