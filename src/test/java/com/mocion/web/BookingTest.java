package com.mocion.web;

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
        String clubName = "Farah123";
        String notes = "test_note";
        String minLevel = "1";
        String maxLevel = "5";

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
                .clickCourtNameDropdown()
                .selectCourtName()
                .fillPlayerMinLevel(minLevel)
                .fillPlayerMaxLevel(maxLevel)
                .selectGenderMale()
                .fillNotes(notes)
                .selectOwnerName()
                .clickOwnerPaymentMethodDropdown()
                .selectOwnerPaymentMethod()
                .selectPlayerName()
                .clickPlayerPaymentMethodDropdown()
                .selectPlayerPaymentMethod()
                .clickSavePrivateMatchButton();

        assertThat(bookingPage.bookingCreateSuccessMessageLocator()).isVisible();
    }

    private void userLogin() {
        loginPage = new LoginPage(page);
        page.navigate(prop.getProperty("baseUrl"));
        loginPage
                .fillUserEmail(prop.getProperty("userEmail_2"))
                .fillUserPassword(prop.getProperty("userPassword_2"))
                .clickLoginBtn();
    }
}
