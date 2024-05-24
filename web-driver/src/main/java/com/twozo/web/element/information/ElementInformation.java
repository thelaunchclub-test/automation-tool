package com.twozo.web.element.information;

import com.twozo.web.element.web.page.element.WebPageElement;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides information about a {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Retrieves various information about a {@link WebPageElement}
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
 */
public interface ElementInformation {

    static ElementInformation getInstance(final WebElement element) {
        return new ElementInformationImpl(element);
    }

    /**
     * <p>
     * Gets the tag name of the {@link WebElement}.
     * </p>
     *
     * @return The tag name as a String.
     */
    String getTagName();

    /**
     * <p>
     * Gets the value of the specified attribute of the {@link WebElement}.
     * </p>
     *
     * @param name The name of the attribute.
     * @return The attribute value as a {@link String}.
     */
    String getAttribute(final String name);

    /**
     * </p>
     * Checks if the {@link WebElement} is selected.
     * </p>
     *
     * @return true if the element is selected, false otherwise.
     */
    boolean isSelected();

    /**
     * <p>
     * Checks if the {@link WebElement} is enabled.
     * </p>
     *
     * @return true if the element is enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * <p>
     * Gets the visible text of the {@link WebElement}.
     * </p>
     *
     * @return The text of a {@link WebElement}as a String.
     */
    String getText();

    /**
     * <p>
     * Checks if the {@link WebElement} is displayed.
     * </p>
     *
     * @return true if the element is displayed, false otherwise.
     */
    boolean isDisplayed();
}
