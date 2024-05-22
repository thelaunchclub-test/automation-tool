package com.web.driver.element.locator;

import com.web.driver.driver.service.WebAutomationDriver;
import com.web.driver.element.service.WebPageElement;

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
 */
public interface ElementLocator {

    /**
     * Returns {@code ElementLocator} for locating web page elements.
     *
     * @param webAutomationDriver the web automation driver used to interact with the web page
     * @return An {@code ElementLocator}
     */
    static ElementLocator getInstance(final WebAutomationDriver webAutomationDriver) {
        return new com.web.driver.element.locator.ElementLocatorImpl(webAutomationDriver);
    }

    /**
     * returns a {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement getWebPageElement(final com.web.driver.element.locator.LocatorType locatorType, final String value);

    /**
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value       the value of the locator
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements
     */
    Collection<WebPageElement> getWebPageElements(final com.web.driver.element.locator.LocatorType locatorType, final String value);

    /**
     * returns a {@link WebPageElement} located below another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withBelowElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located above another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withAboveElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the left of another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withLeftElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the right of another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withRightElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located near another element.
     *
     * @param locatorType      the type of locator to use for the target element
     * @param value            the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue       the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    WebPageElement withNearElement(final com.web.driver.element.locator.LocatorType locatorType, final String value, final com.web.driver.element.locator.LocatorType knownLocatorType, final String knownValue);
}
