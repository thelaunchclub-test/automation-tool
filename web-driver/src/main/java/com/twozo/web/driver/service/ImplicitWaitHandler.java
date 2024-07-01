package com.twozo.web.driver.service;

import com.twozo.web.driver.waits.ImplicitWaitHandlerImpl;

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
 * ImplicitWaitHandler waitHandler = webAutomationDriver.getImplicitWaitHandler();
 * waitHandler.implicitWait(Duration.ofSeconds(10));
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ImplicitWaitHandler {

    static ImplicitWaitHandler getInstance(final Timeouts timeouts) {
        return new ImplicitWaitHandlerImpl(timeouts);
    }

    /**
     * <p>
     * Sets an implicit wait {@link Duration} for the {@link WebDriver}.
     * </p>
     *
     * @param duration The {@link Duration} of the implicit wait.
     * @return A {@code ImplicitWaitHandler} configured with the implicit wait {@link Duration}.
     */
    ImplicitWaitHandler implicitWait(final Duration duration);

}
