package com.twozo.web.element.interaction;

import com.twozo.web.element.web.page.element.WebPageElement;

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
 */
public interface ElementInteraction {

    static ElementInteraction getInstance(final WebElement element) {
        return new ElementInteractionImpl(element);
    }

    /**
     * <p>
     * Simulates a mouse click on the WebElement.
     * </p>
     */
    void click();

    /**
     * </p>
     * Submits a form if the {@link WebElement} represents a form element.
     * </p>
     */
    void submit();

    /**
     * <p>
     * Sends the given keys to the {@link WebElement}, usually a form input element.
     * </p>
     *
     * @param keysToSend The character sequences to be sent.
     */
    void sendKeys(final CharSequence... keysToSend);
}
