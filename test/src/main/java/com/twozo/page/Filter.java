package com.twozo.page;

import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Filter extends BasePage {
    private static Filter filter;
    private WebPageElement selectColumn;
    private WebPageElement selectField;

    protected Filter() {
        super();
    }

    public static Filter getInstance() {

        //  if (Objects.isNull(filter)) {
        filter = new Filter();
        //}

        return filter;
    }

    public WebPageElement getSelectColumn() {

        if (Objects.isNull(selectColumn)) {
            selectColumn = findByXpath("//input[@placeholder='Select Column...']");
        }

        return selectColumn;
    }

    public WebPageElement getSelectField() {

        if (Objects.isNull(selectField)) {
            selectField = findByXpath("//p[text()='Select Field']");
        }

        return selectField;
    }

    public void filter() {
        click(getSelectColumn());
        dropdown("contact");
        click(getSelectField());
        dropdown("Phones");

    }
}
