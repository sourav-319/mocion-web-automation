package com.mocion.web.pages;

import com.microsoft.playwright.Page;

import static com.mocion.web.config.ConfigReader.prop;

public class LoginPage {
    private final Page page;

    public String userEmailField = "input[name='email']";
    public String passwordField = "input[name='password']";
    public String loginBtn = "button[type='submit']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void fillUserEmail(String email) {
        page.locator(userEmailField).fill(email);
    }

    public void fillUserPassword(String password) {
        page.locator(passwordField).fill(password);
    }

    public void clickLoginBtn() {
        page.click(loginBtn);
    }

    public void userLogin() {
        page.navigate(prop.getProperty("baseUrl"));
        fillUserEmail(prop.getProperty("userEmail_2"));
        fillUserPassword(prop.getProperty("userPassword_2"));
        clickLoginBtn();
    }
}
