package com.web.driver.element.locator;

import com.web.driver.driver.service.WebAutomationDriver;
import com.web.driver.element.service.WebPageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.Collection;

/**
 * <p>
 * The {@code ElementLocator} represents an element locator, used to locate
 * web page elements within a web application. Provides methods to locate
 * web page elements based on different criteria.
 * </p>
 *
 * <p>
 * Encapsulates various strategies for locating web page elements, such as finding a single element, finding multiple elements,
 * or locating elements relative to other elements on the page.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see ElementLocator
 */
public final class ElementLocatorImpl implements ElementLocator {

    private final WebAutomationDriver webAutomationDriver;

    public ElementLocatorImpl(final WebAutomationDriver webAutomationDriver) {
        this.webAutomationDriver = webAutomationDriver;
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement getWebPageElement(final com.web.driver.element.locator.LocatorType locatorType, final String value) {
        return webAutomationDriver.getElementFinder().findElement(getByValue(locatorType, value));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements
     */
    @Override
    public Collection<WebPageElement> getWebPageElements(final com.web.driver.element.locator.LocatorType locatorType, final String value) {
        return webAutomationDriver.getElementFinder().findElements(getByValue(locatorType, value));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withBelowElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue) {
        return webAutomationDriver.getElementFinder().findElement(with(locatorType, value).below(getByValue(knownLocatorType, knownValue)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withAboveElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue) {
        return webAutomationDriver.getElementFinder().findElement(with(locatorType, value).above(getByValue(knownLocatorType, knownValue)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withLeftElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue) {
        return webAutomationDriver.getElementFinder().findElement(with(locatorType, value).toLeftOf(getByValue(knownLocatorType, knownValue)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withRightElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue) {
        return webAutomationDriver.getElementFinder().findElement(with(locatorType, value).toRightOf(getByValue(knownLocatorType, knownValue)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withNearElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue) {
        return webAutomationDriver.getElementFinder().findElement(with(locatorType, value).near(getByValue(knownLocatorType, knownValue)));
    }

    /**
     * Returns a {@link RelativeLocator.RelativeBy} based on the specified locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a RelativeLocator.RelativeBy instance representing the specified locator
     */
    private RelativeLocator.RelativeBy with(final com.web.driver.element.locator.LocatorType locatorType, final String value) {
        return getRelativeByValue(locatorType, value);
    }

    /**
     * Returns {@link RelativeLocator.RelativeBy} based on the specified locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a RelativeLocator.RelativeBy instance representing the specified locator
     */
    private RelativeLocator.RelativeBy getRelativeByValue(final com.web.driver.element.locator.LocatorType locatorType, final String value) {
        return switch (locatorType) {
            case ID -> RelativeLocator.with(By.id(value));
            case NAME -> RelativeLocator.with(By.name(value));
            case CLASS_NAME -> RelativeLocator.with(By.className(value));
            case XPATH -> RelativeLocator.with(By.xpath(value));
            case CSS_SELECTOR -> RelativeLocator.with(By.cssSelector(value));
            case LINKED_TEXT -> RelativeLocator.with(By.linkText(value));
            case PARTIALLY_LINKED_TEXT -> RelativeLocator.with(By.partialLinkText(value));
            case TAG_NAME -> RelativeLocator.with(By.tagName(value));
        };
    }

    /**
     * Retrieves a {@link By} object based on the specified locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a By object representing the locator
     */
    private By getByValue(final com.web.driver.element.locator.LocatorType locatorType, final String value) {
        return switch (locatorType) {
            case ID -> By.id(value);
            case NAME -> By.name(value);
            case CLASS_NAME -> By.className(value);
            case XPATH -> By.xpath(value);
            case CSS_SELECTOR -> By.cssSelector(value);
            case LINKED_TEXT -> By.linkText(value);
            case PARTIALLY_LINKED_TEXT -> By.partialLinkText(value);
            case TAG_NAME -> By.tagName(value);
        };
    }
}
