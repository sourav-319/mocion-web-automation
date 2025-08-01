package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.List;

public class PublicEventPage {
    private final Page page;

    public String eventsText = "text='Events'";
    public String clubNameDropdown = "select[title='Club name here']";
    public String createButton = "role=button[name='Create']";
    public String publicEventText = "text='Public event'";
    public String nameInputField = "input[name='name']";
    public String organizationNameField = "input[name='organizer_name']";
    public String eventDescriptionField = "input[name='description']";
    public String sponsorField = "input[name='sponsor_ids.0.name']";
    public String sponsorLogoField = "label[for='clubLogo']";
    public String prizeField = "input[name='prize_ids.0.name']";
    public String eventImageField = "input#trn_image_upload";
    public String eventCreateDropdowns = ".react-select__dropdown-indicator";
    public String minPlayerLevelField = "input[name='min_players_level']";
    public String maxPlayerLevelField = "input[name='max_players_level']";
    public String termsAndConditionsField = "input[name='terms_and_conditions']";
    public String pricePerPlayerField = "input[name='price_per_player']";
    public String genderMixed = "input[type='radio'][value='Mixed']";
    public String eventTypeCompetitive = "input[type='radio'][value='competitive']";
    public String eventTypeFriendly = "input[type='radio'][value='friendly']";
    public String dateFields = "div.absolute.right-1.top-2 svg";
    public String startTime = "input[name='start_time']";
    public String endTime = "input[name='end_time']";
    public String paymentDetailsApp = "text='App'";
    public String paymentDetailsClub = "text='Club'";
    public String courtTypeIndoor = "text='Indoor'";
    public String courtTypeRoffed = "text='Roffed'";
    public String courtTypeOutdoor = "text='Outdoor'";
    public String eventStyleAmericano = "input[type='radio'][value='Americano']";
    public String eventStyleKingOfTheCourts = "input[type='radio'][value='King of the Courts']";
    public String eventStyleMexicano = "input[type='radio'][value='Mexicano']";
    public String playerJoiningTypeSingle = "input[type='radio'][value='Single']";
    public String playerJoiningTypeBoth = "input[type='radio'][value='Both']";
    public String saveEventButton = "button.bg-primary.text-white";
    public String eventCreateSuccessMessage = "text='Successful.'";
    public String minNumberOfPlayers = "input[name='min_number_of_players']";
    public String maxNumberOfPlayers = "input[name='max_number_of_players']";
    public String menuIcon = "button[class*='flex']:has(svg)";
    public String addPlayerText = "text='Add Players'";
    public String addPlayerButton = "text='Add player'";
    public String addPlayerDropdown = "div[class*='dropdown-indicator']";
    public String joinTypeSingle = "input[type='radio'][value='Single']";
    public String paymentMethodDropdown = "div.react-select.w-full__dropdown-indicator";
    public String paymentMethodCash = "text='Cash'";
    public String addPlayerSaveButton = "button[type='submit']";
    public String addPlayersToEventSuccessMessageLocator = "text='Players were added successfully as League Players'";
    public String paymentMethodCreditDebitCard = "text='Credit/Debit card'";
    public String paymentMethodInApp = "text='In app'";
    public String paymentMethodPaymentLink = "text='Payment Link'";
    public String paymentMethodBankTransfer = "text='Bank transfer'";
    public String joinTypeDouble = "input[type='radio'][value='Double']";
    public String downSizeEventText = "label:has(img):has-text('Down size event')";
    public String yesToDownSizeEventText = "button.bg-primary.text-white.rounded-full";
    public String eventDownSizeSuccessMessage = "text='was edited successfully'";
    public String scheduleCourtsText = "li.flex.cursor-pointer:has-text('Schedule courts')";
    public String scheduleCourtsDropdowns = "div.react-select__dropdown-indicator";
    public String pauseTime = "text='20 Min'";
    public String maximumDurationOfRound = "text='150 Min'";
    public String numberOfServesField = "input[name='number_of_serves']";
    public String checkAvailabilityButton = "//button[text()='Check court availibility']";
    public String saveAndPublishButton = "text='Save and publish'";
    public String scheduleCourtsSuccessMessage = "text='Successful.'";
    public String courtsTable = "div.customer-table tbody > tr";
    public String totalNumberOfRounds = "input[readonly][disabled][type='number']";
    public String shareWithPlayersText = "text='Share with players'";
    public String mocionIcon = "img.cursor-pointer[src*='logoIcon']";
    public String playerNameDropdownTOShare = "div.__dropdown-indicator";
    public String okButtonToShare = "button.border-primary";
    public String firstConversation = ".w-full.flex.px-8";
    public String sendMessageIcon = ".lucide.lucide-send";
    public String sentMessageText = ".flex.flex-col.gap-2.py-2.pr-2";

    public PublicEventPage(Page page) {
        this.page = page;
    }

    public PublicEventPage clickEventsFromNavigationBar() {
        page.locator(eventsText).click();
        return this;
    }

    public PublicEventPage clickPublicEventFromNavigationBar() {
        page.locator(publicEventText).click();
        return this;
    }

    public PublicEventPage selectClubName(String clubName) {
        page.selectOption(clubNameDropdown, clubName);
        return this;
    }

    public PublicEventPage clickMenuIcon() {
        page.locator(menuIcon).nth(4).click();
        return this;
    }

    public PublicEventPage clickShareWithPlayers() {
        page.locator(shareWithPlayersText).click();
        return this;
    }

    public PublicEventPage clickMocionIcon() {
        page.locator(mocionIcon).click();
        return this;
    }

    public PublicEventPage selectPlayerNameToShare() {
        page.locator(playerNameDropdownTOShare).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage clickOkButtonToShare() {
        page.locator(okButtonToShare).click();
        return this;
    }

    public PublicEventPage clickFirstConversation() {
        page.locator(firstConversation).nth(0).click();
        return this;
    }

    public PublicEventPage clickScheduleCourts() {
        page.locator(scheduleCourtsText).click();
        return this;
    }

    public PublicEventPage selectPauseTime() {
        page.locator(scheduleCourtsDropdowns).nth(0).click();
        page.locator(pauseTime).click();
        return this;
    }

    public PublicEventPage selectMaximumDurationOfRound() {
        page.locator(scheduleCourtsDropdowns).nth(1).click();
        page.locator(maximumDurationOfRound).click();
        return this;
    }

    public PublicEventPage fillNumberOfServes(String numberOfServes) {
        page.locator(numberOfServesField).fill(numberOfServes);
        return this;
    }

    public PublicEventPage clickCheckAvailabilityButton() {
        page.locator(checkAvailabilityButton).click();
        return this;
    }

    public PublicEventPage clickDownSizeEvent() {
        page.locator(downSizeEventText).click();
        return this;
    }

    public PublicEventPage clickAddPlayers() {
        page.locator(addPlayerText).click();
        return this;
    }

    public PublicEventPage clickAddPlayersButton() {
        page.locator(addPlayerButton).click();
        return this;
    }

    public PublicEventPage selectPlayerNameToAdd() {
        page.locator(addPlayerDropdown).nth(0).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage selectJoinTypeDouble() {
        page.locator(joinTypeDouble).click();
        return this;
    }

    public PublicEventPage selectTeammateNameToAdd() {
        page.locator(addPlayerDropdown).nth(1).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage selectJoinTypeSingle() {
        page.locator(joinTypeSingle).click();
        return this;
    }

    public PublicEventPage selectPaymentMethodBankTransfer() {
        page.locator(paymentMethodDropdown).click();
        page.locator(paymentMethodBankTransfer).click();
        return this;
    }

    public PublicEventPage selectPaymentMethodPaymentLink() {
        page.locator(paymentMethodDropdown).click();
        page.locator(paymentMethodPaymentLink).click();
        return this;
    }

    public PublicEventPage selectPaymentMethodInApp() {
        page.locator(paymentMethodDropdown).click();
        page.locator(paymentMethodInApp).click();
        return this;
    }

    public PublicEventPage selectPaymentMethodCreditDebitCard() {
        page.locator(paymentMethodDropdown).click();
        page.locator(paymentMethodCreditDebitCard).click();
        return this;
    }

    public PublicEventPage selectPaymentMethodCash() {
        page.locator(paymentMethodDropdown).click();
        page.locator(paymentMethodCash).click();
        return this;
    }

    public PublicEventPage clickCreateButton() {
        page.locator(createButton).click();
        return this;
    }

    public PublicEventPage fillEventName(String eventName) {
        page.locator(nameInputField).fill(eventName);
        return this;
    }

    public PublicEventPage fillOrganizationName(String organizationName) {
        page.locator(organizationNameField).fill(organizationName);
        return this;
    }

    public PublicEventPage fillEventDescription(String eventDescription) {
        page.locator(eventDescriptionField).fill(eventDescription);
        return this;
    }

    public PublicEventPage fillSponsor(String sponsor) {
        page.locator(sponsorField).fill(sponsor);
        return this;
    }

    public PublicEventPage uploadSponsorLogo() {
        Locator sponsorLogo = page.locator(sponsorLogoField);
        sponsorLogo.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public PublicEventPage fillPrize(String prize) {
        page.locator(prizeField).fill(prize);
        return this;
    }

    public PublicEventPage uploadEventImage() {
        Locator eventImage = page.locator(eventImageField);
        eventImage.setInputFiles(Paths.get("src/main/resources/club_image.png"));
        return this;
    }

    public PublicEventPage fillMinNumberOfPlayers(String minPlayerLevel) {
        page.locator(minNumberOfPlayers).fill(minPlayerLevel);
        return this;
    }

    public PublicEventPage fillMaxNumberOfPlayers(String minPlayerLevel) {
        page.locator(maxNumberOfPlayers).fill(minPlayerLevel);
        return this;
    }

    public PublicEventPage fillMinPlayerLevelField(String minPlayerLevel) {
        page.locator(minPlayerLevelField).fill(minPlayerLevel);
        return this;
    }

    public PublicEventPage fillMaxPlayerLevel(String maxPlayerLevel) {
        page.locator(maxPlayerLevelField).fill(maxPlayerLevel);
        return this;
    }

    public PublicEventPage fillPricePerPlayer(String pricePerPlayer) {
        page.locator(pricePerPlayerField).fill(pricePerPlayer);
        return this;
    }

    public PublicEventPage selectPaymentDetailsApp() {
        page.locator(eventCreateDropdowns).nth(0).click();
        page.locator(paymentDetailsApp).click();
        return this;
    }

    public PublicEventPage selectPaymentDetailsClub() {
        page.locator(eventCreateDropdowns).nth(0).click();
        page.locator(paymentDetailsClub).click();
        return this;
    }

    public PublicEventPage selectGenderMixed() {
        page.locator(genderMixed).click();
        return this;
    }

    public PublicEventPage selectAssignOrganizer() {
        page.locator(eventCreateDropdowns).nth(1).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage fillTermsAndConditions(String termsAndConditions) {
        page.locator(termsAndConditionsField).fill(termsAndConditions);
        return this;
    }

    public PublicEventPage selectStartDate() {
        page.locator(dateFields).nth(0).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage selectRegistrationDeadline() {
        page.locator(dateFields).nth(1).click();
        page.keyboard().press("Enter");
        return this;
    }

    public PublicEventPage selectEventStyleAmericano() {
        page.locator(eventStyleAmericano).click();
        return this;
    }

    public PublicEventPage selectEventStyleKingOfTheCourts() {
        page.locator(eventStyleKingOfTheCourts).click();
        return this;
    }

    public PublicEventPage selectEventStyleMexicano() {
        page.locator(eventStyleMexicano).click();
        return this;
    }

    public PublicEventPage selectEventTypeCompetitive() {
        page.locator(eventTypeCompetitive).click();
        return this;
    }

    public PublicEventPage selectEventTypeFriendly() {
        page.locator(eventTypeFriendly).click();
        return this;
    }

    public PublicEventPage selectPlayerJoiningTypeSingle() {
        page.locator(playerJoiningTypeSingle).click();
        return this;
    }

    public PublicEventPage selectPlayerJoiningTypeBoth() {
        page.locator(playerJoiningTypeBoth).click();
        return this;
    }

    public PublicEventPage selectStartTime() {
        page.locator(startTime).fill("06:00");
        return this;
    }

    public PublicEventPage selectEndTime() {
        page.locator(endTime).fill("23:00");
        return this;
    }

    public PublicEventPage selectCourtTypeIndoor() {
        page.locator(eventCreateDropdowns).nth(2).click();
        page.locator(courtTypeIndoor).nth(1).click();
        return this;
    }

    public PublicEventPage selectCourtTypeOutdoor() {
        page.locator(eventCreateDropdowns).nth(2).click();
        page.locator(courtTypeOutdoor).click();
        return this;
    }

    public PublicEventPage selectCourtTypeRoffed() {
        page.locator(eventCreateDropdowns).nth(2).click();
        page.locator(courtTypeRoffed).click();
        return this;
    }

    public PublicEventPage selectAvailableCourts() {
        int totalRounds = Integer.parseInt(page.locator(totalNumberOfRounds).nth(1).getAttribute("value").trim());
        Locator rows = page.locator(courtsTable);
        int rowCount = rows.count();
        int cumulativeCount = 0;

        for (int i = 0; i < rowCount; i++) {
            Locator row = rows.nth(i);
            int required = Integer.parseInt(row.locator("td").nth(3).locator("strong").innerText().trim());

            List<Locator> courts = row.locator("td").nth(2).locator("span").all();
            long availableCount = courts.stream()
                    .filter(court -> court.getAttribute("class").contains("bg-[#f3f3f3]") && court.isEnabled())
                    .count();

            if (availableCount < required) {
                throw new RuntimeException("Not enough available courts found at row " + (i + 1));
            }

            cumulativeCount += required;
        }

        if (cumulativeCount < totalRounds) {
            throw new RuntimeException("Not enough available courts found in total");
        }

        for (int i = 0; i < rowCount; i++) {
            Locator row = rows.nth(i);
            int required = Integer.parseInt(row.locator("td").nth(3).locator("strong").innerText().trim());

            List<Locator> courts = row.locator("td").nth(2).locator("span").all();
            List<Locator> available = courts.stream()
                    .filter(court -> court.getAttribute("class").contains("bg-[#f3f3f3]") && court.isEnabled())
                    .toList();

            for (int j = 0; j < required; j++) {
                available.get(j).scrollIntoViewIfNeeded();
                available.get(j).click();
            }
        }
        return this;
    }

    public void clickYestToDownSizeEvent() {
        page.locator(yesToDownSizeEventText).click();
    }

    public void clickSendIcon() {
        page.locator(sendMessageIcon).click();
    }

    public void clickSaveAndPublishButton() {
        page.locator(saveAndPublishButton).click();
    }

    public void clickAddPlayerSaveButton() {
        page.locator(addPlayerSaveButton).click();
    }

    public void clickSaveEventButton() {
        page.locator(saveEventButton).click();
    }

    public String sentMessageTextContent() {
        return page.locator(sentMessageText).last().textContent();
    }

    public Locator eventCreateSuccessMessageLocator() {
        return page.locator(eventCreateSuccessMessage);
    }

    public Locator addPlayersToEventSuccessMessageLocator() {
        return page.locator(addPlayersToEventSuccessMessageLocator);
    }

    public Locator eventDownSizeSuccessMessageLocator() {
        return page.locator(eventDownSizeSuccessMessage);
    }

    public Locator scheduleCourtsSuccessMessageLocator() {
        return page.locator(scheduleCourtsSuccessMessage);
    }
}
