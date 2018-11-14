package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(css = ".well.sidebar-nav")
	private WebElement sideBar;


	public boolean isSideBarDisplayed() {
		return isElementDisplayed(sideBar);
	}
	@Override
	public String getPageUrl() {
		return "/user/todos";
	}
}
