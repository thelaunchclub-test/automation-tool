package com.twozo.extent.report.test.service;

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
 *     ReportTest reportTest = screenCapture.fromPath("file path");
 * </pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface ScreenCapture {

    /**
     * <p>
     * Gets a screenshot from the specified file path and attaches to the test.
     * </p>
     *
     * @param path The file path.
     * @return The {@link ReportTest}.
     */
    ScreenCapture fromPath(final String path,final String message);

    /**
     * <p>
     * Gets a screenshot from the specified Base64 encoded string and attaches to the test.
     * </p>
     *
     * @param base64 The Base64 encoded string.
     * @return The {@link ReportTest}.
     */
    ScreenCapture fromBase64Path(final String base64);
}