package com.java.multithreadApproach;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;



 /**
 * @author Shobhit Sharma
 * @purpose  To Achive the parallel testing using multithreaded approach
 * @Date  3/4/2020
 *
 */
public class BrowserFactory {
	
	public static WebDriver driver=null;
	
	@Parameters({"Browser"})
	public static WebDriver createBrowserInstance(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chorme.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			driver=new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
