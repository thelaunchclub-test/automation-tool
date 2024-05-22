package com.web.driver.page;

import org.openqa.selenium.WebDriver;

/**
 * Retrieves information about the browser.
 * <p>
 * Retrieve various information about the browser, such as the current URL, page title, and page source.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface PageInformationProvider {

    static PageInformationProvider getInstance(final WebDriver driver) {
        return new PageInformationProviderImpl(driver);
    }

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url The URL to getWebNavigator to.
     */
    void get(final String url);

    /**
     * Retrieves the current URL of the browser.
     *
     * @return A string representing the current URL.
     */
    String getCurrentUrl();

    /**
     * Retrieves the title of the current browser getWebWindowHandler.
     *
     * @return A string representing the getWebWindowHandler title.
     */
    String getTitle();

    /**
     * Retrieves the page source of the current browser getWebWindowHandler.
     *
     * @return A string representing the page source.
     */
    String getPageSource();
}
