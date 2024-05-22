package com.web.driver.driver.service;

import com.web.driver.driver.impl.AlertHandlerImpl;

import org.openqa.selenium.Alert;

/**
 * <p>
 * Interacts with browser Alerts.
 * </p>
 *
 * <p>
 * Provides methods to interact with browser alerts,
 * such as dismissing, accepting, getting text, and sending keys.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface AlertHandler {

    /**
     * <p>
     * Retrieves {@link AlertHandler} based on the provided {@link Alert} object.
     * </p>
     *
     * @param alert The {@link Alert} to interact with.
     * @return An {@link AlertHandler} to interact with browser alerts.
     */
    static AlertHandler getInstance(final Alert alert) {
        return new AlertHandlerImpl(alert);
    }

    /**
     * <p>
     * Dismisses the alert.
     * </p>
     */
    void dismiss();

    /**
     * <p>
     * Accepts the alert.
     * </p>
     */
    void accept();

    /**
     * <p>
     * Retrieves the text from the alert.
     * </p>
     *
     * @return A string representing the alert text.
     */
    String getText();

    /**
     * <p>
     * Sends keys to the Alert.
     * </p>
     *
     * @param keys The text to be sent to the alert.
     */
    void sendKeys(final String keys);
}
