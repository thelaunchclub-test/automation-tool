package com.twozo.web.driver.internal.web.automation.driver;

import com.twozo.commons.util.ConfigFileReader;
import com.twozo.web.driver.internal.navigation.WebNavigatorImpl;
import com.twozo.web.driver.internal.page.information.PageInformationProviderImpl;
import com.twozo.web.driver.internal.screen.capturer.ScreenCapturerImpl;
import com.twozo.web.driver.internal.session.cookie.SessionCookieImpl;
import com.twozo.web.driver.internal.target.locator.WebTargetLocatorImpl;
import com.twozo.web.driver.internal.wait.ExplicitWaitHandlerImpl;
import com.twozo.web.driver.internal.wait.ImplicitWaitHandlerImpl;
import com.twozo.web.driver.internal.window.info.WindowInfoProviderImpl;
import com.twozo.web.driver.internal.window.state.WebWindowImpl;
import com.twozo.web.driver.model.BrowserType;
import com.twozo.web.driver.service.*;
import com.twozo.web.element.internal.finder.ElementFinderForDriver;
import com.twozo.web.element.service.ElementFinder;

import com.twozo.web.mouse.internal.actions.MouseActionsImpl;
import com.twozo.web.mouse.service.actions.MouseActions;

import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Map;
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
public class WebAutomationDriverImpl implements WebAutomationDriver {

    private static final Map<String, String> map = ConfigFileReader.get("Config.Properties");

    WebDriver driver;
    WebNavigator webNavigator;
    PageInformationProvider pageInformationProvider;
    WebTargetLocator webTargetLocator;
    WebWindow webWindow;
    WindowInfoProvider windowInfoProvider;
    ImplicitWaitHandler implicitWaitHandler;
    ExplicitWaitHandler explicitWaitHandler;
    ScreenCapturer screenCapturer;
    SessionCookie sessionCookie;
    MouseActions mouseActions;
    ElementFinder elementFinder;

    public WebAutomationDriverImpl(@NonNull final WebDriver driver) {
        this.driver = driver;
        this.webNavigator = new WebNavigatorImpl(driver.navigate());
        this.pageInformationProvider = new PageInformationProviderImpl(driver);
        this.elementFinder = new ElementFinderForDriver(driver);
        this.webTargetLocator = new WebTargetLocatorImpl(driver, driver.switchTo());
        this.webWindow = new WebWindowImpl(driver.manage().window());
        this.windowInfoProvider = new WindowInfoProviderImpl(driver);
        this.implicitWaitHandler = new ImplicitWaitHandlerImpl(driver.manage().timeouts());
        this.explicitWaitHandler = new ExplicitWaitHandlerImpl(driver);
        this.screenCapturer = new ScreenCapturerImpl(driver);
        this.sessionCookie = new SessionCookieImpl(driver.manage());
        this.mouseActions = new MouseActionsImpl(driver, new Actions(driver));
    }

    public WebAutomationDriverImpl() {
        this.driver = getDriver(getBrowserType());
        this.webNavigator = new WebNavigatorImpl(driver.navigate());
        this.pageInformationProvider = new PageInformationProviderImpl(driver);
        this.elementFinder = new ElementFinderForDriver(driver);
        this.webTargetLocator = new WebTargetLocatorImpl(driver, driver.switchTo());
        this.webWindow = new WebWindowImpl(driver.manage().window());
        this.windowInfoProvider = new WindowInfoProviderImpl(driver);
        this.implicitWaitHandler = new ImplicitWaitHandlerImpl(driver.manage().timeouts());
        this.explicitWaitHandler = new ExplicitWaitHandlerImpl(driver);
        this.screenCapturer = new ScreenCapturerImpl(driver);
        this.sessionCookie = new SessionCookieImpl(driver.manage());
        this.mouseActions = new MouseActionsImpl(driver, new Actions(driver));
    }

    private static RemoteWebDriver getDriver(@NonNull final BrowserType browserType) {
        return switch (browserType) {
            case EDGE -> new EdgeDriver();
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
            case INTERNET_EXPLORER -> new InternetExplorerDriver();
        };
    }

    private BrowserType getBrowserType() {
        return Objects.requireNonNull(BrowserType.valueOf(
                Objects.requireNonNull(map.get("Browser").toUpperCase())));
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
     * @return A {@link PageInformationProvider} for retrieving page information.
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
     * @return A {@link WebTargetLocator} for targeting different window.
     */
    @Override
    public WebTargetLocator getWebTargetLocator() {
        return webTargetLocator;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WebWindow} for controlling browser web window actions.
     */
    @Override
    public WebWindow getWebWindowHandler() {
        return webWindow;
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link WindowInfoProvider} for retrieving information about the browser window.
     */
    @Override
    public WindowInfoProvider getWindowInfoProvider() {
        return windowInfoProvider;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ImplicitWaitHandler} for implicit waits.
     */
    @Override
    public ImplicitWaitHandler getImplicitWaitHandler() {
        return implicitWaitHandler;
    }

    /**
     * {@inheritDoc}
     *
     * @return An {@link ExplicitWaitHandler} for explicit waits.
     */
    @Override
    public ExplicitWaitHandler getExplicitWaitHandler() {
        return explicitWaitHandler;
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
     *
     * @return A {@link SessionCookie} for handling cookies within the session.
     */
    @Override
    public SessionCookie getSessionCookie() {
        return sessionCookie;
    }

    /**
     * <p>
     * Returns {@link ScreenCapturer} for capturing the screen.
     * </p>
     *
     * @return A {@link ScreenCapturer} for capturing the screen.
     */
    @Override
    public MouseActions getMouseActionsHandler() {
        return mouseActions;
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
