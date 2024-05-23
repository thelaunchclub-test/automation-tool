package com.twozo.web.driver.driver.service;

import com.twozo.web.driver.element.finders.ElementFinder;
import com.twozo.web.driver.driver.impl.WebAutomationDriverImpl;
import com.twozo.web.driver.page.PageInformationProvider;
import com.twozo.web.driver.utilities.TakesScreenshots;
import com.twozo.web.driver.waits.WaitHandler;
import com.twozo.web.driver.window.WebWindow;
import com.twozo.web.driver.window.WindowInfoProvider;

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
 * @see TakesScreenshots
 */
public interface WebAutomationDriver extends TakesScreenshots {

    /**
     * <p>
     * Returns {@link WebAutomationDriver} based on the provided {@link WebDriver} object.
     * </p>
     *
     * @param driver The {@link WebDriver} to be used for web automation.
     * @return A {@link WebAutomationDriver} for web automation.
     */
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
     * @return An {@link PageInformationProvider} for retrieving page information.
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
     * opening a new window
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
     * Closes the current browser getWebWindowHandler.
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
