package com.twozo.web.element.web.page.element;

import com.twozo.web.element.finders.ElementLocator;
import com.twozo.web.element.information.ElementInformation;
import com.twozo.web.element.interaction.ElementInteraction;

import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code WebPageElementImpl} provides various services related to {@link WebPageElement}s.
 * Encapsulates interaction, information retrieval, and element finding functionalities.
 * </p>
 *
 * @author petchimuthu
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
     * @return An {@link ElementLocator}  for further element search within this element.
     */
    @Override
    public ElementLocator getElementLocator() {
        return elementLocator;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementInteraction}  for interacting with this element.
     */
    @Override
    public ElementInteraction interact() {
        return elementInteraction;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementInformation}  for getting information about this element.
     */
    @Override
    public ElementInformation getInformer() {
        return elementInformation;
    }
}
