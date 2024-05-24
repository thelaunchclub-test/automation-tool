package com.twozo.web.driver.navigation;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebDriver.Navigation;

/**
 * <p>
 * Allows basic browser navigation actions such as going back, forward, refreshing the page,
 * and navigating to a specific URL.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see WebNavigator
 */
@Value
@NonNull
@AllArgsConstructor
public class WebNavigatorImpl implements WebNavigator {

    Navigation navigation;

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
    public void to(@NonNull final String url) {
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