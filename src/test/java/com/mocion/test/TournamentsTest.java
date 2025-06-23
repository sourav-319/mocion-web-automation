package com.mocion.test;

import com.mocion.web.pages.LoginPage;
import com.mocion.web.pages.TournamentsPage;
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
    private static final String TOURNAMENT_DESCRIPTION = "test_description";
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String TERMS_AND_CONDITIONS = "test_terms_and_conditions";
    private static final String PRICE_PER_PLAYER = "10";
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday");

    @Test(description = "Private competitive knockout tournament create with single player should successful")
    public void verify_private_competitive_knockout_tournament_create_with_single_player_should_succeed() throws InterruptedException {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickBookingFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .clickTournaments()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(TOURNAMENT_DESCRIPTION)
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMale()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(TERMS_AND_CONDITIONS)
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectMultipleCourts(0, 2)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive knockout tournament create with double player should successful")
    public void verify_public_competitive_knockout_tournament_create_with_double_player_should_succeed() throws InterruptedException {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickBookingFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .clickTournaments()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(TOURNAMENT_DESCRIPTION)
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMale()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeDouble()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(TERMS_AND_CONDITIONS)
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectMultipleCourts(0, 2)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private competitive round tournament create with both player should successful")
    public void verify_private_competitive_round_tournament_create_with_both_player_should_succeed() throws InterruptedException {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickBookingFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .clickTournaments()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(TOURNAMENT_DESCRIPTION)
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMale()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeBoth()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(TERMS_AND_CONDITIONS)
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectMultipleCourts(0, 9)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive round tournament create with single player should successful")
    public void verify_public_competitive_round_tournament_create_with_single_player_should_succeed() throws InterruptedException {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickBookingFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .clickTournaments()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(TOURNAMENT_DESCRIPTION)
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMale()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRound()
                .selectPlayerJoiningTypeSingle()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(TERMS_AND_CONDITIONS)
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectMultipleCourts(0, 9)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private friendly knockout tournament create with double player should successful")
    public void verify_private_friendly_knockout_tournament_create_with_double_player_should_succeed() throws InterruptedException {
        tournamentsPage = new TournamentsPage(page);
        List<String> data = generateTournamentData();

        setLocationPermissionAllowed();
        userLogin();
        tournamentsPage
                .clickBookingFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .clickTournaments()
                .fillTournamentName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillTournamentDescription(TOURNAMENT_DESCRIPTION)
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadTournamentImage()
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMale()
                .selectEventTypeFriendly()
                .selectTournamentStyleKnockouts()
                .selectPlayerJoiningTypeDouble()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(TERMS_AND_CONDITIONS)
                .clickNextButton();
        tournamentsPage
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedCourts()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .selectMatchDuration()
                .setPerMatchOne()
                .clickCourtAvailabilityButton()
                .selectMultipleCourts(0, 3)
                .clickSaveAndPublishButton()
                .clickOkButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    private List<String> generateTournamentData() {
        random = new Random();
        String id = String.format("%03d", random.nextInt(999) + 1);
        return Arrays.asList(
                "test_tournament_" + id,
                "test_organization_" + id,
                "test_sponsor_" + id,
                "test_prize_" + id
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
