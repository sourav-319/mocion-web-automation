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
    public String courtsPrivacyDropdownText = "text='Private'";
    public String courtsDescriptionField = "textarea[name='description']";
    public String editCourtsDescriptionField = "textarea[name='bio']";
    public String selectWorkingType = "input[type='radio'][value='full']";
    public String clickSaveButton = "button[type='submit']";
    public String courtsCreateSuccessMessage = "text='Court created successfully'";
    public String editCourtsText = "text='Edit court'";
    public String menuIcon = "button:has(svg[viewBox='0 0 24 24'])";
    public String courtsEditSuccessMessage = "text='Court updated successfully'";
    public String duplicateCourtText = "text='Duplicate court'";
    public String duplicateCourtSuccessMessage = "text='Court created successfully'";
    public String deactivateCourtText = "button:has-text('Deactivate court')";
    public String activateCourtText = "button:has-text('Activate court')";
    public String yestToConfirmationTab = "button:has-text('Yes')";
    public String deactivationSuccessMessage = "text='Court has been deactivated successfully'";
    public String activationSuccessMessage = "text='Court has been activated successfully'";
    public String searchFirstRowResult = ".py-4.border-b.text-primary";
    public String searchField = "input[placeholder='Search']";
    public String courtTypeFilterDropdown = ".react-select__indicator.react-select__dropdown-indicator";
    public String filterIcon = ".flex.gap-2.items-center.border-main-1";
    public String filterDropdownText = "Indoor";
    public String dateFilter = "input[type='date']";
    public String courtPrivacy = "Private";
    public String courtDescriptionFilter = ".bg-white.dark\\:bg-primaryLight";
    public String availabilityFilterOption = "input[type='radio'][value='available']";

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

    public CourtsPage clearSearchField() {
        page.locator(searchField).clear();
        return this;
    }

    public CourtsPage clickFilterIcon() {
        page.locator(filterIcon).nth(2).click();
        return this;
    }

    public CourtsPage clickCourtTypeFilterDropdown() {
        page.locator(courtTypeFilterDropdown).nth(0).click();
        return this;
    }

    public CourtsPage clickCourtPrivacyDropdown() {
        page.locator(courtTypeFilterDropdown).nth(1).click();
        return this;
    }

    public CourtsPage selectCourtPrivacy() {
        page.getByText(courtPrivacy).nth(2).click();
        return this;
    }

    public CourtsPage fillCourtDescriptionFilter(String courtDescription) {
        page.locator(courtDescriptionFilter).nth(2).fill(courtDescription);
        return this;
    }

    public CourtsPage selectFilterOptionIndoor() {
        page.getByText(filterDropdownText).click();
        return this;
    }

    public CourtsPage fillDateAddedFrom(String dateFrom) {
        page.locator(dateFilter).nth(0).fill(dateFrom);
        return this;
    }

    public CourtsPage fillDateAddedTo(String dateTo) {
        page.locator(dateFilter).nth(1).fill(dateTo);
        return this;
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

    public CourtsPage editCourtsType() {
        page.getByText(courtsTypeDropdownText).nth(1).click();
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

    public CourtsPage editCourtSize() {
        page.getByText(courtsSizeDropdownText).nth(1).click();
        return this;
    }

    public CourtsPage clickPrivacyDropdown() {
        page.locator(courtsPrivacyDropdown).nth(2).click();
        return this;
    }

    public CourtsPage selectPrivacy() {
        page.locator(courtsPrivacyDropdownText).click();
        return this;
    }

    public CourtsPage editPrivacy() {
        page.locator(courtsPrivacyDropdownText).nth(1).click();
        return this;
    }

    public CourtsPage fillCourtDescription(String courtsDescription) {
        page.locator(courtsDescriptionField).fill(courtsDescription);
        return this;
    }

    public CourtsPage clearCourtsDescriptionField() {
        page.locator(editCourtsDescriptionField).clear();
        return this;
    }

    public CourtsPage editCourtsDescriptionField(String courtsDescription) {
        page.locator(editCourtsDescriptionField).fill(courtsDescription);
        return this;
    }

    public CourtsPage selectWorkingType() {
        page.locator(selectWorkingType).click();
        return this;
    }

    public void fillSearchKeyword(String searchKeyword) {
        page.locator(searchField).click();
        page.locator(searchField).fill(searchKeyword);
    }

    public void clickYestToConfirmationTab() {
        page.locator(yestToConfirmationTab).click();
    }

    public void selectAvailability() {
        page.locator(availabilityFilterOption).click();
    }

    public void clickSaveButton() {
        page.locator(clickSaveButton).click();
    }

    public String getFirstRowSearchResult() {
        return page.locator(searchFirstRowResult).first().textContent();
    }

    public Locator getFirstRowSearchResultLocator() {
        return page.locator(searchFirstRowResult).first();
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
        return page.locator(activationSuccessMessage);
    }
}
