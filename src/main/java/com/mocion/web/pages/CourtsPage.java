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
    public String courtsDescriptionField = "textarea[name='bio']";
    public String selectWorkingType = "input[type='radio'][value='full']";
    public String clickSaveButton = "button[type='submit']";
    public String courtsCreateSuccessMessage = "text='Court created successfully'";
    public String editCourtsText = "text='Edit court'";
    public String menuIcon = "button:has(svg[viewBox='0 0 24 24'])";
    public String courtsEditSuccessMessage = "Court updated successfully";
    public String duplicateCourtText = "text='Duplicate court'";
    public String duplicateCourtSuccessMessage = "Court created successfully";
    public String deactivateCourtText = "button:has-text('Deactivate court')";
    public String activateCourtText = "button:has-text('Deactivate court')";
    public String yestToConfirmationTab = "button:has-text('Yes')";
    public String deactivationSuccessMessage = "Court has been deactivated successfully";
    public String searchFirstRowResult = ".py-4.border-b.text-primary";
    public String searchField = "input[placeholder='Search']";
    public String filterDropdown = "div.react-select__dropdown-indicator:has(svg[viewBox='0 0 20 20'])";
    public String filterIcon = "button:has(svg[viewBox='0 0 32 32'])";
    public String filterDropdownText = "Indoor";
    public String dateFilter = "input[type='date']";
    public String selectDateToday = "Today";
    public String allCourtText = "All courts";

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

    public CourtsPage clickMenuIcon() {
        page.locator(menuIcon).nth(0).click();
        return this;
    }

    public CourtsPage clickEditCourtButton() {
        page.locator(editCourtsText).click();
        return this;
    }

    public CourtsPage clickDuplicateCourtButton() {
        page.locator(duplicateCourtText).click();
        return this;
    }

    public CourtsPage clickDeactivateCourtButton() {
        page.locator(deactivateCourtText).click();
        return this;
    }

    public CourtsPage clickActivateCourtButton() {
        page.locator(activateCourtText).click();
        return this;
    }

    public void clickYestToConfirmationTab() {
        page.locator(yestToConfirmationTab).click();
    }

    public String getSearchFirstRowResult() {
        return page.locator(searchFirstRowResult).first().textContent();
    }

    public CourtsPage clearSearchField() {
        page.locator(searchField).clear();
        return this;
    }

    public void fillSearchKeyword(String searchKeyword) {
        page.locator(searchField).click();
        page.locator(searchField).fill(searchKeyword);
    }

    public CourtsPage clickFilterIcon() {
        page.locator(filterIcon).click();
        return this;
    }

    public CourtsPage clickFilterDropdown() {
        page.locator(filterDropdown).click();
        return this;
    }

    public CourtsPage selectFilterOptionIndoor() {
        page.getByText(filterDropdownText).click();
        return this;
    }

    public CourtsPage clickDateField() {
        page.locator(dateFilter).click();
        return this;
    }

    public CourtsPage clickDateForToday() {
        page.getByText(selectDateToday).click();
        return this;
    }

    public void clickOutsideOfFilter() {
        page.locator(allCourtText).click();
    }

    public CourtsPage fillCourtsName(String courtsName) {
        page.locator(courtsNameField).fill(courtsName);
        return this;
    }

    public CourtsPage clearCourtsNameField() {
        page.locator(courtsNameField).clear();
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
        page.getByText(courtsPrivacyDropdownText).nth(0).click();
        return this;
    }

    public CourtsPage fillCourtDescription(String courtsDescription) {
        page.locator(courtsDescriptionField).fill(courtsDescription);
        return this;
    }

    public CourtsPage clearCourtsDescriptionField() {
        page.locator(courtsDescriptionField).clear();
        return this;
    }

    public CourtsPage selectWorkingType() {
        page.locator(selectWorkingType).click();
        return this;
    }

    public void clickSaveButton() {
        page.locator(clickSaveButton).click();
    }

    public Locator getCourtsCreateSuccessMessageLocator() {
        return page.locator(courtsCreateSuccessMessage);
    }

    public Locator getCourtsEditSuccessMessageLocator() {
        return page.locator(courtsEditSuccessMessage);
    }

    public Locator getCourtsDuplicateSuccessMessageLocator() {
        return page.locator(duplicateCourtSuccessMessage);
    }

    public Locator getCourtsDeactivateSuccessMessageLocator() {
        return page.locator(deactivationSuccessMessage);
    }

    public Locator getCourtsActivateSuccessMessageLocator() {
        return page.locator(activateCourtText);
    }
}
