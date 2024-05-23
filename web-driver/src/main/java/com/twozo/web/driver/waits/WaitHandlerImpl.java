package com.twozo.web.driver.waits;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * <p>
 * The {@code WaitHandler} represents a wait handler for Selenium WebDriver.
 * </p>
 *
 * <p>
 * Provides methods to configure and manage waits in WebDriver. Allow setting
 * an implicit wait duration for WebDriver.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see WaitHandler
 */
public final class WaitHandlerImpl implements WaitHandler {

    private final WebDriver.Timeouts timeouts;

    public WaitHandlerImpl(final WebDriver.Timeouts timeouts) {
        this.timeouts = timeouts;
    }

    /**
     * {@inheritDoc}
     *
     * @param duration the duration of the implicit wait
     * @return a {@code WaitHandler} configured with the implicit wait duration
     */
    @Override
    public WaitHandler implicitlyWait(final Duration duration) {
        return getInstance(timeouts.implicitlyWait(duration));
    }
}
