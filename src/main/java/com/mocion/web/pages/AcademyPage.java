package com.mocion.web.pages;

import com.microsoft.playwright.Page;

import java.util.Arrays;
import java.util.List;

public class AcademyPage {
    private final Page page;

    public String coachingText = "text='Coaching'";
    public String academyText = "text='Academy'";
    public String createButton = "role=button[name='Create']";
    public String clubNameDropdown = "select[title='Club name here']";
    public String academyCreateDropdowns = ".react-select__dropdown-indicator";
    public String academyNameField = "input[name='name']";
    public String courtTypeIndoor = "text='Indoor'";
    public String courtPrivacyPublic = "text='Public'";
    public String registrationPricePerPlayerField = "input[name='registration_price_per_player']";
    public String genderBoth = "input[type='radio'][value='both']";
    public String maximumNumberOfPlayersField = "input[name='max_number_of_players']";
    public String bookingInAppOn = "input[type='radio'][value='true']";
    public String dateFields = "div.absolute.right-1.top-2 svg";
    public String startTime = "input[name='start_time']";
    public String endTime = "input[name='end_time']";

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

    public AcademyPage fillAcademyName(String academyName) {
        page.locator(academyNameField).fill(academyName);
        return this;
    }

    public AcademyPage selectCourtTypeIndoor() {
        page.locator(academyCreateDropdowns).nth(0).click();
        page.locator(courtTypeIndoor).nth(1).click();
        return this;
    }

    public AcademyPage selectCourtPrivacyPublic() {
        page.locator(academyCreateDropdowns).nth(1).click();
        page.locator(courtPrivacyPublic).click();
        return this;
    }

    public AcademyPage selectCoach() {
        page.locator(academyCreateDropdowns).nth(2).click();
        page.keyboard().press("Enter");
        return this;
    }

    public AcademyPage fillRegistrationPricePerPlayer(String registrationPricePerPlayer) {
        page.locator(registrationPricePerPlayerField).fill(registrationPricePerPlayer);
        return this;
    }

    public AcademyPage fillMaximumNumberOfPlayers(String maximumNumberOfPlayers) {
        page.locator(maximumNumberOfPlayersField).fill(maximumNumberOfPlayers);
        return this;
    }

    public AcademyPage selectGenderBoth() {
        page.locator(genderBoth).click();
        return this;
    }

    public AcademyPage selectBookingInAppOn() {
        page.locator(bookingInAppOn).click();
        return this;
    }

    public AcademyPage selectStartDate() {
        page.locator(dateFields).nth(0).click();
        page.keyboard().press("Enter");
        return this;
    }

    public AcademyPage selectEndDate() {
        page.locator(dateFields).nth(1).click();
        page.keyboard().press("Enter");
        return this;
    }

    public AcademyPage selectAllowedDays(List<String> daysToSelect) {
        List<String> allDays = Arrays.asList(
                "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"
        );

        page.locator(academyCreateDropdowns).nth(3).click();

        for (String day : daysToSelect) {
            int index = allDays.indexOf(day);
            if (index == -1) {
                throw new IllegalArgumentException("Invalid day: " + day);
            }

            for (int i = 0; i < index; i++) {
                page.keyboard().press("ArrowDown");
            }
            page.keyboard().press("Enter");
        }

        return this;
    }

    public AcademyPage selectStartTime() {
        page.locator(startTime).fill("06:00");
        return this;
    }

    public AcademyPage selectEndTime() {
        page.locator(endTime).fill("22:00");
        return this;
    }
}
