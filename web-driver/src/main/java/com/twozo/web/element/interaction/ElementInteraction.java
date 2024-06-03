package com.twozo.web.element.interaction;

import com.twozo.web.element.web.page.element.WebPageElement;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code ElementInteraction} interacts with {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Encapsulates common interactions with {@link WebPageElement} such as clicking,
 * submitting forms, and sending keys.
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
