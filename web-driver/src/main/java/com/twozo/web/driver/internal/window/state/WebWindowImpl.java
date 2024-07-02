package com.twozo.web.driver.internal.window.state;

import com.twozo.web.driver.service.WebWindow;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver.Window;


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
 * @see WebWindow
 */
@NonNull
@AllArgsConstructor
public final class WebWindowImpl implements WebWindow {

    private final Window window;

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
