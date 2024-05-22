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
final class WebWindowImpl implements WebWindow {

    private final WebDriver.Window window;

    WebWindowImpl(final WebDriver.Window window) {
        this.window = window;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void maximize() {
        window.maximize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void minimize() {
        window.minimize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fullscreen() {
        window.fullscreen();
    }
}
