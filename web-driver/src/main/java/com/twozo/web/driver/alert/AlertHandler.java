package com.twozo.web.driver.alert;

import org.openqa.selenium.Alert;

/**
 * <p>
 * Interacts with browser {@link Alert}.
 * </p>
 *
 * <p>
 * Provides methods to interact with browser alerts,
 * such as dismissing, accepting, getting text, and sending keys.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface AlertHandler {

    static AlertHandler getInstance(final Alert alert) {
        return new AlertHandlerImpl(alert);
    }

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
