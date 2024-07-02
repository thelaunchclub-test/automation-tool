package com.twozo.web.driver.internal.screenshot;

import com.twozo.web.driver.service.screenshot.ScreenshotProvider;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@NonNull
@AllArgsConstructor
public class ScreenshotProviderImpl implements ScreenshotProvider {

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
    public <X> X getScreenshotAs(final OutputType<X> outputType) {

        return ((TakesScreenshot) webDriver).getScreenshotAs(outputType);

    }
}
