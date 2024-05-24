package com.twozo.web.element.locator;

import com.twozo.web.element.web.page.element.WebPageElement;

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
 * The {@link AbstractElementLocator} Provides common functionality
 * for finding web elements and converting them to {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Defines methods for converting {@link WebElement} to {@link WebPageElement}
 * and for finding web elements using different locator strategies specified by {@link By}.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see ElementLocator
 */
@NonNull
public abstract class AbstractElementLocator implements ElementLocator {

    /**
     * returns a {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement getWebPageElement(final LocatorType locatorType, final String value);

    /**
     * Returns a {@link Collection} of {@link WebPageElement} based on the given locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements
     */
    public abstract Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value);

    /**
     * returns a {@link WebPageElement} located below another element.
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement withBelowElement(final LocatorType locatorType, final String value, final LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located above another element.
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement withAboveElement(final LocatorType locatorType, final String value, final LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the left of another element.
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement withLeftElement(final LocatorType locatorType, final String value, final LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located to the right of another element.
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement withRightElement(final LocatorType locatorType, final String value, final LocatorType knownLocatorType, final String knownValue);

    /**
     * returns a {@link WebPageElement} located near another element.
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    public abstract WebPageElement withNearElement(final LocatorType locatorType, final String value, final LocatorType knownLocatorType, final String knownValue);

    /**
     * Returns a {@link RelativeLocator.RelativeBy} based on the specified locator type and value.
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a RelativeLocator.RelativeBy instance representing the specified locator
     */
    protected RelativeLocator.RelativeBy with(final LocatorType locatorType, final String value) {
        return getRelativeByValue(locatorType, value);
    }

    /**
     * Returns {@link RelativeLocator.RelativeBy} based on the specified {@link LocatorType} and value.
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a {@link RelativeLocator.RelativeBy} representing the specified locator
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
     * Retrieves a {@link By} based on the specified {@link LocatorType} and value.
     *
     * @param locatorType the type of locator to use.
     * @param value the value of the locator.
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
     * Retrieves a {@link Collection} of {@link WebPageElement} from the provided
     * {@link Collection} of {@link WebElement}.
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