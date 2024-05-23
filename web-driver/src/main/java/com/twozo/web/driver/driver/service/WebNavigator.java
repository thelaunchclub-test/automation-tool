package com.twozo.web.driver.driver.service;

import com.twozo.web.driver.driver.impl.WebNavigatorImpl;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface WebNavigator {

    /**
     * <p>
     * Returns {@link WebNavigator} based on the provided {@link WebDriver.Navigation}.
     * </p>
     *
     * @param navigation The {@link WebDriver.Navigation} to be used for web navigation.
     * @return A {@link WebNavigator} for basic browser navigation.
     */
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
