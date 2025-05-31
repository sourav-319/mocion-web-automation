package com.mocion.web.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private Playwright playwright;
    private Browser browser;

    public void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
    }

    public Page newPage() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        return page;
    }

    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
