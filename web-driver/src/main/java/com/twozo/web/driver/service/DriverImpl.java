package com.twozo.web.driver.service;

import com.twozo.commons.util.PropertyFileReader;
import com.twozo.web.driver.internal.web.automation.driver.WebAutomationDriverImpl;
import com.twozo.web.driver.model.BrowserType;
import com.twozo.web.driver.service.Driver;
import com.twozo.web.driver.service.WebAutomationDriver;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

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
 * Defines methods for obtaining {@link WebAutomationDriver}, which is responsible for browser
 * automation tasks.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see Driver
 */
@Value
@NonNull
@AllArgsConstructor
public class DriverImpl implements Driver {

    PropertyFileReader propertyFileReader;

    public DriverImpl() {
        this.propertyFileReader = PropertyFileReader.getInstance();
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WebAutomationDriver} for web automation.
     */
    @Override
    public WebAutomationDriver getWebAutomationDriver() {
        final BrowserType browserType = Objects.requireNonNull(BrowserType.valueOf(
                Objects.requireNonNull(propertyFileReader.getProperty()).getProperty("Browser").toUpperCase()));

        return new WebAutomationDriverImpl(getDriver(browserType));
    }

    /**
     * {@inheritDoc}
     *
     * @param browserType The type of browser for which the driver is to be created.
     * @return A {@link RemoteWebDriver}.
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
