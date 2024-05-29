package com.twozo.web.driver.window;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Interacts with the browser window,such as maximizing, minimizing,
 * and toggling fullscreen mode.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebWindow {

    static WebWindow getInstance(final WebDriver.Window window) {
        return new WebWindowImpl(window);
    }

    /**
     * <p>
     * Maximizes the browser window.
     * </p>
     */
    void maximize();

    /**
     * <p>
     * Minimizes the browser window.
     * </p>
     */
    void minimize();

    /**
     * <p>
     * Switches the browser window to fullscreen mode.
     * </p>
     */
    void fullscreen();
}
