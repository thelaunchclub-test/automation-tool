package com.twozo.page.settings.data.fields.product;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.Settings;
import com.twozo.page.url.settings.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

public class Product extends Settings {

    private static Product product;

    private WebPageElement activeProductTab;

    protected Product(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (getURL().equals(URL.PRODUCT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static Product getInstance(final WebAutomationDriver webAutomationDriver) {
        product = new Product(webAutomationDriver);

        return product;
    }

    public WebPageElement getActiveProductTab() {
        activeProductTab = initializeElement(activeProductTab, () ->
                findByXpath("//*[@value='Company' and @aria-pressed='true']"));

        return activeProductTab;
    }

    public boolean verifyActiveProductTab() {
        return isDisplayed(getActiveProductTab());
    }

}
