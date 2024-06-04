package com.twozo.web.element.information;

import com.twozo.web.element.web.page.element.WebPageElement;

import lombok.AllArgsConstructor;
import lombok.NonNull;

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
 * @see ElementInformation
 */
@NonNull
@AllArgsConstructor
public final class ElementInformationImpl implements ElementInformation {

    private final WebElement element;

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
     * @return The attribute value as a {@link String}.
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
     * @return The text of a {@link WebElement} as a String.
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
