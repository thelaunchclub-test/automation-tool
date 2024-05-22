package com.web.driver.element.service;

import com.web.driver.element.impl.InformationImpl;

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
 * @author petchimuthu1520
 * @version 1.0
 */
public interface Information {

    /**
     * Returns {@link Information} based on the provided {@link WebElement}.
     *
     * @param element The {@link WebElement} to be used for creating the {@link Information}.
     * @return An {@link Information} to get information about the element.
     */
    static Information getInstance(final WebElement element) {
        return new InformationImpl(element);
    }

    /**
     * Gets the tag name of the {@link WebElement}.
     *
     * @return The tag name as a String.
     */
    String getTagName();

    /**
     * Gets the value of the specified attribute of the {@link WebElement}.
     *
     * @param name The name of the attribute.
     * @return The attribute value as a String.
     */
    String getAttribute(final String name);

    /**
     * Checks if the {@link WebElement} is selected.
     *
     * @return true if the element is selected, false otherwise.
     */
    boolean isSelected();

    /**
     * Checks if the {@link WebElement} is enabled.
     *
     * @return true if the element is enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * Gets the visible text of the {@link WebElement}.
     *
     * @return The text of a {@link WebElement}as a String.
     */
    String getText();

    /**
     * Checks if the {@link WebElement} is displayed.
     *
     * @return true if the element is displayed, false otherwise.
     */
    boolean isDisplayed();
}
