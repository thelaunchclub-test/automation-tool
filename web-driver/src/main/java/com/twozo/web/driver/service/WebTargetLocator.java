package com.twozo.web.driver.service;

import com.twozo.web.driver.target.locator.WebTargetLocatorImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
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
 * <p>
 * Example usage:
 * <pre>{@code
 * WebTargetLocator targetLocator = webAutomationDriver.getWebTargetLocator();
 * WebAutomationDriver window = targetLocator.getWindow("windowName");
 * WebAutomationDriver newWindow = targetLocator.getNewWindow(WindowType.TAB);
 * AlertHandler alertHandler = targetLocator.getAlertHandler();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebTargetLocator {

    static WebTargetLocator getInstance(final WebDriver driver, final TargetLocator targetLocator) {
        return new WebTargetLocatorImpl(driver, targetLocator);
    }

    /**
     * <p>
     * Switches to the browser window by its name.
     * </p>
     *
     * @param name The name of the target window.
     * @return A {@link WebAutomationDriver} representing the targeted window.
     */
    WebAutomationDriver getWindow(final String name);

    /**
     * <p>
     * Opens a new browser window of the specified type.
     * </p>
     *
     * @param windowType The type of the new window to be opened.
     * @return A {@link WebAutomationDriver} representing the new window.
     */
    WebAutomationDriver getNewWindow(final WindowType windowType);

    /**
     * <p>
     * Switches to the browser alert.
     * </p>
     *
     * @return A {@link AlertHandler} interact with browser alert.
     */
    AlertHandler getAlertHandler();
}
