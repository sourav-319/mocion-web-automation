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
    public String selectCourtName = "text='Court 1'";
    public String paymentMethodDropdown = ".react-select__control";
    public String paymentMethod = "text='Cash'";
    public String playerNameDropdown = ".react-select__control";
    public String playerMinLevel = "input[name='min_level']";
    public String playerMaxLevel = "input[name='max_level']";
    public String genderMale = ".undefined.accent-primary";
    public String bookingCreateSuccessMessage = "text='Successful.'";

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
        page.locator(selectSchedule).nth(3).click();
        page.locator(selectSchedule).nth(3).click();
        return this;
    }

    public BookingPage clickSaveButton() {
        page.locator(saveButton).nth(1).click();
        return this;
    }

    public BookingPage clickCourtNameDropdown() {
        page.locator(clickCourtNameDropdown).nth(1).click();
        return this;
    }

    public BookingPage selectCourtName() {
        page.locator(selectCourtName).nth(0).click();
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

    public BookingPage clickOwnerPaymentMethodDropdown() {
        page.locator(paymentMethodDropdown).nth(3).click();
        return this;
    }

    public BookingPage selectOwnerPaymentMethod() {
        page.locator(paymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerName() {
        page.locator(playerNameDropdown).nth(4).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectGenderMale() {
        page.locator(genderMale).nth(0).click();
        return this;
    }

    public BookingPage clickPlayerPaymentMethodDropdown() {
        page.locator(paymentMethodDropdown).nth(5).click();
        return this;
    }

    public BookingPage selectPlayerPaymentMethod() {
        page.locator(paymentMethod).nth(1).click();
        return this;
    }

    public void clickSavePrivateMatchButton() {
        page.locator(saveButton).click();
    }

    public Locator bookingCreateSuccessMessageLocator() {
        return page.locator(bookingCreateSuccessMessage);
    }
}
