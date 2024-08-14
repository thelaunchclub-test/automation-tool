package com.twozo.page.product;

import com.twozo.page.BasePage;
import com.twozo.page.company.Company;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Product extends BasePage {

    private static Product product;

    public WebPageElement getColumnSettingsButton() {
        return findByXpath("//*[@class='css-181x7hd']");
    }

    protected Product(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Product getInstance(final WebAutomationDriver webAutomationDriver){

      //  if (Objects.isNull(product)) {
            product = new Product(webAutomationDriver);
        //}

        return product;
    }
    public void switchToColumnSettings() {
        click(getColumnSettingsButton());
    }
}
