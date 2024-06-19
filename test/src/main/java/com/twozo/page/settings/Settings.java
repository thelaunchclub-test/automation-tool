package com.twozo.page.settings;

import com.twozo.page.BasePage;
import com.twozo.page.company.Company;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class Settings extends BasePage {

    private static Settings settings;

    protected Settings(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Settings getInstance(final WebAutomationDriver webAutomationDriver){

        if (Objects.isNull(settings)) {
            settings = new Settings(webAutomationDriver);
        }

        return settings;
    }
}
