package com.twozo.web.driver.service;

/**
 * <p>
 * Interacts with the browser window,such as maximizing, minimizing,
 * and toggling fullscreen mode.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * WebWindow webWindow = webAutomationDriver.getWebWindow();
 * webWindow.maximize();
 * webWindow.minimize();
 * webWindow.fullscreen();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebWindow {

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
