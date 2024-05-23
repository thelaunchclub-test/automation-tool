package com.twozo.web.driver.element.finders;

import com.twozo.web.driver.element.service.WebPageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * Represents an element finder, providing methods to locate multiple
 * elements and a single element based on a given {@link By} locator.
 * </p>
 *
 * <p>
 * The {@link ElementFinder} defines methods for finding web page elements
 * based on a specified {@link By} locator. Provides flexibility to locate
 * either a single element or multiple elements on a web page.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface ElementFinder {

    /**
     * <p>
     * Returns {@link ElementFinder} based on the type of the provided value.
     * </p>
     *
     * @param value The value to be used for creating the {@link ElementFinder}.
     * @return An {@link ElementFinder} for finding elements.
     */
    static ElementFinder getInstance(final Object value) {
        return switch (value) {
            case WebDriver webDriver -> new ElementFinderForDriver(webDriver);
            case WebElement webElement -> new ElementFinderForElement(webElement);
            default -> throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
        };
    }

    /**
     * <p>
     * Finds multiple web page elements based on the specified {@code By} locator.
     * </p>
     *
     * @param by The {@code By} locator used to getElementFinder elements.
     * @return A collection of {@link WebPageElement} representing the found elements.
     */
    Collection<WebPageElement> findElements(final By by);

    /**
     * <p>
     * Finds a single web page element based on the specified {@code By} locator.
     * </p>
     *
     * @param by The {@code By} locator used to getElementFinder the element.
     * @return The {@link WebPageElement} representing the found element.
     */
    WebPageElement findElement(final By by);
}
