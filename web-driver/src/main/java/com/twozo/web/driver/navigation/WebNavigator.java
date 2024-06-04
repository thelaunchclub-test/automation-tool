package com.twozo.web.driver.navigation;

import org.openqa.selenium.WebDriver;

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
 * // Instantiate a WebNavigator using the WebAutomationDriver.
 * WebNavigator webNavigator = webAutomationDriver.getWebNavigator();
 *
 * // Navigate back to the previous page
 * webNavigator.back();
 *
 * // Navigate forward to the next page
 * webNavigator.forward();
 *
 * // Navigate to a specific URL
 * webNavigator.to("https://www.example.com");
 *
 * // Refresh the current page
 * webNavigator.refresh();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface WebNavigator {

    static WebNavigator getInstance(final WebDriver.Navigation navigation) {
        return new WebNavigatorImpl(navigation);
    }

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
