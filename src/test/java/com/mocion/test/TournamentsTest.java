package com.mocion.test;

import com.mocion.web.pages.LoginPage;
import com.mocion.web.pages.TournamentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TournamentsTest extends BaseTest {
    public LoginPage loginPage;
    public TournamentsPage tournamentsPage;
    public Random random;

    private static final String CLUB_NAME = "Farah123";
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String PRICE_PER_PLAYER = "10";
    private static final int MAX_DATE_INCREMENT = 5;
    private static final int COURTS_TO_SELECT = 2;
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

    @Test(description = "Private competitive knockout tournament create with single player should successful")
    public void verify_private_competitive_knockout_tournament_create_with_single_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive knockout tournament create with double player should successful")
    public void verify_public_competitive_knockout_tournament_create_with_double_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeDouble()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private competitive round tournament create with both player should successful")
    public void verify_private_competitive_round_tournament_create_with_both_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive round tournament create with single player should successful")
    public void verify_public_competitive_round_tournament_create_with_single_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private friendly knockout tournament create with double player should successful")
    public void verify_private_friendly_knockout_tournament_create_with_double_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeDouble()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public friendly knockout tournament create with both player should successful")
    public void verify_public_friendly_knockout_tournament_create_with_both_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private friendly round tournament create with single player should successful")
    public void verify_private_friendly_round_tournament_create_with_single_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public friendly round tournament create with double player should successful")
    public void verify_public_friendly_round_tournament_create_with_double_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private friendly round tournament create with both player should successful")
    public void verify_private_friendly_round_tournament_create_with_both_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive knockout tournament create with both player should successful")
    public void verify_public_competitive_knockout_tournament_create_with_both_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private competitive round tournament create with double player should successful")
    public void verify_private_competitive_round_tournament_create_with_double_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeDouble()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public friendly knockout tournament create with single player should successful")
    public void verify_public_friendly_knockout_tournament_create_with_single_player_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypeFriendly()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts(COURTS_TO_SELECT)
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Edit tournament with required fields should successful")
    public void verify_tournament_edit_with_required_fields_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditTournaments()
                .clearTournamentNameField()
                .fillTournamentName(data.getFirst())
                .clearTournamentDescriptionField()
                .fillTournamentDescription(data.get(4))
                .clickNextButton()
                .clickSaveAndPublishButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Edit tournament with optional fields should successful")
    public void verify_edit_tournament_with_optional_fields_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditTournaments()
                .clearOrganizationNameField()
                .fillOrganizationName(data.get(1))
                .clearSponsorField()
                .fillSponsor(data.get(2))
                .clearPrizeField()
                .fillPrize(data.get(3))
                .clickNextButton()
                .clickSaveAndPublishButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Edit tournament with all fields should successful")
    public void verify_edit_tournament_with_all_fields_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditTournaments()
                .clearTournamentNameField()
                .fillTournamentName(data.get(0))
                .clearOrganizationNameField()
                .fillOrganizationName(data.get(1))
                .clearTournamentDescriptionField()
                .fillTournamentDescription(data.get(4))
                .clearSponsorField()
                .fillSponsor(data.get(2))
                .clearPrizeField()
                .fillPrize(data.get(3))
                .clickNextButton()
                .clickSaveAndPublishButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Chat with tournament players should successful")
    public void verify_chat_with_tournament_players_should_succeed() {
        String conversationText = "Hello, this is a test message";
        tournamentsPage = new TournamentsPage(page);

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickChatWithPlayers()
                .clickFirstConversation()
                .fillConversationText(conversationText)
                .clickSendIcon();

        Assert.assertTrue(tournamentsPage.sentMessageTextContent().contains(conversationText));
    }

    @Test(description = "Tournament duplicate should successful")
    public void verify_tournament_duplicate_should_succeed() {
        tournamentsPage = new TournamentsPage(page);

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickDuplicate()
                .clickNextButton();
        tournamentsPage
                .clickCourtAvailabilityButton()
                .selectCourtsWithDateIncrement(MAX_DATE_INCREMENT)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Tournament cancel should successful")
    public void verify_tournament_cancel_should_succeed() {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickCancelTournament()
                .clickYesToCancelTournament();

        assertThat(tournamentsPage.tournamentCancelSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Add players to tournament should successful")
    public void verify_add_players_to_tournament_should_succeed() {
        tournamentsPage = new TournamentsPage(page);

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickAddPlayers()
                .clickAddPlayersButton()
                .selectPlayerName()
                .selectJoinTypeSingle()
                .selectPaymentMethod()
                .clickAddPlayerSaveButton();

        assertThat(tournamentsPage.addPlayersToTournamentSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Setting the schedule for the knockout tournament should be successful")
    public void verify_setting_the_schedule_for_the_knockout_tournament_should_succeed() {
        String scoreOne = "4";
        String scoreTwo = "2";
        String clubName = "RE2";
        tournamentsPage = new TournamentsPage(page);

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(clubName)
                .clickMenuIcon()
                .clickSchedule()
                .selectNumberOfTopSeatsTwo()
                .clickGenerateGroupsButton()
                .clickSaveAndNextButton()
                .clickSaveAndNextButton()
                .setKnockoutMatchScores(scoreOne, scoreTwo);

        assertThat(tournamentsPage.scoresUpdateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Setting the schedule for the round robin tournament should be successful")
    public void verify_setting_the_schedule_for_the_round_robin_tournament_should_succeed() {
        String scoreOne = "4";
        String scoreTwo = "2";
        String clubName = "RE2";
        tournamentsPage = new TournamentsPage(page);

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickEventsFromNavigationBar()
                .clickTournamentsFromNavigationBar()
                .selectClubName(clubName)
                .clickMenuIcon()
                .clickSchedule()
                .selectNumberOfTopSeatsTwo()
                .clickGenerateGroupsButton()
                .clickSaveAndNextButton()
                .clickNextButtonPhaseOne()
                .clickSaveAndNextButtonPhaseOne()
                .setRoundRobinPhaseOneMatchScores(scoreOne, scoreTwo)
                .clickPhaseOneGenerateResultsButton()
                .clickNextButtonPhaseOne()
                .setRoundRobinSemiFinalMatchScores(scoreOne, scoreTwo)
                .clickFinalGenerateResultsButton()
                .setRoundRobinFinalMatchScores(scoreOne, scoreTwo)
                .clickFinalGenerateResultsButton();

        assertThat(tournamentsPage.scoresUpdateSuccessMessageLocator()).isVisible();
    }

    private List<String> generateTournamentData() {
        random = new Random();
        String id = String.format("%03d", random.nextInt(999) + 1);
        return Arrays.asList(
                "test_tournament_" + id,
                "test_organization_" + id,
                "test_sponsor_" + id,
                "test_prize_" + id,
                "test_description",
                "test_terms_and_conditions"
        );
    }

    private void setLocationPermissionAllowed() {
        page.context().grantPermissions(List.of("geolocation"));
    }

    private void userLogin() {
        loginPage = new LoginPage(page);
        page.navigate(prop.getProperty("baseUrl"));
        loginPage
                .fillUserEmail(prop.getProperty("userEmail_2"))
                .fillUserPassword(prop.getProperty("userPassword_2"))
                .clickLoginBtn();
    }
}
