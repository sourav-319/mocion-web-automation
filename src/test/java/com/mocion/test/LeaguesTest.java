package com.mocion.test;

import com.mocion.web.pages.LeaguesPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LeaguesTest extends BaseTest {
    public LoginPage loginPage;
    public LeaguesPage leaguesPage;
    public Random random;

    private static final String CLUB_NAME = "Farah123";
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String PRICE_PER_PLAYER = "10";
    private static final int MAX_DATE_INCREMENT = 5;
    private static final int COURTS_TO_SELECT = 2;
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    @Test(description = "Public league create should successful")
    public void verify_public_league_create_should_succeed() {
        leaguesPage = new LeaguesPage(page);
        List<String> data = generateLeagueData();

        setLocationPermissionAllowed();
        userLogin();
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
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypePublic()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        leaguesPage
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
                .clickSaveAndPublishButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Private league create should successful")
    public void verify_private_league_create_should_succeed() {
        leaguesPage = new LeaguesPage(page);
        List<String> data = generateLeagueData();

        setLocationPermissionAllowed();
        userLogin();
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
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevelField(MAX_PLAYER_LEVEL)
                .fillPricePerPlayerField(PRICE_PER_PLAYER)
                .selectGenderMixed()
                .selectEventTypePrivate()
                .selectNumberOfPlayer()
                .fillTermsAndConditionsField(data.get(5))
                .clickNextButton();
        leaguesPage
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
                .clickSaveAndPublishButton();

        assertThat(leaguesPage.leagueCreateSuccessMessageLocator()).isVisible();
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
