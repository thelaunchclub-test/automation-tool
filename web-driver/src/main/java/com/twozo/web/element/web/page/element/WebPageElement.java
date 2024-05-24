package com.twozo.web.element.web.page.element;

import com.twozo.web.element.finders.ElementLocator;
import com.twozo.web.element.information.ElementInformation;
import com.twozo.web.element.interaction.ElementInteraction;

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
     * Returns an {@link ElementLocator} specific to the context of this {@link WebPageElement}.
     * </p>
     *
     * @return An {@link ElementLocator}  for further element search within this element.
     */
    ElementLocator getElementLocator();

    /**
     * <p>
     * Returns an {@link ElementInteraction}  for performing actions on this {@link WebPageElement}.
     * </p>
     *
     * @return An {@link ElementInteraction}  for interacting with this element.
     */
    ElementInteraction interact();

    /**
     * <p>
     * Returns an {@link ElementInformation}  for retrieving information about this {@link WebPageElement}.
     * </p>
     *
     * @return An {@link ElementInformation}  for getting information about this element.
     */
    ElementInformation getInformer();
}
