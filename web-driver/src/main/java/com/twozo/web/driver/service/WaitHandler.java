package com.twozo.web.driver.service;

import com.twozo.web.driver.waits.WaitHandlerImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

import java.time.Duration;

/**
 * <p>
 * Provides methods to manage waits. Allow setting an implicit wait {@link Duration} for {@link WebAutomationDriver}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * WaitHandler waitHandler = webAutomationDriver.getWaitHandler();
 * waitHandler.implicitWait(Duration.ofSeconds(10));
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WaitHandler {

    static WaitHandler getInstance(final Timeouts timeouts) {
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
    WaitHandler implicitWait(final Duration duration);
}
