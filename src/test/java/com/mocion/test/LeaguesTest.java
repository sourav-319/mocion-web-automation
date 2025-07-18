package com.mocion.test;

import com.mocion.web.pages.LeaguesPage;
import com.mocion.web.pages.LocationPage;
import com.mocion.web.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LeaguesTest extends BaseTest {
    public LoginPage loginPage;
    public LeaguesPage leaguesPage;
    public Random random;
    public LocationPage locationPage;

    private static final String CLUB_NAME = "Farah123";
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String PRICE_PER_PLAYER = "10";
    private static final int MAX_NUMBER_OF_DATE_INCREMENT = 5;
    private static final int NUMBER_OF_COURTS_TO_SELECT = 2;
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    private static final List<String> EDIT_ALLOWED_DAYS = Arrays.asList("Saturday", "Sunday");

    public void initPages() {
        loginPage = new LoginPage(page);
        leaguesPage = new LeaguesPage(page);
        locationPage = new LocationPage(page);
        random = new Random();
    }

    @Test(description = "Public league create should successful")
    public void verify_public_league_create_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillLeagueName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillLeagueDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadLeagueImage()
                .fillMinPlayerLevel(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private league create should successful")
    public void verify_private_league_create_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillLeagueName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillLeagueDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadLeagueImage()
                .fillMinPlayerLevel(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Add players to league should successful")
    public void verify_add_players_to_league_should_succeed() {
        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickAddPlayers()
                .clickAddPlayersButton()
                .selectPlayerName()
                .selectJoinTypeSingle()
                .selectPaymentMethodInApp()
                .clickAddPlayerSaveButton();

        assertThat(leaguesPage.addPlayersToLeagueSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Schedule courts for league should successful")
    public void verify_schedule_courts_for_league_should_succeed() {
        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickScheduleCourts()
                .selectAllowedCourts(NUMBER_OF_COURTS_TO_SELECT)
                .selectMatchDuration()
                .setPerMatchOne()
                .selectCourtsWithDateIncrement(MAX_NUMBER_OF_DATE_INCREMENT)
                .clickSaveAndPublishButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Chat with league players should successful")
    public void verify_chat_with_league_players_should_succeed() {
        String conversationText = "Hello, this is a test message";

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickChatWithPlayers()
                .clickFirstConversation()
                .fillConversationText(conversationText)
                .clickSendIcon();

        Assert.assertTrue(leaguesPage.sentMessageTextContent().contains(conversationText));
    }

    @Test(description = "Edit league with required fields should successful")
    public void verify_edit_league_with_required_fields_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditLeagues()
                .clearLeagueNameField()
                .fillLeagueName(data.get(0))
                .clearLeagueDescriptionField()
                .fillLeagueDescription(data.get(4))
                .clearMinPlayerLevelField()
                .fillMinPlayerLevel(MIN_PLAYER_LEVEL)
                .clearMaxPlayerLevelField()
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .clearPricePerPlayerField()
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .editPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .editAssignOrganizer()
                .clearTermsAndConditionsField()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(EDIT_ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Edit league with optional fields should successful")
    public void verify_edit_league_with_optional_fields_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditLeagues()
                .clearOrganizationNameField()
                .fillOrganizationName(data.get(1))
                .clearSponsorField()
                .fillSponsor(data.get(2))
                .clearPrizeField()
                .fillPrize(data.get(3))
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Edit league with all fields should successful")
    public void verify_edit_league_with_all_fields_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickEditLeagues()
                .clearLeagueNameField()
                .fillLeagueName(data.get(0))
                .clearOrganizationNameField()
                .fillOrganizationName(data.get(1))
                .clearLeagueDescriptionField()
                .fillLeagueDescription(data.get(4))
                .clearSponsorField()
                .fillSponsor(data.get(2))
                .clearPrizeField()
                .fillPrize(data.get(3))
                .clearMinPlayerLevelField()
                .fillMinPlayerLevel(MIN_PLAYER_LEVEL)
                .clearMaxPlayerLevelField()
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .clearPricePerPlayerField()
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .editPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .editAssignOrganizer()
                .clearTermsAndConditionsField()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(EDIT_ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Duplicate League should successful")
    public void verify_duplicate_league_should_succeed() {
        List<String> data = generateLeagueData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickDuplicate()
                .clearLeagueNameField()
                .fillLeagueName(data.getFirst())
                .clickSaveLeagueButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Cancel league should successful")
    public void verify_cancel_league_should_succeed() {
        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        leaguesPage
                .clickEventsFromNavigationBar()
                .clickLeaguesFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickCancelLeague()
                .clickYesToCancelLeague();

        assertThat(leaguesPage.cancelLeagueSuccessMessageLocator()).isVisible();
    }

    private List<String> generateLeagueData() {
        random = new Random();
        String id = String.format("%03d", random.nextInt(999) + 1);
        return Arrays.asList(
                "test_league_" + id,
                "test_organization_" + id,
                "test_sponsor_" + id,
                "test_prize_" + id,
                "test_description",
                "test_terms_and_conditions"
        );
    }
}
