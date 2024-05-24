package com.twozo.web.driver.alert;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

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
 * @author petchimuthu
 * @version 1.0
 * @see AlertHandler
 */
@Value
@NonNull
@AllArgsConstructor
public class AlertHandlerImpl implements AlertHandler {

    Alert alert;

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
