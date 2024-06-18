package com.twozo.extent.report.reporter.impl;

import com.twozo.extent.report.service.ReportGenerator;
import com.twozo.extent.report.service.ReportService;

/**
 * Manages and generates reports using {@link ReportGenerator}.
 * Handles the creation, configuration, and finalization of reports
 *
 * <p>
 * Demonstrates how to create a test, log a pass status, and finalize the report.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportService
 */
public final class ExtentReportServiceImpl implements ReportService {

    /**
     * {@inheritDoc}
     *
     * @return A new {@link ExtentReporterImpl}.
     */
    @Override
    public ReportGenerator getReport() {
        return new ExtentReporterImpl();
    }
}