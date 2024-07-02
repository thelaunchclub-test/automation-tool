package com.twozo.web.driver.internal.page.information;

import com.twozo.web.driver.service.PageInformationProvider;

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
