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
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String PRICE_PER_PLAYER = "10";
    private static final int MAX_DATE_INCREMENT = 5;
    private static final int COURTS_TO_SELECT = 2;
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    @Test(description = "Private competitive knockout tournament create should successful")
    public void verify_private_competitive_knockout_tournament_create_should_succeed() {
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
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditionsField(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickNextButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive knockout tournament create should successful")
    public void verify_public_competitive_knockout_tournament_create_should_succeed() {
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
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleKnockouts()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditionsField(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickNextButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private competitive round robin tournament create should successful")
    public void verify_private_competitive_round_robin_tournament_create_should_succeed() {
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
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRoundRobin()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditionsField(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickNextButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive round robin tournament create should successful")
    public void verify_public_competitive_round_tournament_create_should_succeed() {
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
                .selectPaymentDetailsApp()
                .selectGenderMixed()
                .selectEventTypeCompetitive()
                .selectTournamentStyleRoundRobin()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .selectAssignOrganizer()
                .fillTermsAndConditionsField(data.get(5))
                .selectStartDate()
                .selectEndDate()
                .selectRegistrationDeadline()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectStartTime()
                .selectEndTime()
                .clickNextButton();

        assertThat(tournamentsPage.tournamentCreateSuccessMessageLocator()).isVisible();
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
