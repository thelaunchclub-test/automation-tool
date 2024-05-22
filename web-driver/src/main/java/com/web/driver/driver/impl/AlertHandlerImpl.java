package com.web.driver.driver.impl;

import com.web.driver.driver.service.AlertHandler;

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
public final class AlertHandlerImpl implements AlertHandler {

    private final Alert alert;

    public AlertHandlerImpl(final Alert alert) {
        this.alert = alert;
    }

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
     * @return A string representing the alert text.
     */
    @Override
    public String getText() {
        return alert.getText();
    }

    /**
     * {@inheritDoc}
     *
     * @param keys The text to be sent to the alert.
     */
    @Override
    public void sendKeys(final String keys) {
        alert.sendKeys(keys);
    }
}
