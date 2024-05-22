package com.web.driver.driver.service;

import com.web.driver.driver.impl.WebAutomationDriverImpl;
import com.web.driver.element.finders.ElementFinder;
import com.web.driver.page.PageInformationProvider;
import com.web.driver.utilities.TakesScreenshots;
import com.web.driver.waits.WaitHandler;
import com.web.driver.window.WebWindow;
import com.web.driver.window.WindowInfoProvider;

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
 * @author petchimuthu1520
 * @version 1.0
 * @see TakesScreenshots
 */
public interface WebAutomationDriver extends TakesScreenshots {

    /**
     * Returns {@link WebAutomationDriver} based on the provided {@link WebDriver} object.
     *
     * @param driver The {@link WebDriver} to be used for web automation.
     * @return A {@link WebAutomationDriver} for web automation.
     */
    static WebAutomationDriver getInstance(final WebDriver driver) {
        return new WebAutomationDriverImpl(driver);
    }

    /**
     * Returns {@link WebNavigator} for various browser navigation actions.
     *
     * @return A {@link WebNavigator} for browser navigation.
     */
    WebNavigator getWebNavigator();

    /**
     * Returns {@link PageInformationProvider} to retrieve information about the current page of the browser.
     *
     * @return An {@link PageInformationProvider} for retrieving page information.
     */
    PageInformationProvider getPageInformationProvider();

    /**
     * Returns {@link ElementFinder} for finding web elements.
     *
     * @return An {@link ElementFinder} for finding web elements.
     */
    ElementFinder getElementFinder();

    /**
     * Returns {@link WebTargetLocator} for targeting to a specific window by name,
     * opening a new window
     *
     * @return A {@link WebTargetLocator} for targeting different window.
     */
    WebTargetLocator getWebTargetLocator();

    /**
     * Returns {@link WebWindow} for controlling browser web window actions.
     *
     * @return A {@link WebWindow} for controlling browser web window actions.
     */
    WebWindow getWebWindowHandler();

    /**
     * Returns {@link WindowInfoProvider} for retrieving information about the browser window.
     *
     * @return A {@link WindowInfoProvider} for retrieving information about the browser window.
     */
    WindowInfoProvider getWindowInfoProvider();

    /**
     * Returns {@link WaitHandler} for handling waits.
     *
     * @return A {@link WaitHandler} for handling waits.
     */
    WaitHandler getWaitHandler();

    /**
     * Closes the current browser getWebWindowHandler.
     */
    void close();

    /**
     * Quits the driver, closing all associated browser windows.
     */
    void quit();
}
