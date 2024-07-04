package com.twozo.web.element.internal.web.page.element;

import com.twozo.web.element.internal.finder.ElementFinderForElement;
import com.twozo.web.element.internal.information.ElementInformationProviderImpl;
import com.twozo.web.element.internal.interaction.ElementInteractionImpl;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.element.service.ElementInformationProvider;
import com.twozo.web.element.service.ElementInteraction;
import com.twozo.web.element.service.WebPageElement;

import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides various services related to {@link WebPageElement}.
 * Such as interaction, information retrieval, and element finding functionalities.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementFinder elementFinder = webAutomationDriver.getElementFinder();
 * WebPageElement webPageElement = elementFinder.getWebPageElement(LocatorType.Id,"id");
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

    public WebPageElementImpl(@NonNull final WebElement webElement) {
        this.elementInteraction = new ElementInteractionImpl(webElement);
        this.elementInformation = new ElementInformationProviderImpl(webElement);
        this.elementFinder = new ElementFinderForElement((webElement));
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
