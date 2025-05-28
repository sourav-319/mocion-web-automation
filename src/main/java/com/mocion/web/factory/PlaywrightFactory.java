package com.mocion.web.factory;

import com.microsoft.playwright.*;

import java.util.Properties;

public class PlaywrightFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Properties prop;

    public Page initBrowser(Properties prop) {
        this.prop = prop;
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
