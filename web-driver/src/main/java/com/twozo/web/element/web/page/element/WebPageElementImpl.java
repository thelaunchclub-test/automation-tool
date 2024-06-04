package com.twozo.web.element.web.page.element;

import com.twozo.web.element.locator.ElementLocator;
import com.twozo.web.element.information.ElementInformation;
import com.twozo.web.element.interaction.ElementInteraction;

import lombok.NonNull;
import lombok.Value;

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
 * @see WebPageElement
 */
@Value
@NonNull
public class WebPageElementImpl implements WebPageElement {

    ElementInteraction elementInteraction;
    ElementInformation elementInformation;
    ElementLocator elementLocator;

    public WebPageElementImpl(final WebElement webElement) {
        this.elementInteraction = ElementInteraction.getInstance(webElement);
        this.elementInformation = ElementInformation.getInstance(webElement);
        this.elementLocator = ElementLocator.getInstance(webElement);
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementLocator} for further element search within the element.
     */
    @Override
    public ElementLocator getElementLocator() {
        return elementLocator;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementInteraction} for interacting with the element.
     */
    @Override
    public ElementInteraction interact() {
        return elementInteraction;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementInformation} for getting information about the element.
     */
    @Override
    public ElementInformation getInformer() {
        return elementInformation;
    }
}
