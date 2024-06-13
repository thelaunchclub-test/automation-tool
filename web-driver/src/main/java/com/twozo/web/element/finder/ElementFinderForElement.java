package com.twozo.web.element.finder;

import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.element.web.page.element.WebPageElementImpl;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * Provides methods to find {@link WebPageElement} from {@link WebPageElement}.
 * Locates both single and multiple elements.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see AbstractElementFinder
 */
@NonNull
@AllArgsConstructor
public final class ElementFinderForElement extends AbstractElementFinder {

    private final WebElement element;

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement getWebPageElement(final LocatorType locatorType, final String value) {
        return new WebPageElementImpl(element.findElement(getByValue(locatorType, value)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use.
     * @param value       the value of the locator.
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    @Override
    public Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value) {
        return getCommonElements(element.findElements(getByValue(locatorType, value)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findBelowElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                below(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findAboveElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                above(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findLeftElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                toLeftOf(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findRightElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                toRightOf(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType      the type of locator to use for the target element.
     * @param value            the value of the locator for the target element.
     * @param knownLocatorType the type of locator to use for the known element.
     * @param knownValue       the value of the locator for the known element.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findNearElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                near(getByValue(knownLocatorType, knownValue))));
    }
}
