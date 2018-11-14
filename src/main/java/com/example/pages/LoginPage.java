package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(css = "button.btn-primary")
	private WebElement signInButton;

	@FindBy(css = ".alert.alert-error")
	private WebElement errorMessage;


	public void login(String email, String password) {
		type(emailField, email);
		type(passwordField, password);
		signInButton.click();
	}

	public LoginPage open() {
		openPage(this.getClass());
		return this;
	}

	public boolean isErrorMessageDisplayed() {
		return isElementDisplayed(errorMessage);
	}

	public String getErrorMessgaeText() {
		return errorMessage.getText();
	}


	@Override
	public String getPageUrl() {
		return "/login";
	}
}