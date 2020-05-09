package com.java.multithreadApproach;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseThread {

	WebDriver driver=null;
	BrowserFactory browserFactory=null;
	@Parameters({"browser","url"})
	@BeforeMethod
	public void setUp(String browser,String url)
	{
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver(browser);
		browserFactory.getDriver().get(url);
		browserFactory.getDriver().manage().window().maximize();
		browserFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		browserFactory.remove();
	}
}
