package com.example.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public static DriverBase get() {
		return new DriverBase();
	}

	public WebDriver driver;
	private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public WebDriver getDriver() {
		if (driverThread.get() == null) {
			switch (BROWSER) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver",
						"./src/main/resources/drivers/chromedriver-mac-64bit");
					driver = new ChromeDriver();
					driverThread.set(driver);
					break;

				case "firefox":
					System.setProperty("webdriver.gecko.driver",
						"./src/main/resources/drivers/geckodriver-mac-64bit");
					driver = new FirefoxDriver();
					driverThread.set(driver);
					break;
			}
		}
		return driverThread.get();
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
		driverThread.remove();
	}
}