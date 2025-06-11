package com.mocion.test;

import com.mocion.web.pages.BookingPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BookingTest extends BaseTest {
    public LoginPage loginPage;
    public BookingPage bookingPage;

    @Test(description = "Public match booking create should successful")
    public void verify_public_match_booking_create_should_succeed() throws InterruptedException {
        String clubName = "club_test_007";
        String notes = "test_note";
        String minLevel = "0";
        String maxLevel = "1";

        bookingPage = new BookingPage(page);

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        bookingPage
                .clickBookingFromNavigationBar()
                .selectClubName(clubName)
                .clickCreateButton()
                .clickPublicMatch()
                .clickCheckScheduleButton()
                .selectSchedule()
                .clickSaveButton()
                .selectCourtName()
                .fillPlayerMinLevel(minLevel)
                .fillPlayerMaxLevel(maxLevel)
                .selectGenderMixed()
                .fillNotes(notes)
                .selectOwnerName()
                .selectOwnerPaymentMethod()
                .selectPlayerOneName()
                .selectPlayerOnePaymentMethod()
                .clickSavePublicMatchButton();

        assertThat(bookingPage.bookingCreateSuccessMessageLocator()).isVisible();
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
