package com.twozo.web.driver.page.information;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * The {@code PageInformationProvider} retrieves information about the browser.
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
 * @author Petchimuthu
 * @version 1.0
 */
public interface PageInformationProvider {

    static PageInformationProvider getInstance(final WebDriver driver) {
        return new PageInformationProviderImpl(driver);
    }

    /**
     * <p>
     * Navigates the browser to the specified URL.
     * </p>
     *
     * @param url The URL to getWebNavigator to.
     */
    void get(final String url);

    /**
     * <p>
     * Retrieves the current URL of the browser.
     * </p>
     *
     * @return A string representing the current URL.
     */
    String getCurrentUrl();

    /**
     * <p>
     * Retrieves the title of the current web page.
     * </p>
     *
     * @return A string representing the web page title.
     */
    String getTitle();

    /**
     * <p>
     * Retrieves the page source of the current browser.
     * </p>
     *
     * @return A string representing the page source.
     */
    String getPageSource();
}
