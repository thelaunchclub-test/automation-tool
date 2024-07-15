package com.twozo.web.driver.internal.window.info;

import com.twozo.web.driver.service.WindowInfoProvider;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * <p>
 * Retrieves information about browser windows, including unique identifiers for each window handle
 * and the handle of the current window.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * WindowInfoProvider windowInfoProvider = webAutomationDriver.getWindowInfoProvider();
 * Set<String> windowHandles = windowInfoProvider.getWindowHandles();
 * String currentWindowHandle = windowInfoProvider.getWindowHandle();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see WindowInfoProvider
 */
@NonNull
@AllArgsConstructor
public final class WindowInfoProviderImpl implements WindowInfoProvider {

    private final WebDriver driver;

    /**
     * {@inheritDoc}
     *
     * @return A {@link Set} of {@link String} representing all the windows.
     */
    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link String} representing the current window.
     */
    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
}
