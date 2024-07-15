package com.twozo.web.driver.service;

import org.openqa.selenium.Alert;

/**
 * <p>
 * Interacts with browser {@link Alert}.
 * </p>
 *
 * <p>
 * Provides methods to interact with browser alerts, such as dismissing, accepting, getting text,
 * and sending keys. Allows for flexible and standardized handling of alert interactions
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * AlertHandler alertHandler = webAutomationDriver.getTargetLocator().getAlertHandler();
 * alertHandler.dismiss();
 * alertHandler.accept();
 * String alertText = alertHandler.getText();
 * alertHandler.sendKeys("Some text");
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface AlertHandler {

    /**
     * <p>
     * Dismisses the {@link Alert}.
     * </p>
     */
    void dismiss();

    /**
     * <p>
     * Accepts the {@link Alert}.
     * </p>
     */
    void accept();

    /**
     * <p>
     * Retrieves the text from the {@link Alert}.
     * </p>
     *
     * @return A string representing the {@link Alert} text.
     */
    String getText();

    /**
     * <p>
     * Sends keys to the {@link Alert}.
     * </p>
     *
     * @param keys The text to be sent to the {@link Alert}.
     */
    void sendKeys(final String keys);
}
