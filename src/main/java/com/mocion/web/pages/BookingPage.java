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
    public String privateMatchText = "text='Private match'";
    public String friendlyGameTypeRadioButton = "input[type='radio'][value='friendly']";
    public String competitiveGameTypeRadioButton = "input[type='radio'][value='competitive']";
    public String priceTypeFull = "div.flex-1.p-2.text-center.rounded-lg";
    public String ownerPriceField = "input.bg-white.border.rounded-lg.p-3";
    public String savePrivateMatchButton = "button.bg-primary.text-white.rounded-full";

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

    public BookingPage selectSchedule(int scheduleIndex) {
        page.locator(selectSchedule).nth(scheduleIndex).click();
        page.locator(selectSchedule).nth(scheduleIndex).click();
        return this;
    }

    public BookingPage clickPrivateMatch() {
        page.locator(privateMatchText).click();
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

    public BookingPage selectOwnerName(int ownerNameIndex) {
        page.locator(clickCourtNameDropdown).nth(ownerNameIndex).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectOwnerPaymentMethod(int ownerPaymentMethodIndex) {
        page.locator(paymentMethodDropdown).nth(ownerPaymentMethodIndex).click();
        page.locator(ownerPaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerOneName(int playerOneNameIndex) {
        page.locator(playerNameDropdown).nth(playerOneNameIndex).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerTwoName(int playerTwoNameIndex) {
        page.locator(playerNameDropdown).nth(playerTwoNameIndex).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerThreeName(int playerThreeNameIndex) {
        page.locator(playerNameDropdown).nth(playerThreeNameIndex).click();
        page.keyboard().press("Enter");
        return this;
    }

    public BookingPage selectPlayerOnePaymentMethod(int playerOnePaymentMethodIndex) {
        page.locator(paymentMethodDropdown).nth(playerOnePaymentMethodIndex).click();
        page.locator(playerOnePaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerOnePaymentMethodAsInApp() {
        page.locator(paymentMethodDropdown).nth(5).click();
        page.locator(playerThreePaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerTwoPaymentMethod(int playerTwoPaymentMethodIndex) {
        page.locator(paymentMethodDropdown).nth(playerTwoPaymentMethodIndex).click();
        page.locator(playerTwoPaymentMethod).click();
        return this;
    }

    public BookingPage selectPlayerThreePaymentMethod(int playerThreePaymentMethodIndex) {
        page.locator(paymentMethodDropdown).nth(playerThreePaymentMethodIndex).click();
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

    public BookingPage selectGameTypeFriendly() {
        page.locator(friendlyGameTypeRadioButton).click();
        return this;
    }

    public BookingPage selectGameTypeCompetitive() {
        page.locator(competitiveGameTypeRadioButton).nth(0).click();
        return this;
    }

    public BookingPage selectPriceFull() {
        page.locator(priceTypeFull).nth(0).click();
        return this;
    }

    public BookingPage selectPriceSplit() {
        page.locator(priceTypeFull).nth(1).click();
        return this;
    }

    public BookingPage fillOwnerPrice(String ownerPrice) {
        page.locator(ownerPriceField).nth(2).fill(ownerPrice);
        return this;
    }

    public BookingPage fillPlayerOnePrice(String ownerPrice) {
        page.locator(ownerPriceField).nth(3).fill(ownerPrice);
        return this;
    }

    public BookingPage fillPlayerTwoPrice(String ownerPrice) {
        page.locator(ownerPriceField).nth(4).fill(ownerPrice);
        return this;
    }

    public BookingPage fillPlayerThreePrice(String ownerPrice) {
        page.locator(ownerPriceField).nth(5).fill(ownerPrice);
        return this;
    }

    public void clickSavePrivateMatchButton() {
        page.locator(savePrivateMatchButton).click();
    }

    public String getPaymentStatus() {
        return page.locator(paymentStatus).nth(0).textContent();
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
}
