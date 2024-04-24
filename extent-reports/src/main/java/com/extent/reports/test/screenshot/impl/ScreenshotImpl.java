package com.extent.reports.test.screenshot.impl;

import com.extent.reports.test.Test;
import com.extent.reports.test.screenshot.service.ScreenCapture;

import lombok.Getter;
import lombok.Setter;

/**
 * The ScreenshotImpl class extends the ReportMedia class and implements the ScreenCapture interface.
 * It represents a screenshot with associated attributes such as base64 data, path, title, and resolved path.
 */
public class ScreenshotImpl implements ScreenCapture {

    private Test testGenerator;
    @Getter
    @Setter
    private String base64;


    public ScreenshotImpl() {
        this.base64 = base64;
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




