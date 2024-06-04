package com.twozo.web.driver.navigation;

import lombok.AllArgsConstructor;
import lombok.NonNull;

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
 * @see WebNavigator
 */
@NonNull
@AllArgsConstructor
public final class WebNavigatorImpl implements WebNavigator {

    private final Navigation navigation;

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
