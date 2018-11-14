package com.example.selenium.tests;

import com.example.config.DriverBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumBase {
	@BeforeMethod
	public void setupDriver() {
		DriverBase.get().getDriver();
	}

	@AfterMethod
	public void closeDriver() {
		DriverBase.get().quitDriver(DriverBase.get().getDriver());
	}
}
