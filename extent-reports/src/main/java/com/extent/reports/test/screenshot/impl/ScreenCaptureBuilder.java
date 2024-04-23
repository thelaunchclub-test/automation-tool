package com.extent.reports.test.screenshot.impl;

import lombok.Generated;

/**
 * provides a builder pattern implementation
 * for constructing ScreenCapture objects with optional attributes.
 */
public class ScreenCaptureBuilder {

    private String path;
    private String title;
    private String resolvedPath;
    private String base64;

    /**
     * Default constructor for ScreenCaptureBuilder.
     */
    ScreenCaptureBuilder() {
    }

    /**
     * Sets the path of the screenshot.
     *
     * @param path - the path to the screenshot file
     * @return ScreenCaptureBuilder - the updated ScreenCaptureBuilder instance
     */
    public ScreenCaptureBuilder path(final String path) {
        this.path = path;
        return this;
    }

    /**
     * Sets the title of the screenshot.
     *
     * @param title - the title or name of the screenshot
     * @return ScreenCaptureBuilder - the updated ScreenCaptureBuilder instance
     */
    @Generated
    public ScreenCaptureBuilder title(final String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the resolved path of the screenshot.
     *
     * @param resolvedPath - the resolved path of the screenshot file
     * @return ScreenCaptureBuilder - the updated ScreenCaptureBuilder instance
     */
    @Generated
    public ScreenCaptureBuilder resolvedPath(final String resolvedPath) {
        this.resolvedPath = resolvedPath;
        return this;
    }

    /**
     * Sets the Base64 encoded representation of the screenshot.
     *
     * @param base64 - the Base64 encoded string of the screenshot
     * @return ScreenCaptureBuilder - the updated ScreenCaptureBuilder instance
     */
    public ScreenCaptureBuilder base64(final String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Constructs a ScreenshotImpl object using the builder's attributes.
     *
     * @return ScreenshotImpl - the constructed ScreenshotImpl object
     */
    public ScreenshotImpl builder() {
        return new ScreenshotImpl();
    }
}

