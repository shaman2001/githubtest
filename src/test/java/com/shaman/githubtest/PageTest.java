package com.shaman.githubtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.shaman.githubtest.pages.HomePage;
import com.shaman.githubtest.pages.LoginPage;

/**
 * Base class for TestNG-based test classes
 */
public class PageTest {
	public final static String USERNAME = "shaman2001";
	public final static String PASSWORD = "qwerty123";
	public final static String URL="https://github.com/login";
	//public final static String CHROMEDRIVER_EXE_PATH="c:\\selenium\\chromedriver.exe";

	protected static String gridHubUrl;
	protected static String baseUrl;
	protected static Capabilities capabilities;

	protected WebDriver driver = null;;
	protected LoginPage loginPage = null;
	protected HomePage homePage = null;
	protected Logger logger = Logger.getLogger("TestLogger");
	
	@BeforeClass
	public void initTestSuite() throws IOException {
		logger.info("Connect to the driver...");
		driver=new ChromeDriver();
		if (driver==null) {
			logger.error("Connection to driver failed");
		}
		driver.get(URL);
		homePage = new LoginPage(driver).login(USERNAME, PASSWORD);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		logger.info("All tests are completed");
	}
}
