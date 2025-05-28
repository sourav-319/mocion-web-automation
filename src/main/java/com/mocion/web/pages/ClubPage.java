package com.mocion.web.pages;

import com.microsoft.playwright.Page;

public class ClubPage {
    private final Page page;

    public String organizationText = "p:has-text('Organization')";
    public String createClubButton = "button:has-text('Create')";
    public String clubNameField = "input[type='text']";
    public String landlineField = "input[name='phone_number']";
    public String mobileNumberField = "input[name='mobile_number']";
    public String addressField = "input[name='address']";
    public String aboutClubField = "textarea[name='about_club']";
    public String amenitiesFields = "input[type='checkbox']";
    public String clubLogoField = "input[name='logo']";
    public String clubImageField = "#clubImage";
    public String selectWorkingDaysDropdown = ".react-select__dropdown-indicator";
    public String selectWorkingDays = "All days";
    public String selectHourFrom = "#react-select-4-input";
    public String selectHourTo = "input.react-select__input[type='text']";
    public String accountHolderNameField = "input[name='account_holder_name']";
    public String bankNameField = "input[name='bank_name']";
    public String accountNumberField = "input[name='account_number']";
    public String ibanField = "input[name='iban']";
    public String swiftCodeField = "input[name='swift_code']";
    public String saveButton = "button[type='submit']:has-text('Save')";

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

    public ClubPage fillClubName(String clubName) {
        page.locator(clubNameField).fill(clubName);
        return this;
    }

    public ClubPage fillLandline(String landline) {
        page.locator(landlineField).fill(landline);
        return this;
    }

    public ClubPage fillMobileNumber(String mobileNumber) {
        page.locator(mobileNumberField).fill(mobileNumber);
        return this;
    }

    public ClubPage fillAddress(String address) {
        page.locator(addressField).fill(address);
        return this;
    }

    public ClubPage fillAboutClub(String aboutClub) {
        page.locator(aboutClubField).fill(aboutClub);
        return this;
    }

    public ClubPage selectAmenitiesEquipmentRental() {
        page.locator(amenitiesFields).nth(0).click();
        return this;
    }

    public ClubPage uploadClubLogo() {
        page.locator(clubLogoField).fill("src/main/resources/club_image.png");
        return this;
    }

    public ClubPage uploadClubImage() {
        page.locator(clubImageField).fill("src/main/resources/club_image.png");
        return this;
    }

    public ClubPage clickWorkingDaysDropdown() {
        page.locator(selectWorkingDaysDropdown).click();
        return this;
    }

    public ClubPage selectWorkingDays() {
        page.getByText(selectWorkingDays).click();
        return this;
    }

    public ClubPage selectHourFrom() {
        page.locator(selectHourFrom).fill("12:00 AM");
        return this;
    }

    public ClubPage selectHourTo() {
        page.locator(selectHourTo).fill("12:30 AM");
        return this;
    }

    public ClubPage fillAccountHolderName(String accountHolderName) {
        page.locator(accountHolderNameField).fill(accountHolderName);
        return this;
    }

    public ClubPage fillBankName(String bankName) {
        page.locator(bankNameField).fill(bankName);
        return this;
    }

    public ClubPage fillAccountNumber(String accountNumber) {
        page.locator(accountNumberField).fill(accountNumber);
        return this;
    }

    public ClubPage fillIban(String iban) {
        page.locator(ibanField).fill(iban);
        return this;
    }

    public ClubPage fillSwiftCode(String swiftCode) {
        page.locator(swiftCodeField).fill(swiftCode);
        return this;
    }

    public void clickSaveButton() {
        page.locator(saveButton).click();
    }
}
