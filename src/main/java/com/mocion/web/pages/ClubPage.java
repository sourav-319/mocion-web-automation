package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ClubPage {
    private final Page page;

    public String organizationText = "p:has-text('Organization')";
    public String createClubButton = "button:has-text('Create')";
    public String clubNameField = "input[name='name']";
    public String mobileNumberField = "input[name='mobile_number']";
    public String aboutClubField = "textarea[name='about_club']";
    public String amenitiesFields = "input[type='checkbox']";
    public String clubLogoField = "#clubLogo";
    public String clubImageField = "#clubImage";
    public String selectWorkingDaysDropdown = ".react-select__dropdown-indicator";
    public String selectWorkingDays = "All days";
    public String selectHourFrom = "div.react-select__indicators >> svg[viewBox='0 0 16 16']";
    public String accountHolderNameField = "input[name='account_holder_name']";
    public String bankNameField = "input[name='bank_name']";
    public String accountNumberField = "input[name='account_number']";
    public String ibanField = "input[name='iban']";
    public String swiftCodeField = "input[name='swift_code']";
    public String saveButton = "button[type='submit']:has-text('Save')";
    public String clubCreateSuccessMessage = "Club has been added successfully";
    public String mapIcon = "img[src='/static/media/AddressInputimage.e846467521100c215175898f6cc6e147.svg']";
    public String searchLocationField = "#autocomplete";
    public String menuIcon = "div.transition.duration-300.z-10.cursor-pointer >> svg[viewBox='0 0 24 24']";
    public String editClub = "text='Edit Club'";
    public String numberOfActiveBookingsField = "input[name='number_of_active_bookings']";
    public String addressField = "input[name='address']";
    public String clearClubImage = "img[alt='remove-image']";
    public String clearClubLogo = "text='Remove Logo'";
    public String cancellationPolicyHoursField = "input[name='cancellation_policy_hours']";
    public String bookingAheadLimitDaysField = "input[name='book_ahead_limit_days']";
    public String clubSchedule = "h3:has-text('Club schedule')";
    public String clubEditSuccessMessage = "Club has been edited successfully";
    public String numberOfMaximumBookingsDay = "input[name='maximum_bookings_day']";
    public String addWorkingHours = "img[alt='add']";
    public String duplicateClub = "button:has-text('Duplicate Club')";

    public ClubPage(Page page) {
        this.page = page;
    }

    public ClubPage clickOrganizationFromLeftNavigation() {
        page.locator(organizationText).click();
        return this;
    }

    public ClubPage clickCreateClubButton() {
        page.locator(createClubButton).click();
        return this;
    }

    public ClubPage clickEditClubFromMenu() {
        page.locator(editClub).click();
        return this;
    }

    public ClubPage clickDuplicateClub() {
        page.locator(duplicateClub).click();
        return this;
    }

    public ClubPage fillClubName(String clubName) {
        page.locator(clubNameField).nth(1).fill(clubName);
        return this;
    }

    public ClubPage editClubName(String clubName) {
        page.locator(clubNameField).fill(clubName);
        return this;
    }

    public ClubPage clearClubNameField() {
        page.locator(clubNameField).clear();
        return this;
    }

    public ClubPage fillMobileNumber(String mobileNumber) {
        page.locator(mobileNumberField).fill(mobileNumber);
        return this;
    }

    public ClubPage fillAddress() {
        page.locator(mapIcon).nth(1).click();
        page.locator(searchLocationField).fill("Arab Emirates");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
        page.locator("text='Close'").click();
        return this;
    }

    public ClubPage editAddress() {
        page.locator(mapIcon).click();
        page.locator(searchLocationField).fill("Arab Emirates");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
        page.locator("text='Close'").click();
        return this;
    }

    public ClubPage clearAddressField() {
        page.locator(addressField).clear();
        return this;
    }

    public ClubPage fillAboutClub(String aboutClub) {
        page.locator(aboutClubField).fill(aboutClub);
        return this;
    }

    public ClubPage clearAboutClubField() {
        page.locator(aboutClubField).clear();
        return this;
    }

    public ClubPage selectAmenitiesEquipmentRental() {
        page.locator(amenitiesFields).nth(0).click();
        return this;
    }

    public ClubPage editAmenitiesEquipmentRental() {
        page.locator(amenitiesFields).nth(1).click();
        return this;
    }

    public ClubPage uploadClubLogo() {
        Locator clubLogo = page.locator(clubLogoField);
        clubLogo.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public ClubPage clearClubLogo() {
        page.locator(clearClubLogo).click();
        return this;
    }

    public ClubPage uploadClubImage() {
        Locator clubImage = page.locator(clubImageField);
        clubImage.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public ClubPage clearClubImage() {
        page.locator(clearClubImage).click();
        return this;
    }

    public ClubPage fillCancellationPolicyHours(String policyHours) {
        page.locator(cancellationPolicyHoursField).fill(policyHours);
        return this;
    }

    public ClubPage clearCancellationPolicyHoursField() {
        page.locator(cancellationPolicyHoursField).clear();
        return this;
    }

    public ClubPage fillBookAheadLimitDays(String aheadLimitDays) {
        page.locator(bookingAheadLimitDaysField).fill(aheadLimitDays);
        return this;
    }

    public ClubPage clearBookAheadLimitDaysField() {
        page.locator(bookingAheadLimitDaysField).clear();
        return this;
    }

    public ClubPage fillMaximumBookingsDayField(String maximumBookingsDay) {
        page.locator(numberOfMaximumBookingsDay).fill(maximumBookingsDay);
        return this;
    }

    public ClubPage clearMaximumBookingsDayField() {
        page.locator(numberOfMaximumBookingsDay).clear();
        return this;
    }

    public ClubPage fillNumberOfActiveBookings(String numberOfActiveBookings) {
        page.locator(numberOfActiveBookingsField).fill(numberOfActiveBookings);
        return this;
    }

    public ClubPage clearNumberOfActiveBookingsField() {
        page.locator(numberOfActiveBookingsField).clear();
        return this;
    }

    public ClubPage clickWorkingDaysDropdown() {
        page.locator(selectWorkingDaysDropdown).nth(1).click();
        return this;
    }

    public ClubPage editWorkingDaysDropdown() {
        page.locator(selectWorkingDaysDropdown).nth(0).click();
        return this;
    }

    public ClubPage selectWorkingDays() {
        page.getByText(selectWorkingDays).click();
        return this;
    }

    public ClubPage editWorkingDays() {
        page.getByText(selectWorkingDays).nth(1).click();
        page.getByText(selectWorkingDays).nth(1).click();
        return this;
    }

    public ClubPage selectHourFrom() {
        page.locator(selectHourFrom).nth(0).click();
        page.getByText("12:00 AM").click();
        return this;
    }

    public ClubPage editHourFrom() {
        page.locator(selectHourFrom).nth(0).click();
        page.getByText("12:00 AM").nth(1).click();
        return this;
    }

    public ClubPage selectHourTo() {
        page.locator(selectHourFrom).nth(1).click();
        page.getByText("12:30 AM").click();
        return this;
    }

    public ClubPage editHourTo() {
        page.locator(selectHourFrom).nth(1).click();
        page.getByText("12:30 AM").nth(1).click();
        return this;
    }

    public ClubPage fillAccountHolderName(String accountHolderName) {
        page.locator(accountHolderNameField).fill(accountHolderName);
        return this;
    }

    public ClubPage clearAccountHolderNameField() {
        page.locator(accountHolderNameField).clear();
        return this;
    }

    public ClubPage fillBankName(String bankName) {
        page.locator(bankNameField).fill(bankName);
        return this;
    }

    public ClubPage clearBankNameField() {
        page.locator(bankNameField).clear();
        return this;
    }

    public ClubPage fillAccountNumber(String accountNumber) {
        page.locator(accountNumberField).fill(accountNumber);
        return this;
    }

    public ClubPage clearAccountNumberField() {
        page.locator(accountNumberField).clear();
        return this;
    }

    public ClubPage fillIban(String iban) {
        page.locator(ibanField).fill(iban);
        return this;
    }

    public ClubPage clearIbanField() {
        page.locator(ibanField).clear();
        return this;
    }

    public ClubPage fillSwiftCode(String swiftCode) {
        page.locator(swiftCodeField).fill(swiftCode);
        return this;
    }

    public ClubPage clearSwiftCodeField() {
        page.locator(swiftCodeField).clear();
        return this;
    }

    public ClubPage clickMenuIcon() {
        page.locator(menuIcon).nth(0).click();
        return this;
    }

    public ClubPage clickClubSchedule() {
        page.locator(clubSchedule).click();
        return this;
    }

    public void clickSaveButton() {
        page.locator(saveButton).last().click();
    }

    public Locator getClubCreateSuccessMessageLocator() {
        return page.getByText(clubCreateSuccessMessage);
    }

    public Locator clubEditSuccessMessageLocator() {
        return page.getByText(clubEditSuccessMessage);
    }
}
