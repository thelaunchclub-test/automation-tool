package com.twozo.web.driver.window.info;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * <p>
 * The {@code WindowInfoProviderImpl} provides information about browser windows.
 * </p>
 *
 * <p>
 * Retrieves information about browser windows,
 * including unique identifiers for each window handle and the handle of the current window.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
@AllArgsConstructor
public class WindowInfoProviderImpl implements WindowInfoProvider {

    WebDriver driver;

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
