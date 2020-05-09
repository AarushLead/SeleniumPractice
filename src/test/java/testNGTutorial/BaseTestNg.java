package testNGTutorial;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestNg {
	public static Logger logger;

	@BeforeSuite
	public void logConfig() {
		String logPath = System.getProperty("user.dir") + "/src/test/resources";
		logger = Logger.getLogger("WebExecutionLog"); // Logger
		PropertyConfigurator.configure(logPath + "/log4j.properties"); // Logger
	}

	@BeforeTest
	public void setUp() {
		logger.info("********Before Test***********");
	}

	@AfterTest
	public void tearDown() {
		logger.info("********After Test***********");
	}

	@AfterSuite
	public void flushObject() {
		logger.info("********After suite***********");
	}

}
