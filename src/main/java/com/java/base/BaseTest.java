package com.java.base;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static Logger logger=null;
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
	public void setupScript() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void tearDownScript() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterTest
	public void tearDowntest() {
		logger.info("********AFTER TEST***********");
	}

	@AfterSuite
	public void flushObject() {
		logger.info("********AFTER SUITE***********");
	}

}
