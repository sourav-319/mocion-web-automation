package com.mocion.web;

import com.mocion.web.pages.ClubPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ClubTest extends BaseTest {
    public LoginPage loginPage;
    public ClubPage clubPage;
    public Random random;

    @Test(description = "Club creation should successful")
    public void verify_club_creation_should_succeed() {
        String landline = "+971 111 111 111";
        String aboutClub = "test_club";
        String accountHolderName = "test_account_holder";
        String bankName = "test_bank";
        String accountNumber = "2541524785";
        String iban = "1111 1111 1111 1111";
        String swiftCode = "46654869652";

        random = new Random();
        clubPage = new ClubPage(page);
        loginPage = new LoginPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String clubName = "club_test_" + formattedNumber;

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        clubPage
                .clickOrganizationFromLeftNavigation()
                .clickCreateClubButton()
                .fillClubName(clubName)
                .fillMobileNumber(landline)
                .fillAddress()
                .fillAboutClub(aboutClub)
                .selectAmenitiesEquipmentRental()
                .uploadClubLogo()
                .uploadClubImage()
                .clickWorkingDaysDropdown()
                .selectWorkingDays()
                .selectHourFrom()
                .selectHourTo()
                .fillAccountHolderName(accountHolderName)
                .fillBankName(bankName)
                .fillAccountNumber(accountNumber)
                .fillIban(iban)
                .fillSwiftCode(swiftCode)
                .clickSaveButton();

        assertThat(clubPage.getClubCreateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Club edit should successful")
    public void verify_club_edit_should_succeed() {
        String landline = "+971 111 111 111";
        String aboutClub = "test_club";
        String accountHolderName = "test_account_holder";
        String bankName = "test_bank";
        String accountNumber = "2541524785";
        String iban = "1111 1111 1111 1111";
        String swiftCode = "46654869652";
        String policyHours = "1";
        String aheadLimitDays = "1";
        String maximumBookingsDay = "1";
        String numberOfActiveBookings = "1";

        random = new Random();
        clubPage = new ClubPage(page);
        loginPage = new LoginPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String clubName = "club_test_" + formattedNumber;

        // Grant location permission
        page.context().grantPermissions(List.of("geolocation"));

        userLogin();
        clubPage
                .clickOrganizationFromLeftNavigation()
                .clickMenuIcon()
                .clickEditClubFromMenu()
                .clearClubNameField()
                .clearAddressField()
                .clearAboutClubField()
                .clearClubImage()
                .clearClubLogo()
                .clearCancellationPolicyHoursField()
                .clearBookAheadLimitDaysField()
                .clearNumberOfActiveBookingsField()
                .clearMaximumBookingsDayField()
                .clearAccountHolderNameField()
                .clearBankNameField()
                .clearAccountNumberField()
                .clearIbanField()
                .clearSwiftCodeField()
                .editClubName(clubName)
                .fillMobileNumber(landline)
                .editAddress()
                .fillAboutClub(aboutClub)
                .uploadClubLogo()
                .uploadClubImage()
                .fillCancellationPolicyHours(policyHours)
                .fillBookAheadLimitDays(aheadLimitDays)
                .fillNumberOfActiveBookings(numberOfActiveBookings)
                .fillMaximumBookingsDayField(maximumBookingsDay)
                .editAmenitiesEquipmentRental()
                .fillAccountHolderName(accountHolderName)
                .fillBankName(bankName)
                .fillAccountNumber(accountNumber)
                .fillIban(iban)
                .fillSwiftCode(swiftCode)
                .clickClubSchedule()
                .editWorkingDaysDropdown()
                .editWorkingDays()
                .editHourFrom()
                .editHourTo()
                .clickSaveButton();

        assertThat(clubPage.clubEditSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Club duplication should successful")
    public void verify_club_duplication_should_succeed() {
        random = new Random();
        clubPage = new ClubPage(page);
        loginPage = new LoginPage(page);

        int randomNumber = random.nextInt(999) + 1;
        String formattedNumber = String.format("%03d", randomNumber);
        String clubName = "club_test_" + formattedNumber;

        userLogin();
        clubPage
                .clickOrganizationFromLeftNavigation()
                .clickMenuIcon()
                .clickDuplicateClub()
                .fillClubName(clubName)
                .selectAmenitiesEquipmentRental()
                .clickSaveButton();

        assertThat(clubPage.clubDuplicateSuccessMessageLocator()).isVisible();
    }

    @Test(description = "Club deactivation should successful")
    public void verify_club_deactivation_should_succeed() {
        clubPage = new ClubPage(page);
        loginPage = new LoginPage(page);

        userLogin();
        clubPage
                .clickOrganizationFromLeftNavigation()
                .clickMenuIcon()
                .clickToDeactivateClub()
                .clickYesToConfirmationTab();

        assertThat(clubPage.clubDeactivateSuccessMessageLocator()).isVisible();
    }

    private void userLogin() {
        loginPage = new LoginPage(page);

        page.navigate(prop.getProperty("baseUrl"));
        loginPage
                .fillUserEmail(prop.getProperty("userEmail"))
                .fillUserPassword(prop.getProperty("userPassword"))
                .clickLoginBtn();
    }
}
