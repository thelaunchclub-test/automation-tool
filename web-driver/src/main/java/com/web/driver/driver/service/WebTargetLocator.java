package com.web.driver.driver.service;

import com.web.driver.driver.impl.WebTargetLocatorImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

/**
 * <p>
 * Targets different windows in the browser.
 * </p>
 *
 * <p>
 * Targets different windows in the browser, such as switching to a specific window by name,
 * opening a new window and handling browser alerts.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface WebTargetLocator {

    /**
     * <p>
     * Returns {@link WebTargetLocator} based on the provided {@link WebDriver}
     * and {@link WebDriver.TargetLocator}.
     *</p>
     *
     * @param driver The {@link WebDriver} to be used for web automation.
     * @param targetLocator The {@link WebDriver.TargetLocator}  to be used for
     *                      targeting elements in the web page.
     * @return A {@link WebTargetLocator} for targeting different windows in the browser.
     */
    static WebTargetLocator getInstance(final WebDriver driver, final WebDriver.TargetLocator targetLocator) {
        return new WebTargetLocatorImpl(driver, targetLocator);
    }

    /**
     * <p>
     * Switches to the browser window by its name.
     *</p>
     *
     * @param name The name of the target window.
     * @return A {@link com.web.driver.driver.service.WebAutomationDriver} representing the targeted window.
     */
    com.web.driver.driver.service.WebAutomationDriver getWindow(final String name);

    /**
     * <p>
     * Opens a new browser window of the specified type.
     *</p>
     *
     * @param windowType The type of the new window to be opened.
     * @return A {@link com.web.driver.driver.service.WebAutomationDriver} representing the new window.
     */
    WebAutomationDriver getNewWindow(final WindowType windowType);

    /**
     * <p>
     * Switches to the browser alert.
     *</p>
     *
     * @return A {@link AlertHandler} interact with browser alert.
     */
    AlertHandler getAlertHandler();
}
