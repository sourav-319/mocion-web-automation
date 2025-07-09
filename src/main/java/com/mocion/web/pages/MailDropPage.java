package com.mocion.web.pages;

import com.microsoft.playwright.Page;

public class MailDropPage {
    private final Page page;

    public String emailBodyInputField = "input[placeholder='view-this-mailbox']";
    public String viewMailboxButton = "button[type='submit']:has-text('View Mailbox')";
    public String refundEmail = "div.message";
    public String refundEmailBody = "div.bg-white.p-4.px-8.text-stone-900";

    public MailDropPage(Page page) {
        this.page = page;
    }

    public MailDropPage fillUserEmailBody(String userEmailBody) {
        page.locator(emailBodyInputField).nth(0).fill(userEmailBody);
        return this;
    }

    public MailDropPage clickViewMailboxButton() {
        page.locator(viewMailboxButton).nth(0).click();
        return this;
    }

    public void clickRefundEmail() {
        page.locator(refundEmail).nth(1).click();
    }

    public String getEmailBody() {
        return page.locator(refundEmailBody).textContent();
    }
}
