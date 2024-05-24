package com.twozo.web.driver.waits;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * <p>
 * The {@code WaitHandler} represents a wait handler for Selenium WebDriver.
 * </p>
 *
 * <p>
 * Provides methods to configure and manage waits in {@link WebDriver}. Allow setting
 * an implicit wait {@link Duration} for {@link WebDriver}.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface WaitHandler {

    static WaitHandler getInstance(final WebDriver.Timeouts timeouts) {
        return new WaitHandlerImpl(timeouts);
    }

    /**
     * <p>
     * Sets an implicit wait {@link Duration} for the {@link WebDriver}.
     * </p>
     *
     * @param duration the {@link Duration} of the implicit wait.
     * @return a {@code WaitHandler} configured with the implicit wait {@link Duration}.
     */
    WaitHandler implicitlyWait(final Duration duration);
}
