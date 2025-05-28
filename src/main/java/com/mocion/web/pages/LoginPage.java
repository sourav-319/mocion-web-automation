package com.mocion.web.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public String userEmailField = "input[name='email']";
    public String passwordField = "input[name='password']";
    public String loginBtn = "button[type='submit']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage fillUserEmail(String email) {
        page.locator(userEmailField).fill(email);
        return this;
    }

    public LoginPage fillUserPassword(String password) {
        page.locator(passwordField).fill(password);
        return this;
    }

    public void clickLoginBtn() {
        page.click(loginBtn);
    }
}
