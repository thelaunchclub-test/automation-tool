package com.twozo.web.element.locator;

import com.twozo.web.element.web.page.element.WebPageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * The {@code ElementLocator} represents an element finder, providing methods to locate multiple
 * elements and a single element based on a given {@link By} locator.
 * </p>
 *
 * <p>
 * The {@code ElementLocator} defines methods for finding web page elements
 * based on a specified {@link By} locator. Provides flexibility to locate
 * either a single element or multiple elements on a web page.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ElementLocator {

    static ElementLocator getInstance(final Object value) {
        return switch (value) {
            case WebDriver webDriver -> new ElementLocatorForDriver(webDriver);
            case WebElement webElement -> new ElementLocatorForElement(webElement);
            default -> throw new IllegalArgumentException("Unsupported type ");
        };
    }

    /**
     * returns a {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement getWebPageElement(final LocatorType locatorType, final String value);

    /**
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements
     */
    Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value);

    /**
     * returns a {@link WebPageElement} located below another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withBelowElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located above another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withAboveElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the left of another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withLeftElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the right of another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withRightElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located near another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withNearElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);
}
