package com.web.driver.waits;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * The {@code WaitHandler} represents a wait handler for Selenium WebDriver.
 * It provides methods to configure and manage waits in WebDriver.
 *
 * <p>Allow setting an implicit wait duration for WebDriver.</p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
final class WaitHandlerImpl implements WaitHandler {

    private final WebDriver.Timeouts timeouts;

    /**
     * Constructor for WaitHandlerImpl.
     *
     * @param timeouts the timeouts for WebDriver
     */
    WaitHandlerImpl(final WebDriver.Timeouts timeouts) {
        this.timeouts = timeouts;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitHandler implicitlyWait(final Duration duration) {
        return WaitHandler.getInstance(timeouts.implicitlyWait(duration));
    }
}
