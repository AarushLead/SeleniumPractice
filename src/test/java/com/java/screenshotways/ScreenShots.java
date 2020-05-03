package com.java.screenshotways;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public static String screenShot1(WebDriver driver,String testCaseName) throws IOException
	{   
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+testCaseName+".png";
		File dest=new File(path);
		FileUtils.copyFile(source, dest);
		return path;
		
	}
}
