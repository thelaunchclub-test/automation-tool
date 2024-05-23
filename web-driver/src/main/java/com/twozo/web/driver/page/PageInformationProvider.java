package com.twozo.web.driver.page;

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
 * @author petchimuthu
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
     * Retrieves the title of the current browser getWebWindowHandler.
     * </p>
     *
     * @return A string representing the getWebWindowHandler title.
     */
    String getTitle();

    /**
     * <p>
     * Retrieves the page source of the current browser getWebWindowHandler.
     * </p>
     *
     * @return A string representing the page source.
     */
    String getPageSource();
}
