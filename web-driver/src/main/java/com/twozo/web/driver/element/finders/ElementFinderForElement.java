package com.twozo.web.driver.element.finders;

import com.twozo.web.driver.element.service.WebPageElement;
import com.twozo.web.driver.element.impl.WebPageElementImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * <p>
 * The {@link ElementFinderForElement} provides methods to find web page elements.
 * Locates both single and multiple elements
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see AbstractElementFinder
 */
public final class ElementFinderForElement extends AbstractElementFinder {
    private final WebElement element;

    public ElementFinderForElement(final WebElement element) {
        this.element = element;
    }

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find elements.
     * @return A {@link Collection} of {@link WebPageElement} representing the found elements.
     */
    @Override
    public Collection<WebPageElement> findElements(final By by) {
        return getCommonElements(element.findElements(by));
    }

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find the element.
     * @return The {@link WebPageElement} representing the found element.
     */
    @Override
    public WebPageElement findElement(final By by) {
        return new WebPageElementImpl(element.findElement(by));
    }
}
