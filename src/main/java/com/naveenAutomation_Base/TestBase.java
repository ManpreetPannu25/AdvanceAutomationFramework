package com.naveenAutomation_Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenAutomation_Browsers.Browser;
import com.naveenAutomation_Environment.Environment;
import com.naveenAutomation_ProxyDriver.ProxyDriver;

public class TestBase {
	public static WebDriver driver;
	private final Environment URL = Environment.PROD;
	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	public static Logger logger;
	public static final boolean RUN_ON_GRID = false;
//	private String browserInput;
//	public WebDriverEvents events;
//	public EventFiringWebDriver e_driver;

	@BeforeClass
	public void loggerSetUp() {
		// initialize the logger
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void initialisation() {
		// browserInput = System.getProperty("BrowserType");
		if (RUN_ON_GRID) {
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getOption());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			// switch (browserInput.toUpperCase()) {
			switch (DEFAULT_BROWSER.toString()) {
			case "CHROME":
				driver = new ProxyDriver(new ChromeDriver());
				break;
			case "EDGE":
				driver = new ProxyDriver(new EdgeDriver());
				break;
			case "FIREFOX":
				driver = new ProxyDriver(new FirefoxDriver());
				break;

			default:
				throw new IllegalArgumentException();
			}
		}
		// wrap the instance of webdriver
		// e_driver = new EventFiringWebDriver(driver);
		// events which needs to be registered
		// events = new WebDriverEvents();
		// e_driver.register(events);
		// assigning the value to driver
		// driver = e_driver;
		driver.get(URL.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();

	}

	public MutableCapabilities getOption() {
		return new ManageInGridOptions().getOption(DEFAULT_BROWSER);
	}

	public void tearDown() {

		driver.quit();
	}

}
