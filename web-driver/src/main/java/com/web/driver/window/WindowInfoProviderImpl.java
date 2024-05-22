package com.web.driver.window;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Provides information about browser windows.
 * <p>
 * Retrieves information about browser windows,
 * including unique identifiers for each window handle and the handle of the current window.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
final class WindowInfoProviderImpl implements WindowInfoProvider {

    private final WebDriver driver;

    WindowInfoProviderImpl(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * {@inheritDoc}
     *
     * @return A set of getWebWindowHandler handles for multiple browser windows.
     */
    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * {@inheritDoc}
     *
     * @return The handle of the current browser getWebWindowHandler.
     */
    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
}
