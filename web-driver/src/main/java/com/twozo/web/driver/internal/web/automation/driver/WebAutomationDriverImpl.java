package com.twozo.web.driver.internal.web.automation.driver;

import com.twozo.commons.util.PropertyFileReader;
import com.twozo.web.driver.internal.navigation.WebNavigatorImpl;
import com.twozo.web.driver.internal.page.information.PageInformationProviderImpl;
import com.twozo.web.driver.internal.screen.capturer.ScreenCapturerImpl;
import com.twozo.web.driver.internal.target.locator.WebTargetLocatorImpl;
import com.twozo.web.driver.internal.wait.WaitHandlerImpl;
import com.twozo.web.driver.internal.window.info.WindowInfoProviderImpl;
import com.twozo.web.driver.internal.window.state.WebWindowImpl;
import com.twozo.web.driver.model.BrowserType;
import com.twozo.web.driver.service.*;
import com.twozo.web.element.internal.finder.ElementFinderForDriver;
import com.twozo.web.element.service.ElementFinder;

import lombok.NonNull;
import lombok.Value;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

/**
 * <p>
 * Provides various interactions for web automation, including navigation, element locating,
 * window management, screenshot capturing, and more.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");
 * WebPageElement element = automationDriver.getElementFinder().getWebPageElement(LocatorType.ID,"name"));
 * element.click();
 * File screenshot = automationDriver.getScreenshotAs(OutputType.FILE);
 * WebWindow window = automationDriver.getWebWindowHandler();
 * window.maximize();
 * String pageTitle = automationDriver.getPageInformationProvider().getTitle();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see WebAutomationDriver
 */
@Value
@NonNull
@SuperBuilder
public class WebAutomationDriverImpl implements WebAutomationDriver {

    private static final PropertyFileReader PROPERTY_FILE_READER = PropertyFileReader.getInstance();

    WebDriver driver;
    WebNavigator webNavigator;
    PageInformationProvider pageInformationProvider;
    WebTargetLocator webTargetLocator;
    WebWindow webWindow;
    WindowInfoProvider windowInfoProvider;
    WaitHandler waitHandler;
    ScreenCapturer screenCapturer;
    ElementFinder elementFinder;

    public WebAutomationDriverImpl(final WebDriver driver) {
        this.driver = driver;
        this.webNavigator = new WebNavigatorImpl(driver.navigate());
        this.pageInformationProvider = new PageInformationProviderImpl(driver);
        this.elementFinder = new ElementFinderForDriver(driver);
        this.webTargetLocator = new WebTargetLocatorImpl(driver, driver.switchTo());
        this.webWindow = new WebWindowImpl(driver.manage().window());
        this.windowInfoProvider = new WindowInfoProviderImpl(driver);
        this.waitHandler = new WaitHandlerImpl(driver.manage().timeouts());
        this.screenCapturer = new ScreenCapturerImpl(driver);
    }

    public WebAutomationDriverImpl() {
        this.driver = getDriver(getBrowserType());
        this.webNavigator = new WebNavigatorImpl(driver.navigate());
        this.pageInformationProvider = new PageInformationProviderImpl(driver);
        this.elementFinder = new ElementFinderForDriver(driver);
        this.webTargetLocator = new WebTargetLocatorImpl(driver, driver.switchTo());
        this.webWindow = new WebWindowImpl(driver.manage().window());
        this.windowInfoProvider = new WindowInfoProviderImpl(driver);
        this.waitHandler = new WaitHandlerImpl(driver.manage().timeouts());
        this.screenCapturer = new ScreenCapturerImpl(driver);
    }

    private BrowserType getBrowserType() {
        return Objects.requireNonNull(BrowserType.valueOf(
                Objects.requireNonNull(PROPERTY_FILE_READER.getProperty()).getProperty("Browser").toUpperCase()));
    }

    private static RemoteWebDriver getDriver(final BrowserType browserType) {
        return switch (browserType) {
            case EDGE -> new EdgeDriver();
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
            case INTERNET_EXPLORER -> new InternetExplorerDriver();
        };
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WebNavigator} for browser navigation.
     */
    @Override
    public WebNavigator getWebNavigator() {
        return webNavigator;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link PageInformationProvider} for retrieving various information about the browser,
     * such as the current URL, page title, and page source.
     */
    @Override
    public PageInformationProvider getPageInformationProvider() {
        return pageInformationProvider;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ElementFinder} for finding web elements.
     */
    public ElementFinder getElementFinder() {
        return elementFinder;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WebTargetLocator} for targeting different windows in the browser,
     * such as switching to a specific window by name, opening a new window and handling
     * browser alerts.
     */
    @Override
    public WebTargetLocator getWebTargetLocator() {
        return webTargetLocator;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WebWindow} for interacts with the browser window,such as maximizing,
     * minimizing,and toggling fullscreen mode.
     */
    @Override
    public WebWindow getWebWindowHandler() {
        return webWindow;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WindowInfoProvider} for retrieving information about browser windows,
     * including unique identifiers for each window handle and the handle of the current window.
     */
    @Override
    public WindowInfoProvider getWindowInfoProvider() {
        return windowInfoProvider;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WaitHandler} for to configure and manage waits in {@link WebDriver}.
     */
    @Override
    public WaitHandler getWaitHandler() {
        return waitHandler;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link ScreenCapturer} for capturing the screen.
     */
    @Override
    public ScreenCapturer getScreenCapturer() {
        return screenCapturer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        driver.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void quit() {
        driver.quit();
    }


}
