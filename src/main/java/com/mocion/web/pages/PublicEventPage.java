package com.mocion.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

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
    public String dateFields = "div.absolute.right-1.top-2 svg";
    public String startTime = "input[name='start_time']";
    public String endTime = "input[name='end_time']";
    public String paymentDetailsApp = "text='App'";
    public String courtTypeIndoor = "text='Indoor'";
    public String eventStyleAmericano = "input[type='radio'][value='Americano']";
    public String eventStyleMexicano = "input[type='radio'][value='Mexicano']";
    public String playerJoiningTypeSingle = "input[type='radio'][value='Single']";
    public String saveEventButton = "button.bg-primary.text-white";
    public String eventCreateSuccessMessage = "text='Successful.'";
    public String minNumberOfPlayers = "input[name='min_number_of_players']";
    public String maxNumberOfPlayers = "input[name='max_number_of_players']";

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

    public PublicEventPage selectEventStyleMexicano() {
        page.locator(eventStyleMexicano).click();
        return this;
    }

    public PublicEventPage selectEventTypeCompetitive() {
        page.locator(eventTypeCompetitive).click();
        return this;
    }

    public PublicEventPage selectPlayerJoiningTypeSingle() {
        page.locator(playerJoiningTypeSingle).click();
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

    public void clickSaveEventButton() {
        page.locator(saveEventButton).click();
    }

    public Locator eventCreateSuccessMessageLocator() {
        return page.locator(eventCreateSuccessMessage);
    }
}
