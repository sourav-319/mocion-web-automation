package com.mocion.test;

import com.mocion.web.pages.MailDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefundTest extends BaseTest {
    public MailDropPage maildropPage;

    public void initPages() {
        maildropPage = new MailDropPage(page);
    }

    @Test(description = "Refund email validation should successful")
    public void refund_email_validation_should_succeed() {
        String userEmailBody = "arifultester";
        String actualRefundBody = "Refund confirmation";

        initPages();
        page.navigate(prop.getProperty("mailDropUrl"));
        maildropPage
                .fillUserEmailBody(userEmailBody)
                .clickViewMailboxButton()
                .clickRefundEmail();

        Assert.assertTrue(maildropPage.getEmailBody().contains(actualRefundBody));
    }
}
