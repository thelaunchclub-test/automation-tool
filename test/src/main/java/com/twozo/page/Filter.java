package com.twozo.page;

import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.List;
import java.util.Objects;

public class Filter extends BasePage {
    private static Filter filter;
    private WebPageElement selectColumn;
    private WebPageElement selectField;

    protected Filter(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Filter getInstance(final WebAutomationDriver webAutomationDriver) {
        if (Objects.isNull(filter)) {
            filter = new Filter(webAutomationDriver);
        }
        return filter;
    }

    public WebPageElement getSelectColumn() {
        if (Objects.isNull(selectColumn)) {
            selectColumn = findBelowElement(List.of(
                    new Finder(LocatorType.XPATH, "//input[@placeholder='Select Column...']", false),
                    new Finder(LocatorType.TAG_NAME, "input", true)));
        }
        return selectColumn;
    }

    public WebPageElement getSelectField() {
        if (Objects.isNull(selectField)) {
            selectField = findBelowElement(List.of(
                    new Finder(LocatorType.XPATH, "//p[text()='Select Field']", false),
                    new Finder(LocatorType.TAG_NAME, "p", true)));
        }
        return selectField;
    }

    public void filter() {
        click(getSelectColumn());
        select("contact");
        click(getSelectField());
        select("Phones");
        click(findBelowElement(List.of(
                new Finder(LocatorType.XPATH, "//p[text()='is']", false),
                new Finder(LocatorType.TAG_NAME, "p", true))));
        select("starts with");
        send(findBelowElement(List.of(
                new Finder(LocatorType.XPATH, "//input[@placeholder='Enter Here']", false),
                new Finder(LocatorType.TAG_NAME, "input", true))), "9876");
        click(findBelowElement(List.of(
                new Finder(LocatorType.XPATH, "//button[text()='Apply']", false),
                new Finder(LocatorType.TAG_NAME, "button", true))));
    }
}
