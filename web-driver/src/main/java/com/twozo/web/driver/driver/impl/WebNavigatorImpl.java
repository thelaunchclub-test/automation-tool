package com.twozo.web.driver.driver.impl;

import com.twozo.web.driver.driver.service.WebNavigator;

import org.openqa.selenium.WebDriver.Navigation;

/**
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
 *</p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see WebNavigator
 */
public final class WebNavigatorImpl implements WebNavigator {

    private final Navigation navigation;

    public WebNavigatorImpl(final Navigation navigation) {
        this.navigation = navigation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void back() {
        navigation.back();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void forward() {
        navigation.forward();
    }

    /**
     * {@inheritDoc}
     *
     * @param url The URL to navigate to.
     */
    @Override
    public void to(final String url) {
        navigation.to(url);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() {
        navigation.refresh();
    }
}
