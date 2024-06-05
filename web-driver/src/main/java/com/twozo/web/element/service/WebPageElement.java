package com.twozo.web.element.service;

import com.twozo.web.element.web.page.element.WebPageElementImpl;
import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides various services related to {@link WebPageElement}. Such as interaction, information
 * retrieval, and element finding functionalities.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementFinder elementLocator = webAutomationDriver.getElementFinder();
 * WebPageElement webPageElement = elementLocator.getWebPageElement(LocatorType.Id,"id");
 * ElementFinder locator = webPageElement.getElementFinder();
 * ElementInteraction interaction = webPageElement.interact();
 * ElementInformationProvider information = webPageElement.getInformer();
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
     * Returns an {@link ElementFinder} specific to the context of the {@link WebPageElement}.
     * </p>
     *
     * @return An {@link ElementFinder} for further element search within the element.
     */
    ElementFinder getElementFinder();

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
     * Returns an {@link ElementInformationProvider} for retrieving information about the {@link WebPageElement}
     * such as the tag name, attribute value, selection status, enabled status, text content, and
     * display status of the web element.
     * </p>
     *
     * @return An {@link ElementInformationProvider} for getting information about the element.
     */
    ElementInformationProvider getElementInformationProvider();
}
