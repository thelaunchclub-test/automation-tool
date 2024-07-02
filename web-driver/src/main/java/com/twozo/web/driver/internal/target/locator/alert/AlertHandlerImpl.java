package com.twozo.web.driver.internal.target.locator.alert;

import com.twozo.web.driver.service.AlertHandler;

import lombok.AllArgsConstructor;
import lombok.NonNull;

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
 * @see AlertHandler
 */
@NonNull
@AllArgsConstructor
public class AlertHandlerImpl implements AlertHandler {

    private final Alert alert;

    /**
     * {@inheritDoc}
     */
    @Override
    public void dismiss() {
        alert.dismiss();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept() {
        alert.accept();
    }

    /**
     * {@inheritDoc}
     *
     * @return A string representing the {@link Alert} text.
     */
    @Override
    public String getText() {
        return alert.getText();
    }

    /**
     * {@inheritDoc}
     *
     * @param keys The text to be sent to the {@link Alert}.
     */
    @Override
    public void sendKeys(final String keys) {
        alert.sendKeys(keys);
    }
}
