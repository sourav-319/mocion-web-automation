package com.mocion.web.pages;

import com.microsoft.playwright.Page;

public class AcademyPage {
    private final Page page;

    public String coachingText = "text='Coaching'";
    public String academyText = "text='Academy'";
    public String createButton = "role=button[name='Create']";
    public String clubNameDropdown = "select[title='Club name here']";
public String academyCreateDropdowns = ".react-select__dropdown-indicator";
    public String academyNameField = "input[name='name']";
    public String courtTypeIndoor = "text='Indoor'";

    public AcademyPage(Page page) {
        this.page = page;
    }

    public AcademyPage clickCoachingFromNavigationBar() {
        page.locator(coachingText).click();
        return this;
    }

    public AcademyPage clickAcademyEventFromNavigationBar() {
        page.locator(academyText).click();
        return this;
    }

    public AcademyPage selectClubName(String clubName) {
        page.selectOption(clubNameDropdown, clubName);
        return this;
    }

    public AcademyPage clickCreateButton() {
        page.locator(createButton).click();
        return this;
    }

    public AcademyPage fillAcademyName(String academyName){
        page.locator(academyNameField).fill(academyName);
        return this;
    }

    public AcademyPage selectCourtTypeIndoor() {
        page.locator(academyCreateDropdowns).nth(0).click();
        page.locator(courtTypeIndoor).nth(1).click();
        return this;
    }
}
