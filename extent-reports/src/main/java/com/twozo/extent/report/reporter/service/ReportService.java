package com.twozo.extent.report.reporter.service;

import com.twozo.extent.report.reporter.internal.extent.AbstractExtentReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;

/**
 * Generates report generator for generating reports.
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface ReportService<T extends Reporter> {

    /**
     * Creates a default {@link ExtentReportType} reporter.
     *
     * @return A new {@link AbstractExtentReporter}.
     */
    T createReporter();
}