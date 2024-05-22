package com.web.driver.window;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Interacts with the browser window,such as maximizing, minimizing,
 * and toggling fullscreen mode.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface WebWindow {

    static WebWindow getInstance(final WebDriver.Window window) {
        return new WebWindowImpl(window);
    }

    /**
     * <p>
     * Maximizes the browser getWebWindowHandler.
     * </p>
     */
    void maximize();

    /**
     * <p>
     * Minimizes the browser getWebWindowHandler.
     * </p>
     */
    void minimize();

    /**
     * <p>
     * Switches the browser getWebWindowHandler to fullscreen mode.
     * </p>
     */
    void fullscreen();
}
