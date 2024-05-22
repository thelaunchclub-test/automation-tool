package com.web.driver.driver;

import com.twozo.commons.util.PropertyFileReader;
import com.web.driver.driver.service.WebAutomationDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

/**
 * <p>
 * Represents a driver, which provides a {@link WebAutomationDriver}.
 * </p>
 *
 * <p>
 * Defines methods for obtaining {@link WebAutomationDriver},
 * which is responsible for browser automation tasks.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 * @see Driver
 */
final class DriverImpl implements Driver {

    private final PropertyFileReader propertyFileReader;

    DriverImpl() {
        this.propertyFileReader = PropertyFileReader.getInstance();
    }

    /**
     * {@inheritDoc}
     *
     * @return A WebAutomationDriver instance.
     */
    @Override
    public WebAutomationDriver getWebAutomationDriver() {
        final BrowserType browserType = Objects.requireNonNull(BrowserType.valueOf(
                Objects.requireNonNull(propertyFileReader.getProperty()).getProperty("Browser").toUpperCase()));

        return WebAutomationDriver.getInstance(getDriver(browserType));
    }

    /**
     * {@inheritDoc}
     *
     * @param browserType The type of browser for which the driver is to be created.
     * @return {@link RemoteWebDriver}
     */
    private RemoteWebDriver getDriver(final BrowserType browserType) {
        return switch (browserType) {
            case EDGE -> new EdgeDriver();
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
            case INTERNET_EXPLORER -> new InternetExplorerDriver();
        };
    }
}
