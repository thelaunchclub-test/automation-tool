package com.twozo.web.driver.driver.impl;

import com.twozo.web.driver.driver.service.WebAutomationDriver;
import com.twozo.web.driver.driver.service.WebNavigator;
import com.twozo.web.driver.driver.service.WebTargetLocator;
import com.twozo.web.driver.element.finders.ElementFinder;
import com.twozo.web.driver.driver.Driver;
import com.twozo.web.driver.page.PageInformationProvider;
import com.twozo.web.driver.waits.WaitHandler;
import com.twozo.web.driver.window.WebWindow;
import com.twozo.web.driver.window.WindowInfoProvider;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * <p>
 * Represents a web automation driver with various interactions.
 * </p>
 *
 * <p>
 * Provides various interactions for web automation, including navigation, element locating,
 * window management, screenshot capturing, and more.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see WebAutomationDriver
 */
public final class WebAutomationDriverImpl implements WebAutomationDriver {

    private final WebDriver driver;
    private final WebNavigator webNavigator;
    private final PageInformationProvider pageInformationProvider;
    private final WebTargetLocator webTargetLocator;
    private final WebWindow webWindow;
    private final WindowInfoProvider windowInfoProvider;
    private final WaitHandler waitHandler;
    private final TakesScreenshot takesScreenshots;
    private final ElementFinder elementFinder;
    private final Driver driverProvider;

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
    @Override
    public ElementFinder getElementFinder() {
        return ElementFinder.getInstance(driver);
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
     * @return A {@link WaitHandler} for handling waits.
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
     * @param target The target type into which to convert the screenshot.
     * @return A screenshot of the current page.
     */
    @Override
    public <X> X getScreenshotAs(final OutputType<X> target) {
        return takesScreenshots.getScreenshotAs(target);
    }
}
