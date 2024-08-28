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

    protected Product() {
        super();
    }

    public static Product getInstance(){

      //  if (Objects.isNull(product)) {
            product = new Product();
        //}

        return product;
    }
    public void switchToColumnSettings() {
        click(getColumnSettingsButton());
    }
}
