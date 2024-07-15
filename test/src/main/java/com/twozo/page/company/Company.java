package com.twozo.page.company;

import com.twozo.page.BasePage;
import com.twozo.page.analytics.Analytics;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class Company extends BasePage {

    private static Company company;

    protected Company(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Company getInstance(final WebAutomationDriver webAutomationDriver) {

       // if (Objects.isNull(company)) {
            company = new Company(webAutomationDriver);
        //}

        return company;
    }
}
