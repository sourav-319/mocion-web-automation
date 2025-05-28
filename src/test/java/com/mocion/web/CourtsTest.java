package com.mocion.web;

import com.mocion.web.pages.CourtsPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CourtsTest extends BaseTest {
    public LoginPage loginPage;
    public CourtsPage courtsPage;

    @Test(description = "Valid courts creation should successful")
    public void verify_court_creation_should_succeed() {
        String courtsName = "test_courts_005";
        String courtsDescription = "test_description";

        courtsPage = new CourtsPage(page);

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickCreateCourtsButton()
                .fillCourtsName(courtsName)
                .clickCourtTypeDropdown()
                .selectCourtsType()
                .clickCourtSizeDropdown()
                .selectCourtSize()
                .clickPrivacyDropdown()
                .selectPrivacy()
                .fillCourtDescription(courtsDescription)
                .selectWorkingType()
                .clickSaveButton();

        assertThat(courtsPage.getSuccessfullMessageLocator()).isVisible();
    }

    private void userLogin() {
        loginPage = new LoginPage(page);

        page.navigate(prop.getProperty("baseUrl"));
        loginPage
                .fillUserEmail(prop.getProperty("userEmail"))
                .fillUserPassword(prop.getProperty("userPassword"))
                .clickLoginBtn();
    }
}
