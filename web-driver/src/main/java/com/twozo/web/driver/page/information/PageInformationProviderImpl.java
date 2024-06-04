package com.twozo.web.driver.page.information;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Retrieves information about the browser.
 * </p>
 *
 * <p>
 * Retrieve various information about the browser, such as the current URL, page title, and page source.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * // Instantiate a PageInformationProvider using the WebAutomationDriver.
 * PageInformationProvider pageInformationProvider = webAutomationDriver.getPageInformationProvider();
 *
 * // Navigate to a specific URL
 * pageInformationProvider.get("https://www.example.com");
 *
 * // Get the current URL
 * String currentUrl = pageInformationProvider.getCurrentUrl();
 * System.out.println("Current URL: " + currentUrl);
 *
 * // Get the title of the current web page
 * String pageTitle = pageInformationProvider.getTitle();
 * System.out.println("Page Title: " + pageTitle);
 *
 * // Get the page source
 * String pageSource = pageInformationProvider.getPageSource();
 * System.out.println("Page Source: " + pageSource);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see PageInformationProvider
 */
@NonNull
@AllArgsConstructor
public final class PageInformationProviderImpl implements PageInformationProvider {

    private final WebDriver driver;

    /**
     * {@inheritDoc}
     *
     * @param url The URL to navigate to.
     */
    @Override
    public void get(final String url) {
        driver.get(url);
    }

    /**
     * {@inheritDoc}
     *
     * @return The current URL of the browser.
     */
    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * {@inheritDoc}
     *
     * @return The title of the current page.
     */
    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * {@inheritDoc}
     *
     * @return The source code of the current page.
     */
    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }
}
