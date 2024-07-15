package com.twozo.web.driver.service;

import com.twozo.web.driver.internal.web.automation.driver.WebAutomationDriverImpl;
import com.twozo.web.element.service.ElementFinder;
import com.twozo.web.mouse.service.actions.MouseActions;

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
 * @version 1.0
 */
public interface WebAutomationDriver {

    static WebAutomationDriver get() {
        return new WebAutomationDriverImpl();
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
     * Returns {@link ImplicitWaitHandler} for implicit waits.
     * </p>
     *
     * @return An {@link ImplicitWaitHandler} for implicit waits.
     */
    ImplicitWaitHandler getImplicitWaitHandler();

    /**
     * <p>
     * Returns {@link ExplicitWaitHandler} for explicit waits.
     * </p>
     *
     * @return An {@link ExplicitWaitHandler} for explicit waits.
     */
    ExplicitWaitHandler getExplicitWaitHandler();

    /**
     * <p>
     * Returns {@link ScreenCapturer} for capturing the screen.
     * </p>
     *
     * @return A {@link ScreenCapturer} for capturing the screen.
     */
    ScreenCapturer getScreenCapturer();

    /**
     * <p>
     * Returns {@link ScreenCapturer} for capturing the screen.
     * </p>
     *
     * @return A {@link ScreenCapturer} for capturing the screen.
     */
    MouseActions getMouseActionsHandler();

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
