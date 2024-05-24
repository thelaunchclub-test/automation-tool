package com.twozo.web.driver.target.locator;

import com.twozo.web.driver.alert.AlertHandler;
import com.twozo.web.driver.web.automation.driver.WebAutomationDriver;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

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
 * @see WebTargetLocator
 */
@Value
@NonNull
@AllArgsConstructor
public class WebTargetLocatorImpl implements WebTargetLocator {

    WebDriver driver;
    WebDriver.TargetLocator targetLocator;

    /**
     * {@inheritDoc}
     *
     * @param name The name of the target window.
     * @return A {@link WebAutomationDriver} representing the targeted window.
     */
    @Override
    public WebAutomationDriver getWindow(final String name) {
        return WebAutomationDriver.getInstance(targetLocator.window(name));
    }

    /**
     * {@inheritDoc}
     *
     * @param windowType The type of the new window to be opened.
     * @return A {@link WebAutomationDriver} representing the new window.
     */
    @Override
    public WebAutomationDriver getNewWindow(final WindowType windowType) {
        return WebAutomationDriver.getInstance(targetLocator.newWindow(windowType));
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link AlertHandler} to interact with browser alert.
     */
    @Override
    public AlertHandler getAlertHandler() {
        return AlertHandler.getInstance(driver.switchTo().alert());
    }
}
