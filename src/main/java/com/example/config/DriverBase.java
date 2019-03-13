package com.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverBase {
	public static DriverBase get() {
		return new DriverBase();
	}

	public WebDriver driver;
	private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
	private static final String REMOTE = System.getProperty("selenium.remote", "true");
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public WebDriver getDriver() {
		if (driverThread.get() == null) {
			switch (BROWSER) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver",
						"./src/main/resources/drivers/chromedriver-mac-64bit");
					if (Boolean.valueOf(REMOTE)) {
						driver = initRemoteDriver(DesiredCapabilities.chrome());
					} else {
						driver = new ChromeDriver();
					}
					driverThread.set(driver);
					break;

				case "firefox":
					System.setProperty("webdriver.gecko.driver",
						"./src/main/resources/drivers/geckodriver-mac-64bit");
					if (Boolean.valueOf(REMOTE)) {
						driver = initRemoteDriver(DesiredCapabilities.firefox());
					} else {
						driver = new FirefoxDriver();
					}
					driverThread.set(driver);
					break;
			}
		}
		return driverThread.get();
	}

	public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities) {
		RemoteWebDriver remoteDriver = null;
		try {
			remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return remoteDriver;
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
		driverThread.remove();
	}
}