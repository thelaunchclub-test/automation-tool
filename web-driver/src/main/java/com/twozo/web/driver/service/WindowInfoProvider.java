package com.twozo.web.driver.service;

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
 */
public interface WindowInfoProvider {

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
     * Retrieves the handle of the currently focused web window.
     * </p>
     *
     * @return A {@link String} representing the current window.
     */
    String getWindowHandle();
}
