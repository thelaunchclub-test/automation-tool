package com.twozo.extent.report.reporter.service;

import com.twozo.extent.report.reporter.internal.extent.AbstractExtentReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;

/**
 * <p>
 * Generates report generator for generating reports.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface ReporterService<T extends Reporter> {

    /**
     * Creates a default {@link ExtentReportType} reporter.
     *
     * @return A new {@link AbstractExtentReporter}.
     */
    T createReporter();
}