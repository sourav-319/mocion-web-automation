package com.mocion.web;

import com.mocion.web.pages.CourtsPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.List;
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
        String courtsDescription = "test_courts_description";

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

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

    @Test(description = "Courts edit should successful")
    public void verify_court_edit_should_succeed() {
        random = new Random();
        courtsPage = new CourtsPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String courtsName = "test_courts_" + formattedNumber;
        String courtsDescription = "test_courts_description";

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickEditCourtButton()
                .clearCourtsNameField()
                .clearCourtsDescriptionField()
                .fillCourtsName(courtsName)
                .clickCourtTypeDropdown()
                .editCourtsType()
                .clickCourtSizeDropdown()
                .editCourtSize()
                .clickPrivacyDropdown()
                .editPrivacy()
                .editCourtsDescriptionField(courtsDescription)
                .clickSaveButton();

        assertThat(courtsPage.getCourtsEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Courts duplication should successful")
    public void verify_court_duplicate_should_succeed() {
        random = new Random();
        courtsPage = new CourtsPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String courtsName = "test_courts_" + formattedNumber;

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

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

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

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

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickMenuIcon()
                .clickActivateCourtButton()
                .clickYestToConfirmationTab();

        assertThat(courtsPage.getCourtsActivateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Courts searching should successful")
    public void verify_court_search_should_succeed() throws InterruptedException {
        String searchKeyword = "test_courts";
        courtsPage = new CourtsPage(page);

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clearSearchField()
                .fillSearchKeyword(searchKeyword);

        Thread.sleep(5000);
        if (courtsPage.getFirstRowSearchResultLocator().isVisible()) {
            assertTrue(courtsPage.getFirstRowSearchResult().contains(searchKeyword));
        } else {
            System.out.println("Court search result not found");
        }
    }

    @Test(description = "Courts filter should successful")
    public void verify_court_filter_should_succeed() {
        String searchKeyword = "test_courts";
        String dateFrom = "2025-05-31";
        String dateTo = "2026-05-31";
        String courtDescription = "test_courts_description";
        courtsPage = new CourtsPage(page);

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        courtsPage
                .clickCourtsFromNavigationBar()
                .clickFilterIcon()
                .clickCourtTypeFilterDropdown()
                .selectFilterOptionIndoor()
                .fillDateAddedFrom(dateFrom)
                .fillDateAddedTo(dateTo)
                .clickCourtPrivacyDropdown()
                .selectCourtPrivacy()
                .fillCourtDescriptionFilter(courtDescription)
                .selectAvailability();

        if (courtsPage.getFirstRowSearchResultLocator().isVisible()) {
            assertTrue(courtsPage.getFirstRowSearchResult().contains(searchKeyword));
        } else {
            System.out.println("Court filter result not found");
        }
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
