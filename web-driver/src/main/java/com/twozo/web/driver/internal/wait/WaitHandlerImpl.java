package com.twozo.web.driver.internal.wait;

import com.twozo.web.driver.service.WaitHandler;
import com.twozo.web.driver.service.WebAutomationDriver;

import lombok.AllArgsConstructor;
import lombok.NonNull;

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
 * @see WaitHandler
 */
@NonNull
@AllArgsConstructor
public final class WaitHandlerImpl implements WaitHandler {

    private final Timeouts timeouts;

    /**
     * {@inheritDoc}
     *
     * @param duration The {@link Duration} of the implicit wait.
     * @return An {@code WaitHandler} configured with the implicit wait {@link Duration}.
     */
    @Override
    public WaitHandler implicitWait(final Duration duration) {
        return new WaitHandlerImpl(timeouts.implicitlyWait(duration));
    }
}
