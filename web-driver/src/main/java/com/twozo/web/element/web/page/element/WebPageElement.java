package com.twozo.web.element.web.page.element;

import com.twozo.web.element.locator.ElementLocator;
import com.twozo.web.element.information.ElementInformation;
import com.twozo.web.element.interaction.ElementInteraction;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code WebPageElement} provides various services related to {@link WebPageElement}.
 * Such as interaction, information retrieval, and element finding functionalities.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementLocator elementLocator = webAutomationDriver.getElementLocator();
 * WebPageElement webPageElement = elementLocator.getWebPageElement(LocatorType.Id,"id");
 *
 * // Get an ElementLocator specific to the context of the WebPageElement
 * ElementLocator locator = webPageElement.getElementLocator();
 *
 * // Get an ElementInteraction for performing actions on the WebPageElement
 * ElementInteraction interaction = webPageElement.interact();
 *
 * // Get an ElementInformation for retrieving information about the WebPageElement
 * ElementInformation information = webPageElement.getInformer();
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebPageElement {

    static WebPageElement getInstance(final WebElement element) {
        return new WebPageElementImpl(element);
    }

    /**
     * <p>
     * Returns an {@link ElementLocator} specific to the context of the {@link WebPageElement}.
     * </p>
     *
     * @return An {@link ElementLocator} for further element search within the element.
     */
    ElementLocator getElementLocator();

    /**
     * <p>
     * Returns an {@link ElementInteraction} for performing actions on the {@link WebPageElement}
     * such as clicking, submitting, and sending keys.
     * </p>
     *
     * @return An {@link ElementInteraction} for interacting with the element.
     */
    ElementInteraction interact();

    /**
     * <p>
     * Returns an {@link ElementInformation} for retrieving information about the {@link WebPageElement}
     * such as the tag name, attribute value, selection status, enabled status, text content, and
     * display status of the web element.
     * </p>
     *
     * @return An {@link ElementInformation} for getting information about the element.
     */
    ElementInformation getInformer();
}
