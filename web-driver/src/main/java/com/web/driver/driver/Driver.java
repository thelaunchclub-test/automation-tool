package com.web.driver.driver;

import com.web.driver.driver.service.WebAutomationDriver;

/**
 * <p>
 * Represents a driver, which provides a {@link WebAutomationDriver}.
 * </p>
 *
 * <p>
 * Defines methods for obtaining {@link WebAutomationDriver},
 * which is responsible for browser automation tasks.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface Driver {

    /**
     * Returns {@link Driver} for obtaining {@link WebAutomationDriver}.
     *
     * @return An {@link Driver} .
     */
    static Driver getInstance() {
        return new DriverImpl();
    }

    /**
     * Returns {@link WebAutomationDriver} for web automation.
     *
     * @return {@link WebAutomationDriver} for web automation.
     */
    WebAutomationDriver getWebAutomationDriver();
}
