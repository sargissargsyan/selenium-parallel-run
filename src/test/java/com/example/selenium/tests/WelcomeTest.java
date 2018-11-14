package com.example.selenium.tests;

import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;
import com.example.pages.WelcomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WelcomeTest extends SeleniumBase {
	@Test
	public void welcomeSignIn(){
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.open();
		LoginPage loginPage = welcomePage.clickSignInButton();

		assertTrue(loginPage.getCurrentUrl().contains(loginPage.getPageUrl()), "Login should be in Login Page!");
	}

	@Test
	public void welcomeSignUp(){
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.open();
		RegisterPage registerPage = welcomePage.clickSignUpButton();

		assertTrue(registerPage.getCurrentUrl().contains(registerPage.getPageUrl()), "Login should be in Login Page!");
	}
}
