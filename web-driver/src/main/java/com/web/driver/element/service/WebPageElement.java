package com.web.driver.element.service;

import com.web.driver.element.finders.ElementFinder;
import com.web.driver.element.impl.WebPageElementImpl;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code WebPageElement} provides various services related to {@link WebPageElement}s.
 * Encapsulates interaction, information retrieval, and element finding functionalities.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface WebPageElement {

    static WebPageElement getInstance(final WebElement element) {
        return new WebPageElementImpl(element);
    }

    /**
     * <p>
     * Returns an ElementFinder specific to the context of this WebPageElement.
     * </p>
     *
     * @return An ElementFinder instance for further element search within this element.
     */
    ElementFinder getElementfinder();

    /**
     * <p>
     * Returns an Interaction instance for performing actions on this WebPageElement.
     * </p>
     *
     * @return An Interaction instance for interacting with this element.
     */
    Interaction interact();

    /**
     * <p>
     * Returns an PageInformationProvider instance for retrieving information about this WebPageElement.
     * </p>
     *
     * @return An PageInformationProvider instance for getting information about this element.
     */
    Information getInformer();
}
