package com.java.screenshotways;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	/**

	* To Capture the Screenshot and return the file path to extent report on fail cases
	*
	* @param driver
	* @param testCaseName
	* @return path
	* @throws IOException
	*/
	public static String screenShot1(WebDriver driver,String testCaseName) throws IOException
	{   
		String pattern="dd-MM-yy";
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String formatdate = sdf.format(new Date()).toString();
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenShot/"+testCaseName+formatdate+".png";
		File dest=new File(path);
		FileUtils.copyFile(source, dest);
		return path;
		
	}
}
