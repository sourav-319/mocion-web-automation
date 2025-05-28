package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ClubPage {
    private final Page page;

    public String organizationText = "p:has-text('Organization')";
    public String createClubButton = "button:has-text('Create')";
    public String clubNameField = "input[name='name']";
    public String landlineField = "input[name='phone_number']";
    public String mobileNumberField = "input[name='mobile_number']";
    public String addressField = "input[name='address']";
    public String aboutClubField = "textarea[name='about_club']";
    public String amenitiesFields = "input[type='checkbox']";
    public String clubLogoField = "#clubLogo";
    public String clubImageField = "#clubImage";
    public String selectWorkingDaysDropdown = ".react-select__dropdown-indicator";
    public String selectWorkingDays = "All days";
    public String selectHourFrom = "div.react-select__indicators >> svg[viewBox='0 0 16 16']";
    public String selectHourTo = "svg[viewBox='0 0 16 16']";
    public String accountHolderNameField = "input[name='account_holder_name']";
    public String bankNameField = "input[name='bank_name']";
    public String accountNumberField = "input[name='account_number']";
    public String ibanField = "input[name='iban']";
    public String swiftCodeField = "input[name='swift_code']";
    public String saveButton = "button[type='submit']:has-text('Save')";
    public String clubCreateSuccessMessage = "Club has been added successfully";

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
        page.locator(clubNameField).nth(1).fill(clubName);
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

    public ClubPage fillAddress() {
        page.locator("img[src='/static/media/AddressInputimage.e846467521100c215175898f6cc6e147.svg']").nth(1).click();
        page.locator("#autocomplete").fill("Arab Emirates");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
        page.locator("text='Close'").click();
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
        Locator clubLogo = page.locator(clubLogoField);
        clubLogo.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public ClubPage uploadClubImage() {
        Locator clubImage = page.locator(clubImageField);
        clubImage.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public ClubPage clickWorkingDaysDropdown() {
        page.locator(selectWorkingDaysDropdown).nth(1).click();
        return this;
    }

    public ClubPage selectWorkingDays() {
        page.getByText(selectWorkingDays).click();
        return this;
    }

    public ClubPage selectHourFrom() {
        page.locator(selectHourFrom).nth(0).click();
        page.getByText("12:00 AM").click();
        return this;
    }

    public ClubPage selectHourTo() {
        page.locator(selectHourFrom).nth(1).click();
        page.getByText("12:30 AM").click();
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
        page.locator(saveButton).last().click();
    }

    public Locator getSuccessfullMessageLocator(){
        return page.getByText(clubCreateSuccessMessage);
    }
}
