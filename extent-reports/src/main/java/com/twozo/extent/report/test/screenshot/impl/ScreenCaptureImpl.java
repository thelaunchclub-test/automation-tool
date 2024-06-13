package com.twozo.extent.report.test.screenshot.impl;

import com.aventstack.extentreports.ExtentTest;

import com.twozo.extent.report.test.ReportTest;
import com.twozo.extent.report.test.screenshot.ScreenCapture;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * Defines the contract for capturing and integrating screenshots into the test.
 * </p>
 *
 * <p>
 * Provides methods to capture screenshots from various sources, such as file paths and Base64
 * encoded strings, and associate them with the test execution context.
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     ReportTest extentTest = screenCapture.fromPath("file path");
 * </pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see ScreenCapture
 */
@Getter
@Setter
public final class ScreenCaptureImpl implements ScreenCapture {

    private final ExtentTest extentTest;
    private String base64;

    public ScreenCaptureImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     *
     * @param path The file path.
     * @return The {@link ReportTest}.
     */
    @Override
    public ScreenCapture fromPath(final String path) {
        extentTest.addScreenCaptureFromPath(path);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param base64 The Base64 encoded string.
     * @return The {@link ReportTest}.
     */
    @Override
    public ScreenCapture fromBase64Path(final String base64) {
        extentTest.addScreenCaptureFromBase64String(base64);

        return this;
    }
}