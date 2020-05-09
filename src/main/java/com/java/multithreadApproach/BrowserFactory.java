package com.java.multithreadApproach;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;



 /**
 * @author Shobhit Sharma
 * @purpose  To Achive the parallel testing using Multi-threaded approach
 * @Date  3/4/2020
 *
 */
public class BrowserFactory {
	
	private static BrowserFactory instance=null;
	ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>();
	private BrowserFactory()
	{
		
	}
	public static BrowserFactory getInstance()
	{
		if(instance==null)
		{
			instance=new BrowserFactory();
		}
		return instance;
		
	}
	public void setDriver(String browser)
	{    
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");			
			FirefoxOptions option=new FirefoxOptions();
			option.setAcceptInsecureCerts(true); //This help us to Bypass SSL certificate 
			option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);   //To handle unhandled Alert
			option.addArguments("--disable-notifications"); //To disable Notification
			driver=new FirefoxDriver(option);
			threadDriver.set(driver);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			
			option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"}); //This help us to disable a trip[chrome is being controlled automated by automated soft]
			option.setAcceptInsecureCerts(true);
			option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); 
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
			threadDriver.set(driver);
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			threadDriver.set(driver);
		}
	}
	public  WebDriver getDriver()
	{
		return threadDriver.get();
	}
	
	public void remove()
	{
		threadDriver.get().quit();
		threadDriver.remove();
	}

}
