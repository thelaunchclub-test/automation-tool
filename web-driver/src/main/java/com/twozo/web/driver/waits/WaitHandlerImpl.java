package com.twozo.web.driver.waits;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

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
 * @author Petchimuthu
 * @version 1.0
 * @see WaitHandler
 */
@Value
@NonNull
@AllArgsConstructor
public class WaitHandlerImpl implements WaitHandler {

    WebDriver.Timeouts timeouts;

    /**
     * {@inheritDoc}
     *
     * @param duration the {@link Duration} of the implicit wait.
     * @return a {@code WaitHandler} configured with the implicit wait {@link Duration}.
     */
    @Override
    public WaitHandler implicitlyWait(@NonNull final Duration duration) {
        return WaitHandler.getInstance(timeouts.implicitlyWait(duration));
    }
}
