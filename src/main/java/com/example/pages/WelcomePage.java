package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class WelcomePage extends BasePage {
	@FindBys({
		@FindBy(css = ".btn.btn-primary")
	})
	private List<WebElement> buttons;

	@Override
	public String getPageUrl() {
		return "";
	}

	public WelcomePage open() {
		openPage(this.getClass());
		return this;
	}

	public LoginPage clickSignInButton() {
		click(buttons.get(0));
		return new LoginPage();
	}

	public RegisterPage clickSignUpButton() {
		click(buttons.get(1));
		return new RegisterPage();
	}

}
