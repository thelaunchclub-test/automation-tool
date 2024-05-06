package com.extent.reports.test.screenshot.service;

import com.extent.reports.test.ReportTest;
import com.extent.reports.test.screenshot.impl.ScreenCaptureImpl;

/**
 * Defines the contract for capturing and integrating
 * screenshots into the testing framework or system. This interface provides methods to
 * capture screenshots from various sources, such as file paths and Base64 encoded strings,
 * and associate them with the test execution context.
 *
 * <p>
 * The interface serves as a bridge between the screenshot capture functionality and
 * the underlying test execution or reporting mechanism, facilitating the seamless
 * integration and presentation of screenshots within test reports and logs.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code fromPath(String path)}: Captures a screenshot from the specified file path
 *         and associates it with the test execution context. The method returns an updated
 *         {@code Test} object reflecting the addition of the screenshot.</li>
 *     <li>{@code fromBase64Path(String base64)}: Captures a screenshot from the provided
 *         Base64 encoded string representation of the screenshot and associates it with
 *         the test execution context. The method returns an updated {@code Test} object
 *         reflecting the addition of the screenshot.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: Implementations of this interface should handle the actual screenshot capture
 * and integration with the test execution or reporting mechanism. It is essential to
 * ensure compatibility and alignment with the underlying test framework or system
 * for seamless integration and accurate representation of screenshots within test reports.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see ScreenCaptureImpl
 * @see ReportTest
 */
public interface ScreenCapture {

    /**
     * Constructs a ReportTest instance based on the provided file path.
     * This method creates a ReportTest object using the information obtained from the specified file path.
     *
     * @param path The file path from which to construct the ReportTest instance.
     * @return A ReportTest object initialized with the provided file path.
     */
    ReportTest fromPath(final String path);

    /**
     * Captures a screenshot from the specified Base64 encoded string and associates it with
     * the test execution context.
     * This method allows capturing a screenshot represented as a Base64 encoded string
     * and associating it with the test execution context.
     *
     * @param base64 The Base64 encoded string representing the screenshot.
     * @return A ReportTest object with the screenshot associated.
     */
    ReportTest fromBase64Path(final String base64);

}


