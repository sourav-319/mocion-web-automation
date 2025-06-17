package com.mocion.test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.mocion.web.pages.BookingPage;
import com.mocion.web.pages.LoginPage;
import org.testng.Assert;
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
                .selectPlayerTwoName()
                .selectPlayerTwoPaymentMethod()
                .selectPlayerThreeName()
                .selectPlayerThreePaymentMethod()
                .clickSavePublicMatchButton();

        assertThat(bookingPage.bookingCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Cancel booking with refund should successful")
    public void verify_cancel_booking_with_refund_should_succeed() throws InterruptedException {
        String clubName = "Farah123";
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
                .clickSavePublicMatchButton()
                .clickCloseIcon();
        bookingPage
                .clickMenuIcon()
                .clickCancelBooking()
                .clickCancelWithRefundButton();

        bookingPage
                .bookingCancelSuccessMessageLocator()
                .waitFor(new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE));
        assertThat(bookingPage.bookingCancelSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Cancel booking without refund should successful")
    public void verify_cancel_booking_without_refund_should_succeed() throws InterruptedException {
        String clubName = "Farah123";
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
                .selectPlayerThreeName()
                .selectPlayerThreePaymentMethod()
                .clickSavePublicMatchButton()
                .clickCloseIcon();
        bookingPage
                .clickMenuIcon()
                .clickCancelBooking()
                .clickCancelWithoutRefundButton();

        bookingPage
                .bookingCancelSuccessMessageLocator()
                .waitFor(new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE));
        assertThat(bookingPage.bookingCancelSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Booking payment status should display paid when all player payments are paid should successful")
    public void verify_booking_payment_status_should_display_paid_when_all_player_payments_are_paid_should_succeed() throws InterruptedException {
        String clubName = "Farah123";
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
                .selectPlayerTwoName()
                .selectPlayerTwoPaymentMethod()
                .selectPlayerThreeName()
                .selectPlayerThreePaymentMethodAsCash()
                .clickSavePublicMatchButton()
                .clickCloseIcon();

        Assert.assertTrue(bookingPage.getPaymentStatus().contains("Paid"));
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
