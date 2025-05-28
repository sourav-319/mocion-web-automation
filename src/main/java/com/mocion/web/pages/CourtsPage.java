package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CourtsPage {
    private final Page page;

    public String courtsText = "p:has-text('Courts')";
    public String createCourtButton = "button:has-text('Create')";
    public String courtsNameField = "input[name='name']";
    public String courtsTypeDropdown = ".react-select__dropdown-indicator";
    public String courtsTypeDropdownText = "Outdoor";
    public String courtsSizeDropdown = ".react-select__dropdown-indicator";
    public String courtsSizeDropdownText = "Single";
    public String courtsPrivacyDropdown = ".react-select__dropdown-indicator";
    public String courtsPrivacyDropdownText = "Private";
    public String courtsDescriptionField = "textarea[name='description']";
    public String selectWorkingType = "input[type='radio'][value='full']";
    public String clickSaveButton = "button[type='submit']";
    public String courtsCreateSuccessMessage = "text='Court created successfully'";

    public CourtsPage(Page page) {
        this.page = page;
    }

    public CourtsPage clickCourtsFromNavigationBar() {
        page.locator(courtsText).click();
        return this;
    }

    public CourtsPage clickCreateCourtsButton() {
        page.locator(createCourtButton).click();
        return this;
    }

    public CourtsPage fillCourtsName(String courtsName) {
        page.locator(courtsNameField).fill(courtsName);
        return this;
    }

    public CourtsPage clickCourtTypeDropdown() {
        page.locator(courtsTypeDropdown).nth(0).click();
        return this;
    }

    public CourtsPage selectCourtsType() {
        page.getByText(courtsTypeDropdownText).nth(0).click();
        return this;
    }

    public CourtsPage clickCourtSizeDropdown() {
        page.locator(courtsSizeDropdown).nth(1).click();
        return this;
    }

    public CourtsPage selectCourtSize() {
        page.getByText(courtsSizeDropdownText).nth(0).click();
        return this;
    }

    public CourtsPage clickPrivacyDropdown() {
        page.locator(courtsPrivacyDropdown).nth(2).click();
        return this;
    }

    public CourtsPage selectPrivacy() {
        page.getByText(courtsPrivacyDropdownText).nth(2).click();
        return this;
    }

    public CourtsPage fillCourtDescription(String courtsDescription) {
        page.locator(courtsDescriptionField).fill(courtsDescription);
        return this;
    }

    public CourtsPage selectWorkingType() {
        page.locator(selectWorkingType).click();
        return this;
    }

    public void clickSaveButton() {
        page.locator(clickSaveButton).click();
    }

    public Locator getSuccessfullMessageLocator() {
        return page.locator(courtsCreateSuccessMessage);
    }
}
