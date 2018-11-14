package com.example.selenium.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginText extends SeleniumBase {

    @Test
    public void successLogin() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login("foo@bar.org", "foobar");

        assertTrue(new HomePage().isSideBarDisplayed(), "User was not Logged in!");
    }

    @Test
    public void failLogin()  {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login("fail@bar.org", "fail");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message wes not displayed!");
        assertEquals(loginPage.getErrorMessgaeText(), "Login failed! please fix the following errors:","Error message wes not displayed!");
    }
}