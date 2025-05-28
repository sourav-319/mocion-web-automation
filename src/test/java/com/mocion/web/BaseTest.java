package com.mocion.web;

import com.microsoft.playwright.Page;
import com.mocion.web.config.ConfigReader;
import com.mocion.web.factory.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public abstract class BaseTest {
    protected Page page;
    protected Properties prop;
    private PlaywrightFactory pf;

    @BeforeClass
    public void setUp() {
        prop = ConfigReader.init();
        pf = new PlaywrightFactory();
        page = pf.initBrowser(prop);
    }

    @AfterClass
    public void tearDown() {
        pf.tearDown();
    }
}
