package com.twozo.extent.report.service;

import com.twozo.extent.report.reporter.impl.ExtentReporterImpl;

/**
 * <p>
 * Generates {@link ReportGenerator} that can be used to generate various types of reports.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * ReportGenerator generator = ReportGenerator.getInstance();
 * }</pre>
 * </p>
 *
 * @see ReportService
 */
@FunctionalInterface
public interface ReportGenerator extends ReportService {

    /**
     * <p>
     * Retrieves {@link ReportGenerator} for generating various reports.
     * </p>
     *
     * @return The {@code ReportGenerator}.
     */
    static ReportGenerator getInstance() {
        return new ExtentReporterImpl();
    }
}
