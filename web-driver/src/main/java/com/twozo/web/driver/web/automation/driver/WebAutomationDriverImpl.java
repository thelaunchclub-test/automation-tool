package com.twozo.web.driver.web.automation.driver;

import com.twozo.web.driver.service.Driver;
import com.twozo.web.driver.service.PageInformationProvider;
import com.twozo.web.driver.service.WaitHandler;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.driver.service.WebNavigator;
import com.twozo.web.driver.service.WebTargetLocator;
import com.twozo.web.driver.service.WebWindow;
import com.twozo.web.driver.service.WindowInfoProvider;

import com.twozo.web.element.service.ElementFinder;

import lombok.NonNull;
import lombok.Value;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

    WebDriver driver;
    WebNavigator webNavigator;
    PageInformationProvider pageInformationProvider;
    WebTargetLocator webTargetLocator;
    WebWindow webWindow;
    WindowInfoProvider windowInfoProvider;
    WaitHandler waitHandler;
    TakesScreenshot takesScreenshots;
    ElementFinder elementFinder;
    Driver driverProvider;

    public WebAutomationDriverImpl(final WebDriver driver) {
        this.driver = driver;
        this.webNavigator = WebNavigator.getInstance(driver.navigate());
        this.pageInformationProvider = PageInformationProvider.getInstance(driver);
        this.elementFinder = ElementFinder.getInstance(driver);
        this.webTargetLocator = WebTargetLocator.getInstance(driver, driver.switchTo());
        this.webWindow = WebWindow.getInstance(driver.manage().window());
        this.windowInfoProvider = WindowInfoProvider.getInstance(driver);
        this.driverProvider = Driver.getInstance();
        this.waitHandler = WaitHandler.getInstance(driver.manage().timeouts());
        this.takesScreenshots = (TakesScreenshot) driver;
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

    /**
     * {@inheritDoc}
     *
     * @param outputType The target type into which to convert the screenshot.
     * @return A screenshot of the current page.
     */
    @Override
    public <X> X getScreenshotAs(final OutputType<X> outputType) {
        return takesScreenshots.getScreenshotAs(outputType);
    }
}