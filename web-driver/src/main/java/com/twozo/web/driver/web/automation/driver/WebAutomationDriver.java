package com.twozo.web.driver.web.automation.driver;

import com.twozo.web.driver.navigation.WebNavigator;
import com.twozo.web.driver.page.information.PageInformationProvider;
import com.twozo.web.driver.screenshot.TakesScreenshots;
import com.twozo.web.driver.target.locator.WebTargetLocator;
import com.twozo.web.driver.waits.WaitHandler;
import com.twozo.web.driver.window.WebWindow;
import com.twozo.web.driver.window.info.WindowInfoProvider;
import com.twozo.web.element.locator.ElementLocator;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * The {@code WebAutomationDriver} provides various interactions for web automation,
 * including navigation, element locating, window management, screenshot capturing, and more.
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
     * @return An {@link PageInformationProvider} for retrieving page information.
     */
    PageInformationProvider getPageInformationProvider();

    /**
     * <p>
     * Returns {@link ElementLocator} for finding web elements.
     * </p>
     *
     * @return An {@link ElementLocator} for finding web elements.
     */
    ElementLocator getElementLocator();

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
