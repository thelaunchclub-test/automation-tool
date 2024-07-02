package com.twozo.web.driver.service;

import com.twozo.web.driver.internal.navigation.WebNavigatorImpl;

import org.openqa.selenium.WebDriver.Navigation;

/**
 * <p>
 * Navigates the web browser
 * </p>
 *
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * WebNavigator webNavigator = webAutomationDriver.getWebNavigator();
 * webNavigator.back();
 * webNavigator.forward();
 * webNavigator.to("https://www.example.com");
 * webNavigator.refresh();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebNavigator {

    /**
     * <p>
     * Navigates the browser back.
     * </p>
     */
    void back();

    /**
     * <p>
     * Navigates the browser forward.
     * </p>
     */
    void forward();

    /**
     * <p>
     * Navigates the browser to the specified URL.
     * </p>
     *
     * @param url The URL to navigate to.
     */
    void to(final String url);

    /**
     * <p>
     * Refreshes the current page in the browser.
     * </p>
     */
    void refresh();
}
