package com.twozo.extent.report.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.twozo.extent.report.service.ExtentReporterService;
import com.twozo.extent.report.test.ReportTest;
import com.twozo.extent.report.test.ReportTestImpl;

/**
 * Serves as the foundation for creating {@link ExtentReporterService}.
 * Provides the core functionalities for managing reports and test executions within the {@link ExtentReporterService}.
 * Decides which getReporter and tests are executed.
 * <p>
 * Key Features:
 * <ul>
 *     <li>Attaches {@link SparkReporter}</li>
 *     <li>Sets system information.</li>
 *     <li>Creates and manages {@link ReportTest}</li>
 *     <li>Flushes the report to write logs and close the report.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * CustomExtentReporter getReporter = new CustomExtentReporter("path/to/report");
 * getReporter.generateReport();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ExtentReporterService
 * @see ExtentReports
 * @see ExtentTest
 */
public abstract class AbstractExtentReporter implements ExtentReporterService {

    protected final ExtentReports reports;

    protected AbstractExtentReporter() {
        this.reports = new ExtentReports();
    }

    /**
     * <p>
     * Flushes the {@link ExtentReporterService},and closing the report.
     * Should be called after all test logs are added to ensure the report is complete.
     * </p>
     */
    public void flush() {
        reports.flush();
    }

    /**
     * <p>
     * Sets system information in the {@link ReportTest}, such as browser version or environment details.
     * </p>
     *
     * @param key   The type of system information (e.g., "Browser Version").
     * @param value The corresponding value of the system information (e.g., "Chrome 98").
     */
    public void setSystemInfo(final String key, final String value) {
        reports.setSystemInfo(key, value);
    }

    /**
     * <p>
     * Attaches one or more reporters to the {@link ExtentReporterService}. Supports
     * varargs input, allowing for zero or more {@link Reporter} to be passed.
     * </p>
     *
     * @param reporters Array of {@link Reporter} to be attached
     * @param <T>       Type of the reporter, which extends {@link AbstractExtentReporter}
     */
    @SafeVarargs
    public final <T extends AbstractExtentReporter> void attachReporter(final Reporter<T>... reporters) {

        for (final Reporter<?> reporter : reporters) {
            reports.attachReporter(reporter.getExtentSparkReporter());
        }
    }

    /**
     * <p>
     * Intended to be overridden by subclasses to provide a specific implementation
     * </p>
     *
     * @return {@link AbstractExtentReporter}.
     * @see #getReporter(String)
     */
    public AbstractExtentReporter getReporter() {
        return null;
    }

    /**
     * <p>
     * Creates and return an {@link AbstractExtentReporter}
     * configured to generate reports at the specified path.
     * </p>
     *
     * @param path The file path where the report will be generated.
     * @return {@link AbstractExtentReporter} configured to generate reports at the specified path.
     * @see #getReporter()
     */
    protected abstract AbstractExtentReporter getReporter(final String path);

    /**
     * <p>
     * Returns an {@link ReportTest} by creating a new {@link ReportTestImpl}
     * with the current reports instance.
     * </p>
     *
     * @return a new {@link ReportTestImpl}.
     */
    public ReportTest getReportTest() {
        return new ReportTestImpl(reports);
    }
}
