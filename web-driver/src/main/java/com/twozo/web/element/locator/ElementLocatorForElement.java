package com.twozo.web.element.locator;

import com.twozo.web.element.web.page.element.WebPageElement;
import com.twozo.web.element.web.page.element.WebPageElementImpl;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * The {@link ElementLocatorForElement} provides methods to find {@link WebPageElement}.
 * Locates both single and multiple elements.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see AbstractElementLocator
 */
@Value
@NonNull
@AllArgsConstructor
public class ElementLocatorForElement extends AbstractElementLocator {

    WebElement element;

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement getWebPageElement(final LocatorType locatorType, final String value) {
        return new WebPageElementImpl(element.findElement(getByValue(locatorType, value)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use
     * @param value the value of the locator
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements
     */
    @Override
    public Collection<WebPageElement> getWebPageElements(final LocatorType locatorType, final String value) {
        return getCommonElements(element.findElements(getByValue(locatorType, value)));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withBelowElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                below(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withAboveElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                above(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withLeftElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                toLeftOf(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withRightElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                toRightOf(getByValue(knownLocatorType, knownValue))));
    }

    /**
     * {@inheritDoc}
     *
     * @param locatorType the type of locator to use for the target element
     * @param value the value of the locator for the target element
     * @param knownLocatorType the type of locator to use for the known element
     * @param knownValue the value of the locator for the known element
     * @return a {@link WebPageElement} representing the located web page element
     */
    @Override
    public WebPageElement withNearElement(final LocatorType locatorType, final String value, final LocatorType
            knownLocatorType, final String knownValue) {
        return new WebPageElementImpl(element.findElement(with(locatorType, value).
                near(getByValue(knownLocatorType, knownValue))));
    }
}
