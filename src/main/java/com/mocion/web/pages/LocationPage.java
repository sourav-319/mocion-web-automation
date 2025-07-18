package com.mocion.web.pages;

import com.microsoft.playwright.Page;

import java.util.List;

public class LocationPage {
    private final Page page;

    public LocationPage(Page page) {
        this.page = page;
    }

    public void setLocationPermissionAllowed() {
        page.context().grantPermissions(List.of("geolocation"));
    }
}
