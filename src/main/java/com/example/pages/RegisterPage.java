package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "email.errors")
	private WebElement emailErrorMessaege;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "confirmationPassword")
	private WebElement confirmPasswordField;

	@FindBy(css = "button.btn-primary")
	private WebElement signUpButton;

	@FindBy(css = ".alert.alert-error")
	private WebElement errorMessage;


	public RegisterPage open() {
		openPage(this.getClass());
		return this;
	}

	public void setName(String name) {
		type(nameField, name);
	}

	public void setEmail(String email) {
		type(emailField, email);
	}

	public void setPassword(String password) {
		type(passwordField, password);
	}

	public void setConfirmPassword(String password) {
		type(confirmPasswordField, password);
	}

	public HomePage clickSignUp() {
		click(signUpButton);
		return new HomePage();
	}

	public boolean isErrorMessageDisplayed() {
		return isElementDisplayed(errorMessage);
	}

	public boolean isEmailErrorMessageDisplayed() {
		return isElementDisplayed(emailErrorMessaege);
	}

	@Override
	public String getPageUrl() {
		return "/register";
	}
}
