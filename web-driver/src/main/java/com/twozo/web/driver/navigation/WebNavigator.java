package com.twozo.web.driver.navigation;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * The {@code WebNavigator} navigates the web browser
 * </p>
 *
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
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
