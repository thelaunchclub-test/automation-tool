package com.twozo.page;

import com.twozo.web.driver.service.PageInformationProvider;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.driver.service.WebNavigator;

import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.WebPageElement;

import java.util.Collection;
import java.util.List;

public class BasePage {

    protected WebAutomationDriver webAutomationDriver;
    protected ElementFinder elementFinder;
    protected WebNavigator webNavigator;
    protected PageInformationProvider pageInformationProvider;

    protected BasePage(final WebAutomationDriver webAutomationDriver) {
        this.webAutomationDriver = webAutomationDriver;
        this.elementFinder = webAutomationDriver.getElementFinder();
        this.webNavigator = webAutomationDriver.getWebNavigator();
        this.pageInformationProvider = webAutomationDriver.getPageInformationProvider();
    }

    protected final WebPageElement findElement(final Finder finder) {
        return elementFinder.getWebPageElement(finder);
    }

    protected final Collection<WebPageElement> findElements(final Finder finder) {
        return elementFinder.getWebPageElements(finder);
    }

    protected final WebPageElement findAboveElement(final Collection<Finder> finders) {
        return elementFinder.findAboveElement(finders);
    }

    protected final WebPageElement findBelowElement(final Collection<Finder> finders) {
        return elementFinder.findBelowElement(finders);
    }

    protected final WebPageElement findNearElement(final Collection<Finder> finders) {
        return elementFinder.findNearElement(finders);
    }

    protected final WebPageElement findLeftElement(final Collection<Finder> finders) {
        return elementFinder.findLeftElement(finders);
    }

    protected final WebPageElement findRightElement(final Collection<Finder> finders) {
        return elementFinder.findRightElement(finders);
    }

    protected final void send(final WebPageElement webPageElement, final String value) {
        webPageElement.interact().sendKeys(value);
    }

    protected final void selectDate(final Finder finder, final Month month, final int date, final int year) {
        final String xpath = "//button[text()='%d']";

        click(findBelowElement(List.of(
                new Finder(LocatorType.XPATH, "//button[@aria-label='Choose date']", false),
                finder)));
        click(findElement(new Finder(LocatorType.XPATH, "//button[@aria-label='calendar view is open, switch to year view']", true)));
        click(findElement(new Finder(LocatorType.XPATH, String.format(xpath, year), true)));
        final WebPageElement div = findLeftElement(List.of(
                new Finder(LocatorType.TAG_NAME, "div", false),
                new Finder(LocatorType.XPATH,
                        "//button[@aria-label='calendar view is open, switch to year view']", true)));

        while (!getText(div).equals(String.format("%s %d", month.getName(), year))) {
            click(findElement(new Finder(LocatorType.XPATH, "//button[@aria-label='Next month']", true)));
        }

        click(findElement(new Finder(LocatorType.XPATH, String.format(xpath, date), true)));
    }

    protected final void click(final WebPageElement webPageElement) {
        webPageElement.interact().click();
    }

    protected final boolean isDisplayed(final WebPageElement webPageElement) {
        return webPageElement.getElementInformationProvider().isDisplayed();
    }

    protected final String getText(final WebPageElement webPageElement) {
        return webPageElement.getElementInformationProvider().getText();
    }

    protected final void select(final String option) {

        for (final WebPageElement element : findElements(new Finder(LocatorType.TAG_NAME, "li", true))) {

            if (getText(element).equalsIgnoreCase(option)) {
                click(element);
                break;
            }
        }
    }
}
