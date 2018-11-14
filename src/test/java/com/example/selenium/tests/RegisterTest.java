package com.example.selenium.tests;

import com.example.pages.HomePage;
import com.example.pages.RegisterPage;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class RegisterTest extends SeleniumBase {

	@Test
	public void failedRegistration() {
		RegisterPage registerPage = new RegisterPage().open();
		registerPage.setName("SQA Days");
		registerPage.setEmail("SQA Days");
		registerPage.setPassword("123456");
		registerPage.setConfirmPassword("123456");
		registerPage.clickSignUp();

		assertTrue(registerPage.isErrorMessageDisplayed(), "Error Message should be displayed!");
		assertTrue(registerPage.isEmailErrorMessageDisplayed(), "Error Message should be displayed!");
	}

	@Test
	public void successRegistration() {
		RegisterPage registerPage = new RegisterPage().open();
		registerPage.setName("SQA Days");
		registerPage.setEmail(new Date().getTime() + "SQA@Days.ru");
		registerPage.setPassword("123456");
		registerPage.setConfirmPassword("123456");
		HomePage homePage = registerPage.clickSignUp();

		assertTrue(homePage.getCurrentUrl().contains(homePage.getPageUrl()), "User should be navigated to Home page!");
	}


}
