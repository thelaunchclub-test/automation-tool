package com.web.driver.element.service;

import com.web.driver.element.impl.InteractionImpl;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code Interaction} Interacts with {@link WebPageElement}s using Selenium WebDriver.
 * </p>
 *
 * <p>
 * Encapsulates common interactions with web page elements such as clicking,
 * submitting forms, and sending keys.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface Interaction {

    static Interaction getInstance(final WebElement element) {
        return new InteractionImpl(element);
    }

    /**
     * <p>
     * Simulates a mouse click on the WebElement.
     * </p>
     */
    void click();

    /**
     * </p>
     * Submits a form if the WebElement represents a form element.
     * </p>
     */
    void submit();

    /**
     * <p>
     * Sends the given keys to the WebElement, usually a form input element.
     * </p>
     *
     * @param keysToSend The character sequences to be sent.
     */
    void sendKeys(final CharSequence... keysToSend);
}
