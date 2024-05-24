package com.twozo.web.driver.screenshot;

import org.openqa.selenium.OutputType;

/**
 * <p>
 * The {@code TakesScreenshots} defines a contract for components capable of taking screenshots.
 * Provide a method to capture screenshots in various formats.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface TakesScreenshots {
    /**
     * <p>
     * Captures a screenshot and returns it in the specified target format.
     * </p>
     *
     * @param target the desired output type of the screenshot.
     * @param <X>    the type of the screenshot output.
     * @return the screenshot in the specified format.
     */
    <X> X getScreenshotAs(final OutputType<X> target);
}
