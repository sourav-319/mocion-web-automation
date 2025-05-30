package com.mocion.web;

import com.mocion.web.pages.CourtsPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class CourtsTest extends BaseTest {
    public LoginPage loginPage;
    public CourtsPage courtsPage;
    public Random random;

    @Test(description = "Valid courts creation should successful")
    public void verify_court_creation_should_succeed() {
        random = new Random();
        courtsPage = new CourtsPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String courtsName = "test_courts_" + formattedNumber;
        String courtsDescription = "test_description";

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

        assertThat(courtsPage.getCourtsCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Valid courts edit should successful")
    public void verify_court_edit_should_succeed() {
        random = new Random();
        courtsPage = new CourtsPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String courtsName = "test_courts_" + formattedNumber;
        String courtsDescription = "test_description";

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickEditCourtButton()
                .clearCourtsNameField()
                .clearCourtsDescriptionField()
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

        assertThat(courtsPage.getCourtsEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Valid courts duplication should successful")
    public void verify_court_duplicate_should_succeed() {
        random = new Random();
        courtsPage = new CourtsPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String courtsName = "test_courts_" + formattedNumber;

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickDuplicateCourtButton()
                .clearCourtsNameField()
                .fillCourtsName(courtsName)
                .clickSaveButton();

        assertThat(courtsPage.getCourtsDuplicateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Courts deactivation should successful")
    public void verify_court_deactivate_should_succeed() {
        courtsPage = new CourtsPage(page);

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickDeactivateCourtButton()
                .clickYestToConfirmationTab();

        assertThat(courtsPage.getCourtsDeactivateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Courts activation should successful")
    public void verify_court_activate_should_succeed() {
        courtsPage = new CourtsPage(page);

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickActivateCourtButton()
                .clickYestToConfirmationTab();

        assertThat(courtsPage.getCourtsActivateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Courts searching should successful")
    public void verify_court_search_should_succeed() {
        String searchKeyword = "test_courts";
        courtsPage = new CourtsPage(page);

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clearSearchField()
                .fillSearchKeyword(searchKeyword);

        assertTrue(courtsPage.getSearchFirstRowResult().contains(searchKeyword));
    }

    @Test(description = "Courts filter should successful")
    public void verify_court_filter_should_succeed() {
        String searchKeyword = "test_courts";
        courtsPage = new CourtsPage(page);

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickFilterIcon()
                .clickFilterDropdown()
                .selectFilterOptionIndoor()
                .clickDateField()
                .clickDateForToday()
                .clickOutsideOfFilter();

        assertTrue(courtsPage.getSearchFirstRowResult().contains(searchKeyword));
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
