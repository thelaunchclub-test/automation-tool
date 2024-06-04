package com.twozo.web.element.information;

import com.twozo.web.element.web.page.element.WebPageElement;

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
 * ElementLocator elementLocator = webAutomationDriver.getElementLocator();
 * ElementInformation elementInfo = elementLocator.getWebPageElement(LocatorType.Id,"id").getInformer();
 *
 * String tagName = elementInfo.getTagName(); // Gets the tag name of the element
 * String classAttribute = elementInfo.getAttribute("class"); // Gets the value of the 'class' attribute
 * boolean isSelected = elementInfo.isSelected(); // Checks if the element is selected
 * boolean isEnabled = elementInfo.isEnabled(); // Checks if the element is enabled
 * String text = elementInfo.getText(); // Gets the visible text of the element
 * boolean isDisplayed = elementInfo.isDisplayed(); // Checks if the element is displayed
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
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
