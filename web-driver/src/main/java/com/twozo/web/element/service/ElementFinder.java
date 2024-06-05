package com.twozo.web.element.service;

import com.twozo.web.element.finder.ElementFinderForDriver;
import com.twozo.web.element.finder.ElementFinderForElement;
import com.twozo.web.element.locator.LocatorType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * Represents an element finder, providing methods to locate multiple elements and a single element based
 * on a given {@link By} locator.
 * </p>
 *
 * <p>
 * Defines methods for finding web page elements based on a specified {@link By} locator.
 * Provides flexibility to locate either a single element or multiple elements on a web page.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementFinder elementLocator = webAutomationDriver.getElementFinder();
 * WebPageElement singleElement = elementLocator.getWebPageElement(LocatorType.ID, "element-id");
 * Collection<WebPageElement> multipleElements = elementLocator.getWebPageElements
 *                                          (LocatorType.CLASS_NAME, "element-class");
 * WebPageElement elementBelow = elementLocator.withBelowElement(LocatorType.CSS_SELECTOR, "below-element-css",
 *                                          LocatorType.ID, "above-element-id");
 * WebPageElement elementNear = elementLocator.withNearElement(LocatorType.NAME, "near-element-name",
 *                                          LocatorType.XPATH, "reference-element-xpath");
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ElementFinder {

    static ElementFinder getInstance(final Object value) {
        return switch (value) {
            case WebDriver webDriver -> new ElementFinderForDriver(webDriver);
            case WebElement webElement -> new ElementFinderForElement(webElement);
            default -> throw new IllegalArgumentException("Unsupported type ");
        };
    }

    /**
     * returns a {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement getWebPageElement(final LocatorType locatorType, final String value);

    /**
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value);

    /**
     * returns a {@link WebPageElement} located below another element.
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement withBelowElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located above another element.
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement withAboveElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the left of another element.
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement withLeftElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the right of another element.
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement withRightElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located near another element.
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    WebPageElement withNearElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);
}
