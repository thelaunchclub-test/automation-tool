package com.twozo.web.element.service;

import com.twozo.web.element.model.Element;

import lombok.NonNull;
import org.openqa.selenium.By;

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
 * WebPageElement elementBelow = elementLocator.findBelowElement(LocatorType.CSS_SELECTOR, "below-element-css",
 *                                          LocatorType.ID, "above-element-id");
 * WebPageElement elementNear = elementLocator.findNearElement(LocatorType.NAME, "near-element-name",
 *                                          LocatorType.XPATH, "reference-element-xpath");
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ElementFinder {

    /**
     * <p>
     * returns a {@link WebPageElement} based on the given locator type and value.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement getWebPageElement(final Element element);

    /**
     * <p>
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     * </p>
     *
     * @return A {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    Collection<WebPageElement> getWebPageElements(final Element element);

    /**
     * <p>
     * returns a {@link WebPageElement} located below another element.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement findBelowElement(final Collection<Element> elements);

    /**
     * <p>
     * returns a {@link WebPageElement} located above another element.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement findAboveElement(final Collection<Element> elements);

    /**
     * <p>
     * returns a {@link WebPageElement} located to the left of another element.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement findLeftElement(final Collection<Element> elements);

    /**
     * <p>
     * returns a {@link WebPageElement} located to the right of another element.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement findRightElement(final Collection<Element> elements);

    /**
     * <p>
     * returns a {@link WebPageElement} located near another element.
     * </p>
     *
     * @return A {@link WebPageElement} representing the located web page element.
     */
    WebPageElement findNearElement(final Collection<Element> elements);
}
