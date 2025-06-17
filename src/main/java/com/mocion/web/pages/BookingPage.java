package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BookingPage {
    private final Page page;

    public String bookingText = "text='Booking'";
    public String clubNameDropdown = "select[title='Club name here']";
    public String createButton = "role=button[name='Create']";
    public String publicMatchText = "text='Public match'";
    public String checkScheduleButton = "role=button[name='Check schedule']";
    public String selectSchedule = "div[class*='bg-transparen']";
    public String saveButton = "role=button[name='Save']";
    public String clickCourtNameDropdown = ".react-select__control";
    public String notesField = "textarea[name='notes']";
    public String paymentMethodDropdown = ".react-select__control";
    public String playerNameDropdown = ".react-select__control";
    public String playerMinLevel = "input[name='min_level']";
    public String playerMaxLevel = "input[name='max_level']";
    public String genderMale = ".undefined.accent-primary";
    public String bookingCreateSuccessMessage = "text='Successful.'";
    public String ownerPaymentMethod = "text='Cash'";
    public String playerOnePaymentMethod = "text='Credit/Debit card'";
    public String playerTwoPaymentMethod = "text='Bank transfer'";
    public String playerThreePaymentMethod = "text='In app'";
    public String bookingCreateCloseIcon = "button img[alt='Close']";
    public String menuIcon = "div.mx-auto.cursor-pointer";
    public String cancelBookingText = "text='Cancel Booking'";
    public String bookingCancelSuccessMessage = "text='Booking canceled successfully'";
    public String cancelWithRefundButton = "text='Cancel with refund'";
    public String cancelWithoutRefundButton = "text='Cancel without refund'";
    public String paymentStatus = ".grid.px-4.py-2.rounded-3xl.text-primary";

    public BookingPage(Page page) {
        this.page = page;
    }

    public BookingPage clickBookingFromNavigationBar() {
        page.locator(bookingText).click();
        return this;
    }

    public BookingPage selectClubName(String clubName) {
        page.selectOption(clubNameDropdown, clubName);
        return this;
    }

    public BookingPage clickCreateButton() {
        page.locator(createButton).click();
        return this;
    }

    public BookingPage clickPublicMatch() {
        page.locator(publicMatchText).click();
        return this;
    }

    public BookingPage clickCheckScheduleButton() {
        page.locator(checkScheduleButton).click();
        return this;
    }

    public BookingPage selectSchedule() {
        page.locator(selectSchedule).nth(2).click();
        page.locator(selectSchedule).nth(2).click();
        return this;
    }

    public BookingPage clickSaveButton() {
        page.locator(saveButton).nth(1).click();
        return this;
    }

    public BookingPage selectCourtName() {
        page.locator(clickCourtNameDropdown).nth(1).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage fillPlayerMinLevel(String minLevel) {
        page.locator(playerMinLevel).fill(minLevel);
        return this;
    }

    public BookingPage fillPlayerMaxLevel(String maxLevel) {
        page.locator(playerMaxLevel).fill(maxLevel);
        return this;
    }

    public BookingPage fillNotes(String notes) {
        page.locator(notesField).fill(notes);
        return this;
    }

    public BookingPage selectOwnerName() {
        page.locator(clickCourtNameDropdown).nth(2).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectOwnerPaymentMethod() {
        page.locator(paymentMethodDropdown).nth(3).click();
        page.locator(ownerPaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerOneName() {
        page.locator(playerNameDropdown).nth(4).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerTwoName() {
        page.locator(playerNameDropdown).nth(6).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerThreeName() {
        page.locator(playerNameDropdown).nth(8).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerOnePaymentMethod() {
        page.locator(paymentMethodDropdown).nth(5).click();
        page.locator(playerOnePaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerOnePaymentMethodAsInApp() {
        page.locator(paymentMethodDropdown).nth(5).click();
        page.locator(playerThreePaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerTwoPaymentMethod() {
        page.locator(paymentMethodDropdown).nth(7).click();
        page.locator(playerTwoPaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerThreePaymentMethod() {
        page.locator(paymentMethodDropdown).nth(9).click();
        page.locator(playerThreePaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerThreePaymentMethodAsCash() {
        page.locator(paymentMethodDropdown).nth(9).click();
        page.locator(ownerPaymentMethod).nth(1).click();
        return this;
    }

    public BookingPage selectGenderMixed() {
        page.locator(genderMale).nth(2).click();
        return this;
    }

    public BookingPage clickSavePublicMatchButton() {
        page.locator(saveButton).click();
        return this;
    }

    public void clickCloseIcon() {
        page.locator(bookingCreateCloseIcon).click();
    }

    public void clickCancelWithRefundButton() {
        page.locator(cancelWithRefundButton).click();
    }

    public BookingPage clickCancelBooking() {
        page.locator(cancelBookingText).click();
        return this;
    }

    public BookingPage clickMenuIcon() {
        page.locator(menuIcon).nth(0).click();
        return this;
    }

    public void clickCancelWithoutRefundButton() {
        page.locator(cancelWithoutRefundButton).click();
    }

    public Locator bookingCreateSuccessMessageLocator() {
        return page.locator(bookingCreateSuccessMessage);
    }

    public Locator bookingCancelSuccessMessageLocator() {
        return page.locator(bookingCancelSuccessMessage);
    }

    public String getPaymentStatus() {
        return page.locator(paymentStatus).nth(0).textContent();
    }
}
