package com.web.driver.window;

import org.openqa.selenium.WebDriver;

/**
 * Interacts with the browser window.
 * <p>
 * Interacts with the browser window,such as maximizing,
 * minimizing, and toggling fullscreen mode.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface WebWindow {

    static WebWindow getInstance(final WebDriver.Window window) {
        return new WebWindowImpl(window);
    }

    /**
     * Maximizes the browser getWebWindowHandler.
     */
    void maximize();

    /**
     * Minimizes the browser getWebWindowHandler.
     */
    void minimize();

    /**
     * Switches the browser getWebWindowHandler to fullscreen mode.
     */
    void fullscreen();
}
