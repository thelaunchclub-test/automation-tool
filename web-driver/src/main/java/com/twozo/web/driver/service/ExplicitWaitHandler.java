package com.twozo.web.driver.service;

import com.twozo.web.element.model.Element;

/**
 * <p>
 * Provides methods to handle explicit waits. Allows waiting for specific conditions to be met for {@link Element}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * ExplicitWaitHandler waitHandler = webAutomationDriver.getExplicitWaitHandler();
 * waitHandler.waitTillVisible(element);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ExplicitWaitHandler {

    /**
     * <p>
     * Waits until the specified {@link Element} is visible on the web page.
     * checks the visibility of the given element until the condition is met or a timeout occurs.
     * </p>
     *
     * @param element The {@link Element} to wait for visibility.
     */
    void waitTillVisible(final Element element);

    /**
     * <p>
     * Waits until the specified {@link Element} is clickable on the web page.
     * checks the clickability of the given element until the condition is met or a timeout occurs.
     * </p>
     *
     * @param element The {@link Element} to be clickable.
     */
    void WaitTillClickable(final Element element);

}
