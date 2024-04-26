package com.extent.reports.test.screenshot.impl;

import com.extent.reports.test.Test;
import com.extent.reports.test.screenshot.service.ScreenCapture;

import lombok.Getter;
import lombok.Setter;

/**
 * Provides an implementation of the {@code ScreenCapture} interface,
 * encapsulating the logic for capturing screenshots and integrating them into the test execution or reporting context.
 *
 * <p><font color = "maroon">
 * This implementation leverages an underlying {@code Test} generator to handle the actual snapshot
 * creation and association with the test execution context. Additionally, it supports capturing
 * screenshots from file paths and Base64 encoded strings, offering flexibility in capturing
 * screenshots from diverse sources.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code fromPath(String path)}: Delegates the capture of a screenshot from the specified
 *         file path to the underlying {@code Test} generator, utilizing a specialized method
 *         for capturing snapshots from file paths and updating the test execution context.</li>
 *     <li>{@code fromBase64Path(String base64)}: Delegates the capture of a screenshot from the
 *         provided Base64 encoded string to the underlying {@code Test} generator, utilizing a
 *         method tailored for capturing snapshots from Base64 encoded strings and updating
 *         the test execution context.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: This implementation assumes the presence of an underlying {@code Test} generator
 * capable of handling snapshot creation and association. It is essential to ensure compatibility
 * and alignment with the {@code Test} generator to facilitate seamless integration and accurate
 * representation of screenshots within test reports.
 * </p>
 *
 * <p>
 * Additionally, the class features a Base64 encoded string property to store the Base64 representation
 * of the screenshot temporarily, offering a centralized storage mechanism for managing screenshot
 * data within the class instance.
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     ScreenCapture screenCapture = new ScreenCaptureImpl();
 *     screenCapture.setBase64("Base64EncodedString");
 *     Test test = screenCapture.fromBase64Path(screenCapture.getBase64());
 * </pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see ScreenCapture
 * @see Test
 */
public final class ScreenCaptureImpl implements ScreenCapture {

    private final Test testGenerator;
    @Getter
    @Setter
    private String base64;

    public ScreenCaptureImpl(final Test testGenerator) {
        this.testGenerator = testGenerator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test fromPath(final String path) {
        return testGenerator.addSnapShotFromPath(path);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test fromBase64Path(final String base64) {
        return testGenerator.addSnapShotFromBase64String(base64);
    }
}





