package com.twozo.page;

import com.twozo.page.xpath.XPath;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.ExplicitWaitHandler;
import com.twozo.web.driver.service.PageInformationProvider;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.driver.service.WebNavigator;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.ElementInformationProvider;
import com.twozo.web.element.service.ElementInteraction;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.mouse.service.actions.MouseActions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class BasePage {

    protected WebAutomationDriver webAutomationDriver;
    protected ElementFinder elementFinder;
    protected WebNavigator webNavigator;
    protected PageInformationProvider pageInformationProvider;
    protected MouseActions mouseActions;
    protected ExplicitWaitHandler explicitWaitHandler;

    protected BasePage(final WebAutomationDriver webAutomationDriver) {
        this.webAutomationDriver = webAutomationDriver;
        this.elementFinder = webAutomationDriver.getElementFinder();
        this.webNavigator = webAutomationDriver.getWebNavigator();
        this.pageInformationProvider = webAutomationDriver.getPageInformationProvider();
        this.mouseActions = webAutomationDriver.getMouseActionsHandler();
        this.explicitWaitHandler = webAutomationDriver.getExplicitWaitHandler();
    }

    public void waitTillVisible(String xpath) {
        explicitWaitHandler.waitTillVisible(new Element(LocatorType.XPATH, xpath, true));
    }

    protected final WebPageElement findElement(final Element element) {
        return elementFinder.getWebPageElement(element);
    }

    protected final Collection<WebPageElement> findElements(final Element element) {
        return elementFinder.getWebPageElements(element);
    }

    protected final WebPageElement findAboveElement(final Collection<Element> elements) {
        return elementFinder.findAboveElement(elements);
    }

    protected final WebPageElement findBelowElement(final Collection<Element> elements) {
        return elementFinder.findBelowElement(elements);
    }

    protected final WebPageElement findNearElement(final Collection<Element> elements) {
        return elementFinder.findNearElement(elements);
    }

    protected final WebPageElement findLeftElement(final Collection<Element> elements) {
        return elementFinder.findLeftElement(elements);
    }

    protected final WebPageElement findRightElement(final Collection<Element> elements) {
        return elementFinder.findRightElement(elements);
    }

    public WebPageElement findByXpath(final XPath xpath) {
        return findElement(new Element(LocatorType.XPATH, XPathBuilder.getXPath(xpath), true));
    }

    public WebPageElement findByXpath(final String xpath) {
        return findElement(new Element(LocatorType.XPATH, xpath, true));
    }

    protected Collection<WebPageElement> findElementsByXpath(final String xpath) {
        return findElements(new Element(LocatorType.XPATH, xpath, true));
    }

    protected WebPageElement findByText(final String value) {
        return findElement(new Element(LocatorType.XPATH, XPathBuilder.getXPathByText(value), true));
    }

    protected final void send(final WebPageElement webPageElement, final String value) {
        getElementInteraction(webPageElement).sendKeys(value);
    }

    protected final void click(final WebPageElement webPageElement) {
        getElementInteraction(webPageElement).click();
    }

    protected <T> T initializeElement(final T element, final Supplier<T> initializer) {
        return Objects.isNull(element) ? initializer.get() : element;
    }

    protected String buildXpathByText(final String text) {
        return XPathBuilder.getXPathByText(text);
    }

    protected final void selectDate(final Element element, final String month, final int date, final int year) {
        final String xpath = "//button[text()='%d']";

        click(findBelowElement(List.of(
                new Element(LocatorType.XPATH, "//button[@aria-label='Choose date']", false),
                element)));
        click(findByXpath("//button[@aria-label='calendar view is open, switch to year view']"));
        click(findByText(String.format(xpath, year)));
        final WebPageElement div = findLeftElement(List.of(
                new Element(LocatorType.TAG_NAME, "div", false),
                new Element(LocatorType.XPATH,
                        "//button[@aria-label='calendar view is open, switch to year view']", true)));

        while (!getText(div).equals(String.format("%s %d", month, year))) {
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

    protected String getURL() {
        return pageInformationProvider.getCurrentUrl();
    }

    protected String contains(final String name) {
        return XPathBuilder.getXpathByContains(name);
    }

    protected String getAttribute(final WebPageElement webPageElement, String attributeName) {
        return getElementInformationProvider(webPageElement).getAttribute(attributeName);
    }

    protected final void dropdown(final String option) {
        select(option, "li");
    }

    protected final void dropdownMenu(final String option) {
        select(option, "div");
    }

    protected final void hover(final Element element) {
        mouseActions.moveToElement(element).build().perform();
    }

    protected final void hoverByXpath(final String xpath) {
        mouseActions.moveToElement(new Element(LocatorType.XPATH, xpath, true)).build().perform();
    }

    private void select(final String option, final String dropdownType) {
        for (final WebPageElement element : findElements(new Element(LocatorType.TAG_NAME, dropdownType, true))) {

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

    protected void refresh() {
        webNavigator.refresh();

    }
//    public WebPageElement getStatus() {
//
//        if (Objects.isNull(status)) {
//            status = findByXpath("(//div[text()='Status'])[2]");
//            status = TagFinder.get(Record)
//        }
//
//        return status;
//    }

}
