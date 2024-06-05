package com.twozo.web.element.web.page.element;

import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.ElementInformationProvider;
import com.twozo.web.element.service.ElementInteraction;

import com.twozo.web.element.service.WebPageElement;
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
 * ElementFinder elementFinder = webAutomationDriver.getElementFinder();
 * WebPageElement webPageElement = elementFinder.getWebPageElement(LocatorType.Id,"id");
 * ElementFinder locator = webPageElement.getElementFinder();
 * ElementInteraction interaction = webPageElement.interact();
 * ElementInformationProvider information = webPageElement.getInformer();
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
    ElementInformationProvider elementInformation;
    ElementFinder elementFinder;

    public WebPageElementImpl(final WebElement webElement) {
        this.elementInteraction = ElementInteraction.getInstance(webElement);
        this.elementInformation = ElementInformationProvider.getInstance(webElement);
        this.elementFinder = ElementFinder.getInstance(webElement);
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementFinder} for further element search within the element.
     */
    public ElementFinder getElementFinder() {
        return elementFinder;
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
     * @return An {@link ElementInformationProvider} for getting information about the element.
     */
    @Override
    public ElementInformationProvider getElementInformationProvider() {
        return elementInformation;
    }
}
