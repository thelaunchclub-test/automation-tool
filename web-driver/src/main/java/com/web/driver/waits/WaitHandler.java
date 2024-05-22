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
public interface WaitHandler {

    /**
     * Gets an instance of WaitHandler.
     *
     * @param timeouts the timeouts for WebDriver
     * @return an instance of WaitHandler
     */
    static WaitHandler getInstance(final WebDriver.Timeouts timeouts) {
        return new WaitHandlerImpl(timeouts);
    }

    /**
     * Sets an implicit wait duration for the WebDriver.
     *
     * @param duration the duration of the implicit wait
     * @return a WaitHandler instance configured with the implicit wait duration
     */
    WaitHandler implicitlyWait(final Duration duration);
}
