package com.twozo.extent.report.service;

import com.twozo.extent.report.reporter.SparkReporter;
import com.twozo.extent.report.test.ReportTest;

/**
 * <p>
 * Generates reports and adds the capability to manage and retrieve test contexts.
 * </p>
 *
 * @see ReportGenerator
 */
public interface ExtentReporterService extends ReportGenerator {

    /**
     * <p>
     * Flushes the {@link ExtentReporterService},and closing the report.
     * Should be called after all test logs are added to ensure the report is complete.
     * </p>
     */
    void flush();

    /**
     * <p>
     * Sets system information in the {@link ReportTest}, such as browser version or environment details.
     * </p>
     *
     * @param key   The type of system information (e.g., "Browser Version").
     * @param value The corresponding value of the system information (e.g., "Chrome 98").
     */
    void setSystemInfo(final String key, final String value);
}