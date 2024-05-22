package com.web.driver.driver.service;

import com.web.driver.driver.impl.WebNavigatorImpl;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface WebNavigator {

    /**
     * Returns {@link WebNavigator} based on the provided {@link WebDriver.Navigation}.
     *
     * @param navigation The {@link WebDriver.Navigation} to be used for web navigation.
     * @return A {@link WebNavigator} for basic browser navigation.
     */
    static WebNavigator getInstance(final WebDriver.Navigation navigation) {
        return new WebNavigatorImpl(navigation);
    }

    /**
     * Navigates the browser back.
     */
    void back();

    /**
     * Navigates the browser forward.
     */
    void forward();

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    void to(final String url);

    /**
     * Refreshes the current page in the browser.
     */
    void refresh();
}
