package com.twozo.web.element.internal.information;

import com.twozo.web.element.service.ElementInformationProvider;
import com.twozo.web.element.service.WebPageElement;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides methods to retrieve information about a {@link WebPageElement}.
 * Includes methods to get the tag name, attributes, visibility, selection state,
 * and other properties of a web element.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementFinder elementFinder = webAutomationDriver.getElementFinder();
 * ElementInformationProvider elementInformationProvider = elementFinder.getWebPageElement(LocatorType.Id,"id").
 *                                                          getInformer();
 * String tagName = elementInformationProvider.getTagName();
 * String classAttribute = elementInformationProvider.getAttribute("class");
 * boolean isSelected = elementInformationProvider.isSelected();
 * boolean isEnabled = elementInformationProvider.isEnabled();
 * String text = elementInfo.getText();
 * boolean isDisplayed = elementInfo.isDisplayed();
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ElementInformationProvider
 */
@NonNull
@AllArgsConstructor
public final class ElementInformationProviderImpl implements ElementInformationProvider {

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
     * @return true If the element is selected, false otherwise.
     */
    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    /**
     * {@inheritDoc}
     *
     * @return true If the element is enabled, false otherwise.
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
     * @return true If the element is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
