package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TournamentsPage {
    private final Page page;

    public String bookingText = "text='Booking'";
    public String clubNameDropdown = "select[title='Club name here']";
    public String menuIcon = "button[class*='flex']:has(svg)";
    public String createButton = "role=button[name='Create']";
    public String tournamentsText = "text='Tournaments'";
    public String editTournamentsText = "text='Edit tournaments'";
    public String addPlayerText = "text='Add Players'";
    public String addPlayerButton = "text='Add Players'";
    public String nameInputField = "input[name='name']";
    public String organizationNameField = "input[name='organizer_name']";
    public String tournamentDescriptionField = "input[name='description']";
    public String sponsorField = "input[name='sponsor_ids.0.name']";
    public String sponsorLogoField = "label[for='clubLogo']";
    public String prizeField = "input[name='prize_ids.0.name']";
    public String tournamentImageField = "input#trn_image_upload";
    public String numberOfPlayerDropdown = ".react-select__dropdown-indicator";
    public String addPlayerNameDropdown = ".react-select.__dropdown-indicator";
    public String addPaymentMethodDropdown = ".react-select w-full__indicators";
    public String minPlayerLevelField = "input[name='min_players_level']";
    public String maxPlayerLevelField = "input[name='max_players_level']";
    public String tournamentStyleKnockout = "input[type='radio'][value='Knockouts']";
    public String tournamentStyleRound = "input[type='radio'][value='Round Robin']";
    public String playerJoiningTypeSingle = "input[type='radio'][value='Single']";
    public String playerJoiningTypeDouble = "input[type='radio'][value='Double']";
    public String playerJoiningTypeBoth = "input[type='radio'][value='Both']";
    public String termsAndConditionsField = "input[name='terms_and_conditions']";
    public String nextButton = "button.bg-primary.text-white.rounded-full";
    public String pricePerPlayerField = "input[name='price_per_player']";
    public String genderMixed = "input[type='radio'][value='Mixed']";
    public String eventTypeCompetitive = "input[type='radio'][value='competitive']";
    public String eventTypeFriendly = "input[type='radio'][value='friendly']";
    public String eventTypePrivate = "input[type='radio'][value='private']";
    public String eventTypePublic = "input[type='radio'][value='public']";

    public String startDate = "label[for='start_date']";
    public String endDate = "label[for='end_date']";
    public String registrationDeadline = "label[for='registration_deadline_date']";
    public String allowedCourts = "div.react-select__indicator.react-select__dropdown-indicator";
    public String allowedDays = "div.react-select__indicator.react-select__dropdown-indicator";
    public String matchDuration = "div.react-select__indicator.react-select__dropdown-indicator";
    public String startTime = "input[name='start_time']";
    public String endTime = "input[name='end_time']";
    public String setPerMatchOne = "input[type='radio'][value='1']";
    public String selectCourt = ".p-2.ml-2.px-4.rounded-lg.whitespace-nowrap";
    public String saveAndPublishButton = "text='Save and publish'";
    public String checkAvailabilityButton = "button:text('Check court availibility')";
    public String okButton = "//button[text()='Ok']";
    public String tournamentCreateSuccessMessage = "text='Successful.'";
    public String tournamentEditSuccessMessage = "text='tournament has been updated successfully'";

    public String chatWithPlayersText = "li:has-text('chat with players')";
    public String firstConversation = ".w-full.flex.px-8";
    public String conversationTextInputField = ".editable.w-full.pt-2";
    public String sendMessageIcon = ".lucide.lucide-send";
    public String sentMessageText = ".flex.flex-col.gap-2.py-2.pr-2";
    public String duplicateText = "li:has-text('Duplicate')";
    public String cancelTournamentText = "text=Cancel tournament";
    public String yesButtonToCancelTournament = "button:has-text('Yes')";
    public String tournamentCancelSuccessMessage = "text='tournament has been canceled successfully'";

    public TournamentsPage(Page page) {
        this.page = page;
    }

    public TournamentsPage clickBookingFromNavigationBar() {
        page.locator(bookingText).click();
        return this;
    }

    public TournamentsPage clickCancelTournament() {
        page.locator(cancelTournamentText).click();
        return this;
    }

    public TournamentsPage clickDuplicate() {
        page.locator(duplicateText).click();
        return this;
    }

    public TournamentsPage selectClubName(String clubName) {
        page.selectOption(clubNameDropdown, clubName);
        return this;
    }

    public TournamentsPage clickChatWithPlayers() {
        page.locator(chatWithPlayersText).click();
        return this;
    }

    public TournamentsPage clickMenuIcon() {
        page.locator(menuIcon).nth(4).click();
        return this;
    }

    public TournamentsPage clickCreateButton() {
        page.locator(createButton).click();
        return this;
    }

    public TournamentsPage clickTournaments() {
        page.locator(tournamentsText).nth(1).click();
        return this;
    }

    public TournamentsPage clickEditTournaments() {
        page.locator(editTournamentsText).click();
        return this;
    }

    public TournamentsPage clearTournamentNameField() {
        page.locator(nameInputField).clear();
        return this;
    }

    public TournamentsPage fillTournamentName(String tournamentName) {
        page.locator(nameInputField).fill(tournamentName);
        return this;
    }

    public TournamentsPage clearOrganizationNameField() {
        page.locator(organizationNameField).clear();
        return this;
    }

    public TournamentsPage fillOrganizationName(String organizationName) {
        page.locator(organizationNameField).fill(organizationName);
        return this;
    }

    public TournamentsPage TournamentDescriptionField() {
        page.locator(tournamentDescriptionField).clear();
        return this;
    }

    public TournamentsPage fillTournamentDescription(String tournamentDescription) {
        page.locator(tournamentDescriptionField).fill(tournamentDescription);
        return this;
    }

    public TournamentsPage clearSponsorField() {
        page.locator(sponsorField).clear();
        return this;
    }

    public TournamentsPage fillSponsor(String sponsor) {
        page.locator(sponsorField).fill(sponsor);
        return this;
    }

    public TournamentsPage uploadSponsorLogo() {
        Locator sponsorLogo = page.locator(sponsorLogoField);
        sponsorLogo.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public TournamentsPage clearPrizeField() {
        page.locator(prizeField).clear();
        return this;
    }

    public TournamentsPage fillPrize(String prize) {
        page.locator(prizeField).fill(prize);
        return this;
    }

    public TournamentsPage uploadTournamentImage() {
        Locator tournamentImage = page.locator(tournamentImageField);
        tournamentImage.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public TournamentsPage selectNumberOfPlayer() {
        page.locator(numberOfPlayerDropdown).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage fillMinPlayerLevelField(String minPlayerLevel) {
        page.locator(minPlayerLevelField).fill(minPlayerLevel);
        return this;
    }

    public TournamentsPage fillMaxPlayerLevelField(String maxPlayerLevel) {
        page.locator(maxPlayerLevelField).fill(maxPlayerLevel);
        return this;
    }

    public TournamentsPage selectTournamentStyleKnockouts() {
        page.locator(tournamentStyleKnockout).click();
        return this;
    }

    public TournamentsPage selectTournamentStyleRound() {
        page.locator(tournamentStyleRound).click();
        return this;
    }

    public TournamentsPage selectPlayerJoiningTypeSingle() {
        page.locator(playerJoiningTypeSingle).click();
        return this;
    }

    public TournamentsPage selectPlayerJoiningTypeDouble() {
        page.locator(playerJoiningTypeDouble).click();
        return this;
    }

    public TournamentsPage selectPlayerJoiningTypeBoth() {
        page.locator(playerJoiningTypeBoth).click();
        return this;
    }

    public TournamentsPage fillTermsAndConditionsField(String termsAndConditions) {
        page.locator(termsAndConditionsField).fill(termsAndConditions);
        return this;
    }

    public TournamentsPage fillPricePerPlayerField(String pricePerPlayer) {
        page.locator(pricePerPlayerField).fill(pricePerPlayer);
        return this;
    }

    public TournamentsPage selectGenderMixed() {
        page.locator(genderMixed).click();
        return this;
    }

    public TournamentsPage selectEventTypeCompetitive() {
        page.locator(eventTypeCompetitive).click();
        return this;
    }

    public TournamentsPage selectEventTypeFriendly() {
        page.locator(eventTypeFriendly).click();
        return this;
    }

    public TournamentsPage selectEventTypePrivate() {
        page.locator(eventTypePrivate).click();
        return this;
    }

    public TournamentsPage selectEventTypePublic() {
        page.locator(eventTypePublic).click();
        return this;
    }

    public void clickNextButton() {
        page.locator(nextButton).click();
    }

    public TournamentsPage selectStartDate() {
        page.locator(startDate).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage selectEndDate() {
        page.locator(endDate).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage selectRegistrationDeadline() {
        page.locator(registrationDeadline).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage selectAllowedCourts() {
        page.locator(allowedCourts).nth(0).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage selectAllowedDays(List<String> daysToSelect) {
        List<String> allDays = Arrays.asList(
                "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"
        );

        page.locator(allowedDays).nth(1).click(); // Open dropdown once

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

    public TournamentsPage selectStartTime() {
        page.locator(startTime).fill("12:00");
        return this;
    }

    public TournamentsPage selectEndTime() {
        page.locator(endTime).fill("23:00");
        return this;
    }

    public TournamentsPage selectMatchDuration() {
        page.locator(matchDuration).nth(2).click();
        page.keyboard().press("Enter");
        return this;
    }

    public TournamentsPage setPerMatchOne() {
        page.locator(setPerMatchOne).click();
        return this;
    }

    public TournamentsPage clickCourtAvailabilityButton() {
        page.locator(checkAvailabilityButton).click();
        return this;
    }

    public TournamentsPage selectMultipleCourts(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            page.locator(selectCourt).nth(i).click();
        }
        return this;
    }

    public TournamentsPage clickSaveAndPublishButton() {
        page.locator(saveAndPublishButton).click();
        return this;
    }

    public TournamentsPage clickAddPlayers() {
        page.locator(addPlayerText).click();
        return this;
    }

    public TournamentsPage clickAddPlayersButton() {
        page.locator(addPlayerButton).click();
        return this;
    }

    public TournamentsPage selectPlayerName() {
        page.locator(addPlayerNameDropdown).click();
        page.keyboard().press("Enter");
        return this;
    }

    public void selectPaymentMethod() {
        page.locator(addPaymentMethodDropdown).click();
    }

    public TournamentsPage clickFirstConversation() {
        page.locator(firstConversation).nth(0).click();
        return this;
    }

    public TournamentsPage fillConversationText(String conversationText) {
        page.locator(conversationTextInputField).fill(conversationText);
        return this;
    }

    public void clickYesToCancelTournament() {
        page.locator(yesButtonToCancelTournament).click();
    }

    public void clickSendIcon() {
        page.locator(sendMessageIcon).click();
    }

    public void clickOkButton() {
        page.locator(okButton).click();
    }

    public Locator tournamentCreateSuccessMessageLocator() {
        return page.locator(tournamentCreateSuccessMessage);
    }

    public Locator tournamentEditSuccessMessageLocator() {
        return page.locator(tournamentEditSuccessMessage);
    }

    public String sentMessageTextContent() {
        return page.locator(sentMessageText).last().textContent();
    }

    public Locator tournamentCancelSuccessMessageLocator() {
        return page.locator(tournamentCancelSuccessMessage);
    }
}
