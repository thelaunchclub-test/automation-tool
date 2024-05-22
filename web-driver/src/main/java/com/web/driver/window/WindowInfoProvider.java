package com.web.driver.window;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * <p>
 * Provides information about browser windows.
 * </p>
 *
 * <p>
 * Retrieves information about browser windows,
 * including unique identifiers for each window handle and the handle of the current window.
 * </p>
 *
 * @author petchimuthu
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
     * @return A set of strings representing getWebWindowHandler handles.
     */
    Set<String> getWindowHandles();

    /**
     * <p>
     * Retrieves the handle of the currently focused getWebWindowHandler.
     * </p>
     *
     * @return A string representing the getWebWindowHandler handle.
     */
    String getWindowHandle();
}
