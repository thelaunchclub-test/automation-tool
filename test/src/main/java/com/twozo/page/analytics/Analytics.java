package com.twozo.page.analytics;

import com.twozo.page.BasePage;
import com.twozo.page.activity.Activity;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class Analytics extends BasePage {

    private static Analytics analytics;

    protected Analytics(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Analytics getInstance(final WebAutomationDriver webAutomationDriver) {

        //if (Objects.isNull(analytics)) {
            analytics = new Analytics(webAutomationDriver);
       // }

        return analytics;
    }
}
