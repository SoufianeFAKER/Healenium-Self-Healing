package com.e2eTests.automation.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.healenium.SelfHealingDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {

	//private static WebDriver driver;
	// public ConfigFileReader configFileReader = new ConfigFileReader();
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());
	
	static SelfHealingDriver driver;

	/**
	 * This method is used to open browser. This method is called before the
	 * invocation of each test method in the given class. In this method we need to
	 * pass browser name which will invoke the respective driver.
	 * 
	 * @throws MalformedURLException the malformed URL exception
	 * @Before Methods annotated with @Before will execute before every scenario.
	 */

	@Before
	public void setWebDriver(Scenario scenario) {

		LOGGER.info("Scenario: " + scenario.getName() + "- started");
		String browser = System.getProperty("browser");

		if (browser == null) {

			browser = "chrome";
		}

		switch (browser) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("--incognito");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("acceptInsecureCerts", true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("chrome.switches", "--disable-extensions");
			chromeOptions.addArguments("exclude-switches=disable-developer-mode-extensions");
			chromeOptions.addArguments("--disable-application-cache");
			chromeOptions.addArguments("--disk-cache-size=0");
			chromeOptions.addArguments("--clear-session-cache");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--disable-infobars");

			chromeOptions.addArguments("--start-maximized");

			WebDriver delegate = new ChromeDriver(chromeOptions);
			
			driver = SelfHealingDriver.create(delegate);

			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

			break;

		case "firefox":
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.setCapability("platform", Platform.WIN10);
//			driver = new FirefoxDriver(firefoxOptions);

			break;

		case "edge":

			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setCapability("platform", Platform.WIN10);
			//driver = new EdgeDriver(edgeOptions);
			break;

		default:
			throw new IllegalArgumentException("Browser\"" + browser + "\" is not supportes. ");
		}

		// driver.get(configFileReader.getProperties("home.url"));
	}

	/* GETTER */
	public static SelfHealingDriver getDriver() {
		return driver;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
