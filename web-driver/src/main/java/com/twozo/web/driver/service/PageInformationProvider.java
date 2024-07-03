package com.twozo.web.driver.service;

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
 * PageInformationProvider pageInformationProvider = webAutomationDriver.getPageInformationProvider();
 * pageInformationProvider.get("https://www.example.com");
 * String currentUrl = pageInformationProvider.getCurrentUrl();
 * System.out.println("Current URL: " + currentUrl);
 * String pageTitle = pageInformationProvider.getTitle();
 * String pageSource = pageInformationProvider.getPageSource();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface PageInformationProvider {

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
