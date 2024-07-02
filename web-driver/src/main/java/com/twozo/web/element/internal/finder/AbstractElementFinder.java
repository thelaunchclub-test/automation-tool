package com.twozo.web.element.internal.finder;

import com.twozo.web.element.internal.web.page.element.WebPageElementImpl;
import com.twozo.web.element.model.LocatorType;
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
     * Returns {@link RelativeLocator.RelativeBy} based on the specified locator send and value.
     * </p>
     *
     * @param locatorType The type of locator to use.
     * @param value       The value of the locator.
     * @return A {@link RelativeLocator.RelativeBy} representing the specified locator.
     */
    protected RelativeLocator.RelativeBy with(final LocatorType locatorType, final String value) {
        return getRelativeByValue(locatorType, value);
    }

    /**
     * <p>
     * Returns {@link RelativeLocator.RelativeBy} based on the specified {@link LocatorType} and value.
     * </p>
     *
     * @param locatorType The type of locator to use.
     * @param value       The value of the locator.
     * @return A {@link RelativeLocator.RelativeBy} representing the specified locator.
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
     * @param locatorType The type of locator to use.
     * @param value       The value of the locator.
     * @return A {@link By} representing the locator.
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
            webPageElements.add(new WebPageElementImpl(element));
        }

        return webPageElements;
    }
}