package com.twozo.web.driver.service;

import org.openqa.selenium.WebDriver;

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

    /**
     * <p>
     * Sets an implicit wait {@link Duration} for the {@link WebDriver}.
     * </p>
     *
     * @param duration The {@link Duration} of the implicit wait.
     * @return An {@code ImplicitWaitHandler}.
     */
    ImplicitWaitHandler implicitWait(final Duration duration);
}
