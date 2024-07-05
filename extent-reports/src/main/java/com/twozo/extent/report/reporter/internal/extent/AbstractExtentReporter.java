package com.twozo.extent.report.reporter.internal.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.twozo.extent.report.reporter.internal.spark.SparkReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.service.ReportService;
import com.twozo.extent.report.reporter.service.Reporter;
import com.twozo.extent.report.test.service.ReportTest;
import com.twozo.extent.report.test.internal.ReportTestImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Serves as the foundation for creating
 * Provides the core functionalities for managing reports and test executions within the
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
 * @author Navin Jones
 * @version 1.0
 * @see Reporter
 */
public abstract class AbstractExtentReporter implements Reporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractExtentReporter.class);
    protected static ExtentReports reports;

    protected AbstractExtentReporter() {
        reports = new ExtentReports();
    }

    /**
     * {@inheritDoc}
     *
     * @param reporters The {@link ExtentReportType}
     */
    @Override
    public void attachReporter(final Reporter... reporters) {

        for (final Reporter reporter : reporters) {
            reports.attachReporter(reporter.getExtentSparkReporter());
            LOGGER.info("The Report was Attached successfully", reporters);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() {
        reports.flush();
    }

    /**
     * {@inheritDoc}
     *
     * @param name The testName of the {@link ReportTest}.
     * @return The newly created {@link ReportTest}.
     */
    @Override
    public ReportTest createTest(final String name) {
        ExtentTest extentTest = reports.createTest(name);

        return new ReportTestImpl(extentTest);
    }

    /**
     *{@inheritDoc}
     *
     * @param name        The testName of the test.
     * @param description The description of the test.
     * @return The newly created test.
     */
    @Override
    public ReportTest createTest(final String name, final String description) {
        ExtentTest extentTest = reports.createTest(name, description);

        return new ReportTestImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @param key   The type of system information (e.g., "Browser Version").
     * @param value The corresponding value of the system information (e.g., "Chrome 98").
     */
    @Override
    public void systemInfo(final String key, final String value) {
        reports.setSystemInfo(key, value);
    }

    /**
     * {@inheritDoc}
     * @return The {@link ExtentSparkReporter}
     */
    @Override
    public ExtentObserver getExtentSparkReporter() {
        return getExtentSparkReporter();
    }
}

