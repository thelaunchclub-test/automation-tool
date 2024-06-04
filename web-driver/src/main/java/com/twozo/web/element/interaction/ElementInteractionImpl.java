package com.twozo.web.element.interaction;

import com.twozo.web.element.web.page.element.WebPageElement;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Provides methods to interact with a {@link WebPageElement}. Includes methods to perform
 * common actions such as clicking, submitting forms, and sending keys.
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * ElementLocator elementLocator = webAutomationDriver.getElementLocator();
 * ElementInteraction elementInteraction = elementLocator.getWebPageElement(LocatorType.Id,"id").interact();
 *
 * elementInteraction.click(); // Simulates a mouse click on the element
 * elementInteraction.submit(); // Submits a form if the element is a form element
 * elementInteraction.sendKeys("text to send"); // Sends the specified keys to the element
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ElementInteraction
 */
@NonNull
@AllArgsConstructor
public final class ElementInteractionImpl implements ElementInteraction {

    private final WebElement element;

    /**
     * {@inheritDoc}
     */
    @Override
    public void click() {
        element.click();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void submit() {
        element.submit();
    }

    /**
     * {@inheritDoc}
     *
     * @param keysToSend The character sequences to be sent.
     */
    @Override
    public void sendKeys(final CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }
}
