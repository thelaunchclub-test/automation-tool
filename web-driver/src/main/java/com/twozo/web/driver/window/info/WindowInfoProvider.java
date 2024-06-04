package com.twozo.web.driver.window.info;

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
 *
 * // Get handles of all currently open windows
 * Set<String> windowHandles = windowInfoProvider.getWindowHandles();
 *
 * // Get the handle of the currently focused window
 * String currentWindowHandle = windowInfoProvider.getWindowHandle();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WindowInfoProvider {

    static WindowInfoProvider getInstance(final WebDriver driver) {
        return new WindowInfoProviderImpl(driver);
    }

    /**
     * <p>
     * Retrieves handles of all currently open windows.
     * </p>
     *
     * @return A {@link Set} of {@link String} representing all the windows.
     */
    Set<String> getWindowHandles();

    /**
     * <p>
     * Retrieves the handle of the currently focused getWebWindowHandler.
     * </p>
     *
     * @return A {@link String} representing the current window.
     */
    String getWindowHandle();
}
