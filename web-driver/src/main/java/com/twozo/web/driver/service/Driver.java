package com.twozo.web.driver.service;

import com.twozo.web.driver.DriverImpl;

/**
 * <p>
 * Represents a driver, which provides a {@link WebAutomationDriver}.
 * </p>
 *
 * <p>
 * Defines methods for obtaining {@link WebAutomationDriver}, which is responsible for browser
 * automation tasks.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface Driver {

    /**
     * <p>
     * Returns {@link Driver} for obtaining {@link WebAutomationDriver}.
     * </p>
     *
     * @return An {@link Driver} .
     */
    static Driver getInstance() {
        return new DriverImpl();
    }

    /**
     * <p>
     * Returns {@link WebAutomationDriver} for web automation.
     * </p>
     *
     * @return {@link WebAutomationDriver} for web automation.
     */
    WebAutomationDriver getWebAutomationDriver();
}