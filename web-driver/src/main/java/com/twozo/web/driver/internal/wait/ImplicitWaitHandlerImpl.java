package com.twozo.web.driver.internal.wait;

import com.twozo.web.driver.service.ImplicitWaitHandler;
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
 * ImplicitWaitHandler waitHandler = webAutomationDriver.getImplicitWaitHandler();
 * waitHandler.implicitWait(Duration.ofSeconds(10));
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ImplicitWaitHandler
 */
@NonNull
@AllArgsConstructor
public final class ImplicitWaitHandlerImpl implements ImplicitWaitHandler {

    private final Timeouts timeouts;

    /**
     * {@inheritDoc}
     *
     * @param duration The {@link Duration} of the implicit wait.
     * @return An {@code ImplicitWaitHandler} configured with the implicit wait {@link Duration}.
     */
    @Override
    public ImplicitWaitHandler implicitWait(final Duration duration) {
        return new ImplicitWaitHandlerImpl(timeouts.implicitlyWait(duration));
    }
}
