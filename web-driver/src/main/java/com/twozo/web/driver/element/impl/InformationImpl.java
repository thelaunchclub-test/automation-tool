package com.twozo.web.driver.element.impl;

import com.twozo.web.driver.element.service.Information;
import com.twozo.web.driver.element.service.WebPageElement;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides information about a {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Retrieves various information about a web page element
 * represented by a {@link WebElement}.
 * </p>
 *
 * <p>
 * Provides methods to get information such as the tag name, attribute value, selection status,
 * enabled status, text content, and display status of the web element.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see Information
 */
public final class InformationImpl implements Information {

    private final WebElement element;

    public InformationImpl(final WebElement element) {
        this.element = element;
    }

    /**
     * {@inheritDoc}
     *
     * @return The tag name as a String.
     */
    @Override
    public String getTagName() {
        return element.getTagName();
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the attribute.
     * @return The attribute value as a String.
     */
    @Override
    public String getAttribute(final String name) {
        return element.getAttribute(name);
    }

    /**
     * {@inheritDoc}
     *
     * @return true if the element is selected, false otherwise.
     */
    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    /**
     * {@inheritDoc}
     *
     * @return true if the element is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    /**
     * {@inheritDoc}
     *
     * @return The text of a {@link WebElement}as a String.
     */
    @Override
    public String getText() {
        return element.getText();
    }

    /**
     * {@inheritDoc}
     *
     * @return true if the element is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
