package com.twozo.page;

import com.twozo.web.driver.service.PageInformationProvider;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.driver.service.WebNavigator;

import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.ElementInformationProvider;
import com.twozo.web.element.service.ElementInteraction;
import com.twozo.web.element.service.WebPageElement;

import java.util.ArrayList;
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

    protected WebPageElement findByXpath(final String xpath) {
        return findElement(new Finder(LocatorType.XPATH, xpath, true));
    }

    protected Collection<WebPageElement> findElementsByXpath(final String xpath) {
        return findElements(new Finder(LocatorType.XPATH, xpath, true));
    }

    protected WebPageElement findByText(final String value) {
        return findByXpath(String.format("//*[text()='%s']", value));
    }

    protected final void send(final WebPageElement webPageElement, final String value) {
        getElementInteraction(webPageElement).sendKeys(value);
    }

    protected final void click(final WebPageElement webPageElement) {
        getElementInteraction(webPageElement).click();
    }

    protected final void selectDate(final Finder finder, final Month month, final int date, final int year) {
        final String xpath = "//button[text()='%d']";

        click(findBelowElement(List.of(
                new Finder(LocatorType.XPATH, "//button[@aria-label='Choose date']", false),
                finder)));
        click(findByXpath("//button[@aria-label='calendar view is open, switch to year view']"));
        click(findByText(String.format(xpath, year)));
        final WebPageElement div = findLeftElement(List.of(
                new Finder(LocatorType.TAG_NAME, "div", false),
                new Finder(LocatorType.XPATH,
                        "//button[@aria-label='calendar view is open, switch to year view']", true)));

        while (!getText(div).equals(String.format("%s %d", month.getName(), year))) {
            click(findByXpath("//button[@aria-label='Next month']"));
        }

        click(findByXpath(String.format(xpath, date)));
    }

    public final boolean isDisplayed(final WebPageElement webPageElement) {
        return getElementInformationProvider(webPageElement).isDisplayed();
    }

    protected final String getText(final WebPageElement webPageElement) {
        return getElementInformationProvider(webPageElement).getText();
    }

    protected final List<String> getTexts(final Collection<WebPageElement> webPageElement) {
        final List<String> names = new ArrayList<>();

        for (WebPageElement field : webPageElement) {
            names.add(getText(field));
        }
        return names;
    }

    protected String getAttribute(final WebPageElement webPageElement, String attributeName) {
        return getElementInformationProvider(webPageElement).getAttribute(attributeName);
    }

    protected final void select(final String option) {

        for (final WebPageElement element : findElements(new Finder(LocatorType.TAG_NAME, "li", true))) {

            if (getText(element).equalsIgnoreCase(option)) {
                click(element);
                break;
            }
        }
    }

    private ElementInformationProvider getElementInformationProvider(final WebPageElement webPageElement) {
        return webPageElement.getElementInformationProvider();
    }

    private ElementInteraction getElementInteraction(final WebPageElement webPageElement) {
        return webPageElement.interact();
    }
}
