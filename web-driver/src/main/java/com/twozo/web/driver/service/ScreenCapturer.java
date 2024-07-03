package com.twozo.web.driver.service;

import org.openqa.selenium.OutputType;

/**
 * <p>
 * Defines a contract for components capable of taking screenshots. Provides a method
 * to capture screenshots in various formats.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * ScreenCapturer screenshot = webAutomationDriver.getScreenshot(OutputType.FILE);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ScreenCapturer {

    /**
     * <p>
     * Captures a screenshot and returns it in the specified target format.
     * </p>
     *
     * @param outputType The desired output type of the screenshot.
     * @param <X>    The type of the screenshot output.
     * @return The screenshot in the specified format.
     */
    <X> X getScreenshotAs(final OutputType<X> outputType);
}
