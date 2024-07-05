package com.twozo.extent.report.reporter.service;

import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.test.service.ReportTest;

/**
 * <p>
 * Allows different types of reports to be generated depending on the needs of the implementing class.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface Reporter {

    /**
     * <p>
     * Attaches the {@link ExtentReportType} into {@link Reporter}.
     * </p>
     *
     * @param reporters The {@link ExtentReportType}
     */
    void attachReporter(final Reporter... reporters);

    /**
     * <p>
     * Flushes the {@link ReportService},and closing the report.
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
    void systemInfo(final String key, final String value);

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName.
     * </p>
     *
     * @param name The testName of the {@link ReportTest}.
     * @return The newly created {@link ReportTest}.
     */
    ReportTest createTest(String name);

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName and description.
     * </p>
     *
     * @param name        The testName of the test.
     * @param description The description of the test.
     * @return The newly created test.
     */
    ReportTest createTest(String name, String description);

    /**
     * <p>
     * Retrieves the {@link ExtentSparkReporter}.
     * </p>
     *
     * @return {@link ExtentSparkReporter} used for report generation.
     */
    ExtentObserver getExtentSparkReporter();
}
