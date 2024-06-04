package com.twozo.web.driver.waits;

import com.twozo.web.driver.web.automation.driver.WebAutomationDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * <p>
 * Provides methods to configure and manage waits. Allow setting an implicit wait
 * {@link Duration} for {@link WebAutomationDriver}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * // Create a WaitHandler instance
 * WaitHandler waitHandler = webAutomationDriver.getWaitHandler();
 *
 * // Set an implicit wait duration of 10 seconds
 * waitHandler.implicitlyWait(Duration.ofSeconds(10));
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
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
