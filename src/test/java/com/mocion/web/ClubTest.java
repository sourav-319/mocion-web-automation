package com.mocion.web;

import com.mocion.web.pages.ClubPage;
import com.mocion.web.pages.LoginPage;
import org.testng.annotations.Test;

public class ClubTest extends BaseTest {
    public LoginPage loginPage;
    public ClubPage clubPage;

    @Test(description = "Valid club creation should successful")
    public void verify_club_creation_should_succeed() {
        String clubName = "club_test_001";
        String landline = "97111111111";
        String address = "Sonapur - Dubai - 7C69+CQQ - محيصنة - محيصنة ٢ - دبي - United Arab Emirates";
        String aboutClub = "test_club";
        String accountHolderName = "test_account_holder";
        String bankName = "test_bank";
        String accountNumber = "2541524785";
        String iban = "1111 1111 1111 1111";
        String swiftCode = "46654869652";

        clubPage = new ClubPage(page);
        loginPage = new LoginPage(page);

        userLogin();
        clubPage
                .clickOrganizationFromLeftNavigation()
                .clickCreateClubButton()
                .fillClubName(clubName)
                .fillLandline(landline)
                .fillMobileNumber(landline)
                .fillAddress(address)
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
