package com.twozo.page.company;

import com.twozo.page.BasePage;
import com.twozo.page.analytics.Analytics;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Company extends BasePage {

    private static Company company;

    public WebPageElement getColumnSettingsButton() {
        return findByXpath("//*[@class='css-181x7hd']");
    }

    protected Company(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Company getInstance(final WebAutomationDriver webAutomationDriver) {

       // if (Objects.isNull(company)) {
            company = new Company(webAutomationDriver);
        //}

        return company;
    }

    public void switchToColumnSettings() {
        click(getColumnSettingsButton());
    }
}
