package com.twozo.page.settings.data.fields.deal;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.Settings;
import com.twozo.page.url.settings.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

public class Deal extends Settings {

    private static Deal deal;

    private WebPageElement activeDealTab;

    protected Deal(final WebAutomationDriver webAutomationDriver){
        super(webAutomationDriver);

        if(getURL().equals(URL.DEAL)){
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");

        }
    }

    public static Deal getInstance(final WebAutomationDriver webAutomationDriver) {
        deal = new Deal(webAutomationDriver);

        return deal;
    }

    public WebPageElement getActiveDealTab() {
        activeDealTab = initializeElement(activeDealTab, () ->
                findByXpath("//*[@value='Deal' and @aria-pressed='true']"));

        return activeDealTab;
    }

    public boolean verifyActiveDealTab() {
        return isDisplayed(getActiveDealTab());
    }
}
