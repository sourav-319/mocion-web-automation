package com.mocion.test;

import com.mocion.web.pages.AcademyPage;
import com.mocion.web.pages.LocationPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AcademyTest extends BaseTest {
    public LoginPage loginPage;
    public Random random;
    public LocationPage locationPage;
    public AcademyPage academyPage;

    private static final String CLUB_NAME = "Farah123";
    private static final String REGISTRATION_PRICE_PER_PLAYER = "10";
    private static final String max_number_OF_PLAYERS = "10";
    private static final List<String> ALLOWED_DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    public void initPages() {
        random = new Random();
        loginPage = new LoginPage(page);
        academyPage = new AcademyPage(page);
        locationPage = new LocationPage(page);
    }

    @Test(description = "Public indoor academy create with booking in app should successful")
    public void verify_public_indoor_academy_create_with_booking_in_app_should_succeed() throws InterruptedException {
        List<String> data = generateAcademyData();

        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        academyPage
                .clickCoachingFromNavigationBar()
                .clickAcademyEventFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickCreateButton()
                .fillAcademyName(data.getFirst())
                .selectCourtTypeIndoor()
                .selectCourtPrivacyPublic()
                .selectCoach()
                .fillRegistrationPricePerPlayer(REGISTRATION_PRICE_PER_PLAYER)
                .fillMaximumNumberOfPlayers(max_number_OF_PLAYERS)
                .selectGenderBoth()
                .selectBookingInAppOn()
                .selectStartDate()
                .selectEndDate()
                .selectAllowedDays(ALLOWED_DAYS)
                .selectEndTime()
                .selectStartTime()
                .clickCheckAvailableButton()
                .selectAvailableCourt()
                .clickSaveAndPublishButton();

        assertThat(academyPage.academyCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Add players to academy with payment in app should successful")
    public void verify_add_player_to_academy_with_payment_in_app_should_succeed() {
        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        academyPage
                .clickCoachingFromNavigationBar()
                .clickAcademyEventFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickAddPlayers()
                .selectPlayerNameToAdd()
                .selectPaymentMethodInApp()
                .clickSaveButton();

        assertThat(academyPage.addPlayerToAcademySuccessMessageLocator()).isVisible();
    }

    @Test(description = "Cancel booking to academy should successful")
    public void verify_cancel_booking_to_academy_should_succeed() {
        initPages();
        locationPage.setLocationPermissionAllowed();
        loginPage.userLogin();
        academyPage
                .clickCoachingFromNavigationBar()
                .clickAcademyEventFromNavigationBar()
                .selectClubName(CLUB_NAME)
                .clickMenuIcon()
                .clickCancelBooking()
                .clickYesToCancelBooking();

        assertThat(academyPage.cancelBookingSuccessMessageLocator()).isVisible();
    }

    private List<String> generateAcademyData() {
        random = new Random();
        String id = String.format("%03d", random.nextInt(999) + 1);
        return Arrays.asList(
                "test_academy_" + id,
                "test_organization_" + id,
                "test_sponsor_" + id,
                "test_prize_" + id,
                "test_description",
                "test_terms_and_conditions"
        );
    }
}
