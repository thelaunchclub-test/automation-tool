package com.twozo.web.element.service;

import com.twozo.web.element.information.ElementInformationProviderImpl;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides methods to retrieve information about a {@link WebPageElement}.
 * Includes methods to get the tag name, attributes, visibility, selection state,
 * and other properties of a web element.
 *</p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementFinder elementLocator = webAutomationDriver.getElementFinder();
 * ElementInformationProvider elementInfo = elementLocator.getWebPageElement(LocatorType.Id,"id").getInformer();
 * String tagName = elementInfo.getTagName();
 * String classAttribute = elementInfo.getAttribute("class");
 * boolean isSelected = elementInfo.isSelected();
 * boolean isEnabled = elementInfo.isEnabled();
 * String text = elementInfo.getText();
 * boolean isDisplayed = elementInfo.isDisplayed();
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ElementInformationProvider {

    static ElementInformationProvider getInstance(final WebElement element) {
        return new ElementInformationProviderImpl(element);
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
     * <p>
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