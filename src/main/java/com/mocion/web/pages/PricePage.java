package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PricePage {
    private final Page page;

    public String pricingText = "Pricing";
    public String generalText = "General";
    public String createButton = "button:has-text('Create')";
    public String pricingListNameFiled = "input[name='name']";
    public String hourlyRateField = "input[name='default_hourly_rate']";
    public String courtDropdown = ".react-select__indicator.react-select__dropdown-indicator";
    public String selectCourt = ".react-select__menu";
    public String startDateField = "label[for='start_date']";
    public String endDateField = "label[for='end_date']";
    public String saveButton = "button:has-text('Save')";
    public String priceListCreateSuccessMessage = "text='PriceList Created successfully'";
    public String priceListEditSuccessMessage = "text='PriceList Data edited successfully'";
    public String configureButton = "li.flex:has(p:text('Configure'))";
    public String menuIcon = ".flex-1.p-4.relative";
    public String duplicateButton = "li:has-text('Duplicate Price List')";
    public String deactivateButton = "button:has-text('Dectivate')";
    public String activateButton = "p:text('Activate')";
    public String yestToConfirmationTab = "button:has-text('Yes')";
    public String deleteButton = "button:has-text('Delete')";
    public String priceListDeleteSuccessMessage = "text='PriceList deleted successfully'";
    public String filterIcon = ".flex.gap-2.items-center.border-main-1";
    public String filterStatusDropdown = ".react-select__indicator.react-select__dropdown-indicator";
    public String selectStatus = "text='Active'";
    public String dateFromField = "input[type='date']";
    public String searchFirstRowResult = ".py-4.border-b.text-primary";

    public PricePage(Page page) {
        this.page = page;
    }

    public PricePage clickGeneralFromNavigationBar() {
        page.getByText(generalText).click();
        return this;
    }

    public PricePage clickPricingFromNavigationBar() {
        page.getByText(pricingText).click();
        return this;
    }

    public PricePage clickCreateButton() {
        page.locator(createButton).click();
        return this;
    }

    public PricePage clickDuplicateButton() {
        page.locator(duplicateButton).click();
        return this;
    }

    public PricePage clickMenuIcon() {
        page.locator(menuIcon).nth(0).click();
        return this;
    }

    public PricePage clickConfigureButton() {
        page.locator(configureButton).click();
        return this;
    }

    public PricePage clickDeactivateButton() {
        page.locator(deactivateButton).click();
        return this;
    }

    public PricePage clickActivateButton() {
        page.locator(activateButton).click();
        return this;
    }

    public PricePage clickDeleteButton() {
        page.locator(deleteButton).click();
        return this;
    }

    public PricePage clickFilterIcon() {
        page.locator(filterIcon).nth(1).click();
        return this;
    }

    public PricePage clickStatusDropdown() {
        page.locator(filterStatusDropdown).click();
        return this;
    }

    public PricePage selectStatusAsActive() {
        page.locator(selectStatus).nth(0).click();
        return this;
    }

    public PricePage selectDateFrom(String dateFrom) {
        page.locator(dateFromField).nth(0).fill(dateFrom);
        return this;
    }

    public void selectDateTo(String dateTo) {
        page.locator(dateFromField).nth(1).fill(dateTo);
    }

    public void clickYesToConfirmationTab() {
        page.locator(yestToConfirmationTab).click();
    }

    public PricePage clearPricingListName() {
        page.locator(pricingListNameFiled).clear();
        return this;
    }

    public PricePage fillPricingListName(String pricingListName) {
        page.locator(pricingListNameFiled).fill(pricingListName);
        return this;
    }

    public PricePage clearHourlyRateField() {
        page.locator(hourlyRateField).clear();
        return this;
    }

    public PricePage fillHourlyRateField(String hourlyRate) {
        page.locator(hourlyRateField).fill(hourlyRate);
        return this;
    }

    public PricePage clickCourtsDropdown() {
        page.locator(courtDropdown).click();
        return this;
    }

    public PricePage selectCourt() {
        page.locator(selectCourt).nth(0).click();
        return this;
    }

    public PricePage fillStartDateField() {
        page.locator(startDateField).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PricePage fillEndDateField() {
        page.locator(endDateField).click();
        page.keyboard().press("Enter");
        return this;
    }

    public void clickSaveButton() {
        page.locator(saveButton).nth(0).click();
    }

    public String getFirstRowSearchResult() {
        return page.locator(searchFirstRowResult).first().textContent();
    }

    public Locator getPriceListCreateSuccessMessageLocator() {
        return page.locator(priceListCreateSuccessMessage);
    }

    public Locator getPriceListEditSuccessMessageLocator() {
        return page.locator(priceListEditSuccessMessage);
    }

    public Locator getPriceListDuplicateSuccessMessageLocator() {
        return page.locator(priceListCreateSuccessMessage);
    }

    public Locator getPriceListDeactivateSuccessMessageLocator() {
        return page.locator(priceListEditSuccessMessage);
    }

    public Locator getPriceListActivateSuccessMessageLocator() {
        return page.locator(priceListEditSuccessMessage);
    }

    public Locator getPriceListDeleteSuccessMessageLocator() {
        return page.locator(priceListDeleteSuccessMessage);
    }

    public Locator getFirstRowSearchResultLocator() {
        return page.locator(searchFirstRowResult).first();
    }
}
