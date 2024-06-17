package com.twozo.web.driver.service;

import com.twozo.web.driver.screenshot.TakesScreenshots;
import com.twozo.web.driver.web.automation.driver.WebAutomationDriverImpl;
import com.twozo.web.element.service.ElementFinder;

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
 * @see TakesScreenshots
 */
public interface WebAutomationDriver extends TakesScreenshots {

    static WebAutomationDriver getInstance(final WebDriver driver) {
        return new WebAutomationDriverImpl(driver);
    }

    /**
     * <p>
     * Returns {@link WebNavigator} for various browser navigation actions.
     * </p>
     *
     * @return A {@link WebNavigator} for browser navigation.
     */
    WebNavigator getWebNavigator();

    /**
     * <p>
     * Returns {@link PageInformationProvider} to retrieve information about the current page of the browser.
     * </p>
     *
     * @return A {@link PageInformationProvider} for retrieving page information.
     */
    PageInformationProvider getPageInformationProvider();

    /**
     * <p>
     * Returns {@link ElementFinder} for finding web elements.
     * </p>
     *
     * @return An {@link ElementFinder} for finding web elements.
     */
    ElementFinder getElementFinder();

    /**
     * <p>
     * Returns {@link WebTargetLocator} for targeting to a specific window by name,
     * opening a new window.
     * </p>
     *
     * @return A {@link WebTargetLocator} for targeting different window.
     */
    WebTargetLocator getWebTargetLocator();

    /**
     * <p>
     * Returns {@link WebWindow} for controlling browser web window actions.
     * </p>
     *
     * @return A {@link WebWindow} for controlling browser web window actions.
     */
    WebWindow getWebWindowHandler();

    /**
     * <p>
     * Returns {@link WindowInfoProvider} for retrieving information about the browser window.
     * </p>
     *
     * @return A {@link WindowInfoProvider} for retrieving information about the browser window.
     */
    WindowInfoProvider getWindowInfoProvider();

    /**
     * <p>
     * Returns {@link WaitHandler} for handling waits.
     * </p>
     *
     * @return A {@link WaitHandler} for handling waits.
     */
    WaitHandler getWaitHandler();

    /**
     * <p>
     * Closes the current browser.
     * </p>
     */
    void close();

    /**
     * <p>
     * Quits the driver, closing all associated browser windows.
     * </p>
     */
    void quit();
}
