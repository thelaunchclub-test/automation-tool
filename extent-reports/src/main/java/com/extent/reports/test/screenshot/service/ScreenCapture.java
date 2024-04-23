package com.extent.reports.test.screenshot.service;


import com.extent.reports.test.Test;

/**
 * defines the contract for capturing screenshots.
 * It specifies methods for capturing screenshots from a file path or a Base64 encoded string.
 */
public interface ScreenCapture {

    /**
     * Captures a screenshot from the specified path.
     *
     * @param path - the path to the screenshot file
     * @return Test - the updated Test object after adding the screenshot
     */
    Test fromPath(final String path);

    /**
     * Captures a screenshot from the specified Base64 encoded string.
     *
     * @param base64 - the Base64 encoded string of the screenshot
     * @return Test - the updated Test object after adding the screenshot
     */
    Test fromBase64Path(final String base64);
}

