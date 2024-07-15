package com.twozo.web.driver.internal.screen.capturer;

import com.twozo.web.driver.service.ScreenCapturer;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@NonNull
@AllArgsConstructor
public class ScreenCapturerImpl implements ScreenCapturer {

    private final WebDriver webDriver;

    /**
     * <p>
     * Captures a screenshot and returns it in the specified target format.
     * </p>
     *
     * @param outputType The desired output type of the screenshot.
     * @return The screenshot in the specified format.
     */
    @Override
    public <X> X getScreenshotAs(@NonNull final OutputType<X> outputType) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(outputType);
    }
}
