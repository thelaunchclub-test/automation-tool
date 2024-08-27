package com.twozo.web.element.service;

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
 * ElementFinder elementFinder = webAutomationDriver.getElementFinder();
 * ElementInteraction elementInteraction = elementFinder.getWebPageElement(LocatorType.Id,"id").interact();
 * elementInteraction.click();
 * elementInteraction.submit();
 * elementInteraction.sendKeys("text to send");
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ElementInteraction {

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

    /**
     * <p>
     * Clears the text from the {@link WebElement}.
     * </p>
     */
    void clear();

    boolean isSelected();
}
