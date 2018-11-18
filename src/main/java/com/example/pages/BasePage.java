package com.example.pages;

import com.example.config.DriverBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T>  {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final String BASE_URL = "http://10.39.18.93:8080";

	public BasePage() {
		this.driver = DriverBase.get().getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public T openPage(Class<T> clazz) {
		T page = PageFactory.initElements(driver, clazz);
		driver.get(BASE_URL + getPageUrl());
		return page.get();
	}

	public void open(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public abstract String getPageUrl();

	public void type(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		element.sendKeys(text);
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {

	}
}
