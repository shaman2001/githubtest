package com.shaman.githubtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;

import com.shaman.githubtest.pages.HomePage;
import com.shaman.githubtest.pages.LoginPage;
//import com.shaman.githubtest.pages.ProjectPage;
//import com.shaman.githubtest.util.PropertyLoader;

//import ru.stqa.selenium.factory.WebDriverFactory;
//import ru.stqa.selenium.factory.WebDriverFactoryMode;

/**
 * Base class for TestNG-based test classes
 */
public class PageTest {
	public final static String USERNAME = "shaman2001";
	public final static String PASSWORD = "qwerty123";
	public final static String URL="https://github.com/login";

	protected static String gridHubUrl;
	protected static String baseUrl;
	protected static Capabilities capabilities;

	protected WebDriver driver = null;;
	//protected Capabilities chrome = null;
	protected LoginPage loginPage = null;
	protected HomePage homePage = null;
	//protected ProjectPage projectPage = null;
	
	@BeforeClass
	public void initTestSuite() throws IOException {
		//capabilities = PropertyLoader.loadCapabilities("chrome.capabilities");
		//chrome = DesiredCapabilities.chrome();
		//WebDriverFactory.setMode(WebDriverFactoryMode.SINGLETON);
		//driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		driver=new ChromeDriver();
		driver.get(URL);
		homePage = new LoginPage(driver).login(USERNAME, PASSWORD);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//WebDriverFactory.dismissAll();
		driver.close();
	}
}
