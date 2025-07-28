package com.mocion.test;

import com.mocion.web.pages.LocationPage;
import com.mocion.web.pages.LoginPage;
import com.mocion.web.pages.PublicEventPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PublicEventTest extends BaseTest {
    public LoginPage loginPage;
    public PublicEventPage publicEventPage;
    public Random random;
    public LocationPage locationPage;

    private static final String CLUB_NAME = "Farah123";
    private static final String MIN_PLAYER_LEVEL = "0";
    private static final String MAX_PLAYER_LEVEL = "5";
    private static final String MIN_NUMBER_OF_PLAYERS = "8";
    private static final String MAX_NUMBER_OF_PLAYERS = "10";
    private static final String PRICE_PER_PLAYER = "10";

    public void initPages() {
        random = new Random();
        loginPage = new LoginPage(page);
        publicEventPage = new PublicEventPage(page);
        locationPage = new LocationPage(page);
    }

    @Test(description = "Public competitive americano event create with joining type single should successful")
    public void verify_public_competitive_americano_event_create_with_joining_type_single_should_succeed() {
        List<String> data = generateEventData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        publicEventPage
                .clickEventsFromNavigationBar()
                .clickPublicEventFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillEventName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillEventDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadEventImage()
                .fillMinNumberOfPlayers(MIN_NUMBER_OF_PLAYERS)
                .fillMaxNumberOfPlayers(MAX_NUMBER_OF_PLAYERS)
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .selectPaymentDetailsApp()
                .selectEventStyleAmericano()
                .selectEventTypeCompetitive()
                .selectPlayerJoiningTypeSingle()
                .selectGenderMixed()
                .selectAssignOrganizer()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectRegistrationDeadline()
                .selectCourtTypeIndoor()
                .selectStartTime()
                .selectEndTime()
                .clickSaveEventButton();

        assertThat(publicEventPage.eventCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Public competitive mexicano event create with joining type single should successful")
    public void verify_public_competitive_mexicano_event_create_with_joining_type_single_should_succeed() {
        List<String> data = generateEventData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        publicEventPage
                .clickEventsFromNavigationBar()
                .clickPublicEventFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillEventName(data.get(0))
                .fillOrganizationName(data.get(1))
                .fillEventDescription(data.get(4))
                .fillSponsor(data.get(2))
                .uploadSponsorLogo()
                .fillPrize(data.get(3))
                .uploadEventImage()
                .fillMinNumberOfPlayers(MIN_NUMBER_OF_PLAYERS)
                .fillMaxNumberOfPlayers(MAX_NUMBER_OF_PLAYERS)
                .fillMinPlayerLevelField(MIN_PLAYER_LEVEL)
                .fillMaxPlayerLevel(MAX_PLAYER_LEVEL)
                .fillPricePerPlayer(PRICE_PER_PLAYER)
                .selectPaymentDetailsApp()
                .selectEventStyleMexicano()
                .selectEventTypeCompetitive()
                .selectPlayerJoiningTypeSingle()
                .selectGenderMixed()
                .selectAssignOrganizer()
                .fillTermsAndConditions(data.get(5))
                .selectStartDate()
                .selectRegistrationDeadline()
                .selectCourtTypeIndoor()
                .selectStartTime()
                .selectEndTime()
                .clickSaveEventButton();

        assertThat(publicEventPage.eventCreateSuccessMessageLocator()).isVisible();
    }

    private List<String> generateEventData() {
        random = new Random();
        String id = String.format("%03d", random.nextInt(999) + 1);
        return Arrays.asList(
                "test_event_" + id,
                "test_organization_" + id,
                "test_sponsor_" + id,
                "test_prize_" + id,
                "test_description",
                "test_terms_and_conditions"
        );
    }
}
