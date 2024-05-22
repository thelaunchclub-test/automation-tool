package com.web.driver.waits;

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
 */
public interface WaitHandler {

    /**
     * <p>
     * Returns a {@code WaitHandler} to handle wait for {@link WebDriver}.
     * </p>
     *
     * @param timeouts the timeouts for {@link WebDriver}
     * @return a {@code WaitHandler} to handle wait for {@link WebDriver}
     */
    static WaitHandler getInstance(final WebDriver.Timeouts timeouts) {
        return new com.web.driver.waits.WaitHandlerImpl(timeouts);
    }

    /**
     * <p>
     * Sets an implicit wait duration for the WebDriver.
     * </p>
     *
     * @param duration the duration of the implicit wait
     * @return a {@code WaitHandler} configured with the implicit wait duration
     */
    WaitHandler implicitlyWait(final Duration duration);
}
