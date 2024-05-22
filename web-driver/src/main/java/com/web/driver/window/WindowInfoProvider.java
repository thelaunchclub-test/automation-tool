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
public interface WindowInfoProvider {

    static WindowInfoProvider getInstance(final WebDriver driver) {
        return new WindowInfoProviderImpl(driver);
    }

    /**
     * Retrieves handles of all currently open windows.
     *
     * @return A set of strings representing getWebWindowHandler handles.
     */
    Set<String> getWindowHandles();

    /**
     * Retrieves the handle of the currently focused getWebWindowHandler.
     *
     * @return A string representing the getWebWindowHandler handle.
     */
    String getWindowHandle();
}
