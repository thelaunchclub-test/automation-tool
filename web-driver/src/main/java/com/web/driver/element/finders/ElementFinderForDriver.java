package com.web.driver.element.finders;

import com.web.driver.element.impl.WebPageElementImpl;
import com.web.driver.element.service.WebPageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

/**
 * <p>
 * The {@link ElementFinderForDriver} provides methods to find web page elements.
 * Locates both single and multiple elements
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see AbstractElementFinder
 */
public final class ElementFinderForDriver extends AbstractElementFinder {

    private final WebDriver driver;

    public ElementFinderForDriver(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find elements.
     * @return A {@link Collection} of {@link WebPageElement} representing the found elements.
     */
    @Override
    public Collection<WebPageElement> findElements(final By by) {
        return getCommonElements(driver.findElements(by));
    }

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find the element.
     * @return The {@link WebPageElement} representing the found element.
     */
    @Override
    public WebPageElement findElement(final By by) {
        return new WebPageElementImpl(driver.findElement(by));
    }
}
