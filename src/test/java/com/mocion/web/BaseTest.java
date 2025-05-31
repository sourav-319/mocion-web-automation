package com.mocion.web;

import com.microsoft.playwright.Page;
import com.mocion.web.config.ConfigReader;
import com.mocion.web.factory.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public abstract class BaseTest {
    protected Page page;
    protected Properties prop;
    private PlaywrightFactory pf;

    @BeforeClass
    public void setUpClass() {
        prop = ConfigReader.init();
        pf = new PlaywrightFactory();
        pf.initBrowser();
    }

    @BeforeMethod
    public void setUp() {
        page = pf.newPage();
    }

    @AfterMethod
    public void tearDown() {
        if (page != null && page.context() != null) {
            page.context().close();
        }
    }

    @AfterClass
    public void tearDownClass() {
        pf.tearDown();
    }
}
