package com.twozo.web.element.finder;

import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.WebPageElement;

import lombok.NonNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Provides common functionality for element finders.
 * </p>
 *
 * <p>
 * Provides common functionality for finding web elements and converting them to {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Defines methods for converting {@link WebElement} to {@link WebPageElement}
 * and for finding web page elements using different finding strategies specified by {@link By}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ElementFinder
 */
@NonNull
public abstract class AbstractElementFinder implements ElementFinder {

    /**
     * <p>
     * returns a {@link WebPageElement} based on the given locator type and value.
     * </p>
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement getWebPageElement(final LocatorType locatorType, final String value);

    /**
     * <p>
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     * </p>
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    public abstract Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value);

    /**
     * <p>
     * returns a {@link WebPageElement} located below another element.
     * </p>
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement findBelowElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * <p>
     * returns a {@link WebPageElement} located above another element.
     * </p>
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement findAboveElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * <p>
     * returns a {@link WebPageElement} located to the left of another element.
     * </p>
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement findLeftElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * <p>
     * returns a {@link WebPageElement} located to the right of another element.
     * </p>
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement findRightElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * <p>
     * returns a {@link WebPageElement} located near another element.
     * </p>
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    public abstract WebPageElement findNearElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue);

    /**
     * <p>
     * Returns a {@link RelativeLocator.RelativeBy} based on the specified locator type and value.
     * </p>
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a RelativeLocator.RelativeBy instance representing the specified locator.
     */
    protected RelativeLocator.RelativeBy with(final LocatorType locatorType, final String value) {
        return getRelativeByValue(locatorType, value);
    }

    /**
     * <p>
     * Returns {@link RelativeLocator.RelativeBy} based on the specified {@link LocatorType} and value.
     * </p>
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link RelativeLocator.RelativeBy} representing the specified locator.
     */
    protected RelativeLocator.RelativeBy getRelativeByValue(final LocatorType locatorType, final String value) {
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
     * <p>
     * Retrieves a {@link By} based on the specified {@link LocatorType} and value.
     * </p>
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link By} representing the locator.
     */
    protected By getByValue(final LocatorType locatorType, final String value) {
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

    /**
     * <p>
     * Retrieves a {@link Collection} of {@link WebPageElement} from the provided
     * {@link Collection} of {@link WebElement}.
     * </p>
     *
     * @param webElements The {@link Collection} of {@link WebElement} .
     * @return A {@link Collection} of {@link WebPageElement}.
     */
    protected Collection<WebPageElement> getCommonElements(final Collection<WebElement> webElements) {
        final Collection<WebPageElement> webPageElements = new ArrayList<>();

        for (final WebElement element : webElements) {
            webPageElements.add(WebPageElement.getInstance(element));
        }

        return webPageElements;
    }
}