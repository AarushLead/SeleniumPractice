package com.java.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static Logger logger = null;
	public WebDriver driver;

	@BeforeSuite
	public void Loadlog4jConfig() {
		String logPath = System.getProperty("user.dir") + "/src/test/resources";
		logger = Logger.getLogger("WebExecutionLog"); // Logger
		PropertyConfigurator.configure(logPath + "/log4j.properties"); // Logger
	}

	@BeforeTest
	public void setUptest() {
		logger.info("********BEFORE TEST***********");
	}

	@BeforeMethod
	@Parameters("Browser")
	public void setupScript(String Browser)
	{
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });																							// automated soft]
			option.setAcceptInsecureCerts(true);
			option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			option.addArguments("--disable-extensions"); //To disable developer option extention
			Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
         	option.setExperimentalOption("prefs", prefs); //To disable chrome notification
			driver = new ChromeDriver(option);
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.setAcceptInsecureCerts(true); // This help us to Bypass SSL certificate
			option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); // To handle unhandled Alert
			option.addArguments("--disable-notifications"); // To disable Notification
			driver = new FirefoxDriver(option);
		}
		else if (Browser.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	@AfterMethod
	public void tearDownScript() {
		driver.quit();
	}


}
